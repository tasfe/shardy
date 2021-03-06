package maniac.lee.shardy.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.PreparedStatementLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import maniac.lee.shardy.SqlParseException;
import maniac.lee.shardy.config.ShardConfig;
import maniac.lee.shardy.config.ShardStrategyContext;
import maniac.lee.shardy.config.ShardResult;
import maniac.lee.shardy.config.TableConfig;
import maniac.lee.shardy.datasource.DynamicDataSource;
import maniac.lee.shardy.sqlparser.ColumnValue;
import maniac.lee.shardy.sqlparser.DruidSqlParser;
import maniac.lee.shardy.sqlparser.ISqlParser;
import maniac.lee.shardy.sqlparser.SqlType;
import maniac.lee.shardy.util.ReflectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),
        //        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        //        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        //        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
@Deprecated
public class ShardInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        /** statement is new Object with different memory address */
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        ISqlParser iSqlParser = new DruidSqlParser();
        try {
            iSqlParser.init(sql);
        } catch (Exception e) {
            e.printStackTrace();
            /** let go of the unknown sql */
            return invocation.proceed();
        }

        String table = iSqlParser.getTableName();
        /** if no table found , let go , maybe some wired but legal sql or mybatis sql like "select #{id}" in SelectKey */
        if(StringUtils.isBlank(table))
            return invocation.proceed();
        TableConfig tableConfig = ShardConfig.getTableConfig(table);
        if (tableConfig != null) {
            Object masterValue = findMasterValue(iSqlParser, boundSql, tableConfig);
            if (masterValue == null)
                throw new SqlParseException("no master value is found:" + sql);
            ShardResult re = tableConfig.getShardStrategy().map(new ShardStrategyContext(masterValue, table));
            String destTable = re.getTableName();
            if (StringUtils.isNotBlank(destTable)) {
                iSqlParser.setTableName(re.getTableName());
                String sqlResult = iSqlParser.toSql();
                System.out.println("sqlResult->" + sqlResult);
                ReflectionUtils.setDeclaredFieldValue(boundSql, "sql", sqlResult);
            }

            String db = re.getDbName();
            if (StringUtils.isNoneBlank(db)) {
                DynamicDataSource.setDb(db);
            } else {
                DynamicDataSource.setDbDefault();
            }
        }

        return invocation.proceed();
    }

    private Object findMasterValue(ISqlParser iSqlParser, BoundSql boundSql, TableConfig tableConfig) throws SqlParseException {
        if (iSqlParser.getType() == SqlType.INSERT) {
            /** Insert */
            List<ColumnValue> columnValues = iSqlParser.getColumns();
            for (int i = 0; i < columnValues.size(); i++) {
                if (columnValues.get(i).column.equals(tableConfig.getMasterColumn())) {
                    try {
                        return ReflectionUtils.getFieldValue(boundSql.getParameterObject(), boundSql.getParameterMappings().get(i).getProperty());
                    } catch (Exception e) {
                        throw new SqlParseException("failed to parse property:" + boundSql.getParameterMappings().get(i).getProperty());
                    }
                }
            }
        } else {
            /** Select/Update/Delete -> columns from "where" clause */
            if (boundSql.getParameterObject() instanceof MapperMethod.ParamMap) {
                return getColumnValue(tableConfig.getMasterColumn(), iSqlParser, boundSql);
            }
        }
        return null;
    }

    private Object getColumnValue(String columnName, ISqlParser iSqlParser, BoundSql boundSql) {
        MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) boundSql.getParameterObject();
        List<ColumnValue> cols = iSqlParser.getColumns();
        for (int i = 0; i < cols.size(); i++) {
            if (Objects.equals(cols.get(i).column, columnName)) {
                //                if (cols.get(i).value.equals("?")) //TODO
                return paramMap.get(boundSql.getParameterMappings().get(i).getProperty());
            }
        }
        return null;
    }

    public void init(Collection<TableConfig> tableConfigs) {
        ShardConfig.init(tableConfigs);
    }

    public Object interceptQuery(Invocation invocation) throws Throwable {
        /** statement is new Object with different memory address */
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        System.out.println(statementHandler.getClass());
        System.out.println("sql->" + sql);
        ISqlParser iSqlParser = new DruidSqlParser();
        iSqlParser.init(sql);
        iSqlParser.setTableName("fuck");

        String masterColumn = "id";
        if (boundSql.getParameterObject() instanceof MapperMethod.ParamMap) {
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) boundSql.getParameterObject();
            Object masterValue = paramMap.get(masterColumn);
            System.out.println("param-> " + masterValue);
        }

        String sqlResult = iSqlParser.toSql();
        System.out.println("sqlResult->" + sqlResult);

        Statement statement = (Statement) invocation.getArgs()[0];
        ReflectionUtils.setDeclaredFieldValue(boundSql, "sql", sqlResult);

        Object h = ReflectionUtils.getFieldValue(statement, "h");
        if (h instanceof PreparedStatementLogger) {
            PreparedStatementLogger preparedStatementLogger = (PreparedStatementLogger) h;
            PreparedStatement preparedStatement = preparedStatementLogger.getPreparedStatement();
        }
        System.out.println(statement.getClass().getName());
        System.out.println("sta-> " + statementHandler);
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }

}