package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.BadgeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BadgeDtoMapper implements RowMapper<BadgeDto> {

    @Override
    public BadgeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BadgeDto(rs.getString("name"), rs.getString("color"));
    }
}
