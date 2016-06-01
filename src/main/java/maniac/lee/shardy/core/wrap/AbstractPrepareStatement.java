package maniac.lee.shardy.core.wrap;

import maniac.lee.shardy.core.ShardyStatement;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by peng on 16/6/1.
 */
public abstract class AbstractPrepareStatement extends ShardyStatement implements PreparedStatement {
    private List<Object> parameters = new ArrayList();
    private ParameterMetaData metadata;
    private ResultSetMetaData resultSetMetaData;

    public List<Object> getParameters() {
        return parameters;
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        this.checkOpen();
        return this.metadata;
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        this.checkOpen();
        return this.resultSetMetaData;
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        this.parameters.add(parameterIndex - 1, (Object) null);
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        this.parameters.add(parameterIndex - 1, Boolean.valueOf(x));
    }

    public void setByte(int parameterIndex, byte x) throws SQLException {
        this.parameters.add(parameterIndex - 1, Byte.valueOf(x));
    }

    public void setShort(int parameterIndex, short x) throws SQLException {
        this.parameters.add(parameterIndex - 1, Short.valueOf(x));
    }

    public void setInt(int parameterIndex, int x) throws SQLException {
        this.parameters.add(parameterIndex - 1, Integer.valueOf(x));
    }

    public void setLong(int parameterIndex, long x) throws SQLException {
        this.parameters.add(parameterIndex - 1, Long.valueOf(x));
    }

    public void setFloat(int parameterIndex, float x) throws SQLException {
        this.parameters.add(parameterIndex - 1, Float.valueOf(x));
    }

    public void setDouble(int parameterIndex, double x) throws SQLException {
        this.parameters.add(parameterIndex - 1, Double.valueOf(x));
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setString(int parameterIndex, String x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setDate(int parameterIndex, Date x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setTime(int parameterIndex, Time x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void clearParameters() throws SQLException {
        this.checkOpen();
        this.parameters.clear();
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setObject(int parameterIndex, Object x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void addBatch() throws SQLException {
        this.checkOpen();
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        this.parameters.add(parameterIndex - 1, reader);
    }

    public void setRef(int parameterIndex, Ref x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setArray(int parameterIndex, Array x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        this.parameters.add(parameterIndex - 1, (Object) null);
    }

    public void setURL(int parameterIndex, URL x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setNString(int parameterIndex, String value) throws SQLException {
        this.parameters.add(parameterIndex - 1, value);
    }

    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        this.parameters.add(parameterIndex - 1, value);
    }

    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        this.parameters.add(parameterIndex - 1, value);
    }

    public void setClob(int parameterIndex, Reader value, long length) throws SQLException {
        this.parameters.add(parameterIndex - 1, value);
    }

    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        this.parameters.add(parameterIndex - 1, inputStream);
    }

    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        this.parameters.add(parameterIndex - 1, reader);
    }

    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        this.parameters.add(parameterIndex - 1, xmlObject);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        this.parameters.add(parameterIndex - 1, reader);
    }

    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        this.parameters.add(parameterIndex - 1, x);
    }

    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        this.parameters.add(parameterIndex - 1, reader);
    }

    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        this.parameters.add(parameterIndex - 1, value);
    }

    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        this.parameters.add(parameterIndex - 1, reader);
    }

    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        this.parameters.add(parameterIndex - 1, inputStream);
    }

    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        this.parameters.add(parameterIndex - 1, reader);
    }
}
