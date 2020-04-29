package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodTypeDtoMapper implements RowMapper<FoodTypeDto> {
    @Override
    public FoodTypeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FoodTypeDto(rs.getLong("id"), rs.getString("name"), rs.getString("description"));
    }
}
