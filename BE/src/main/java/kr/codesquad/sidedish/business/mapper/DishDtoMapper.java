package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.ktdto.DishDto;
import kr.codesquad.sidedish.business.wrapper.Money;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDtoMapper implements RowMapper<DishDto> {
    @Override
    public DishDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DishDto(
                rs.getString("top_image"),
                rs.getString("description"),
                Money.valueOf(rs.getLong("point")).format(),
                rs.getString("delivery_info"),
                rs.getString("delivery_fee"),
                Money.valueOf(rs.getLong("normal_price")).format(),
                Money.valueOf(rs.getLong("sale_price")).format()
        );
    }
}
