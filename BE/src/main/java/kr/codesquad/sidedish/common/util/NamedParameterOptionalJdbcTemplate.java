package kr.codesquad.sidedish.common.util;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

public class NamedParameterOptionalJdbcTemplate extends NamedParameterJdbcTemplate {
    public NamedParameterOptionalJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public <T> Optional<T> queryForOptionalObject(String sql, SqlParameterSource parameterSource, RowMapper<T> rowMapper) {
        return getJdbcOperations().query(getPreparedStatementCreator(sql, parameterSource), rowMapper).stream().findFirst();
    }

    public <T> Optional<T> queryForOptionalObject(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper) {
        return queryForOptionalObject(sql, new MapSqlParameterSource(paramMap), rowMapper);
    }

    public <T> Optional<T> queryForOptionalObject(String sql, SqlParameterSource parameterSource, Class<T> requiredType) {
        return queryForOptionalObject(sql, parameterSource, new SingleColumnRowMapper<>(requiredType));
    }

    public <T> Optional<T> queryForOptionalObject(String sql, Map<String, ?> paramMap, Class<T> requiredType) {
        return queryForOptionalObject(sql, paramMap, new SingleColumnRowMapper<>(requiredType));
    }
}
