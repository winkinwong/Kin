package dev.application.global;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@MappedTypes({LocalDateTime.class})
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return LocalDateTime.ofEpochSecond(rs.getLong(columnName)/1000, 0, ZoneOffset.ofHours(8));
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return LocalDateTime.ofEpochSecond(rs.getLong(columnIndex)/1000, 0, ZoneOffset.ofHours(8));
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return LocalDateTime.ofEpochSecond(cs.getLong(columnIndex)/1000, 0, ZoneOffset.ofHours(8));
    }
}
