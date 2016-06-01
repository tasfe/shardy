package maniac.lee.shardy.core.wrap;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Created by peng on 16/6/1.
 */
public class WrapConnection implements Connection {
    static final String errorMsg = "unsupported sql execution";

    @Override
    public Statement createStatement() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {

    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void commit() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void rollback() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void close() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public boolean isClosed() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public String getCatalog() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public int getHoldability() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Clob createClob() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Blob createBlob() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public NClob createNClob() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public String getSchema() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        unsupported();
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException(errorMsg);
    }

    private void unsupported() throws SQLException {
        throw new SQLException(errorMsg);
    }

    private void unsupportedSQLClientInfo() throws SQLClientInfoException {
        throw new UnsupportedOperationException(errorMsg);
    }
}
