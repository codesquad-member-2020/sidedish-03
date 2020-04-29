package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.BadgeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BadgeDtoMapper implements RowMapper<BadgeDto> {

    @Override
    public BadgeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BadgeDto badgeDto = new BadgeDto();
        badgeDto.setName(rs.getString("name"));
        badgeDto.setColor(rs.getString("color"));
        return badgeDto;
    }
}
