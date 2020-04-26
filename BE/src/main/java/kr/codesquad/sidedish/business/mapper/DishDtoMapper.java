package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.DishDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDtoMapper implements RowMapper<DishDto> {

    @Override
    public DishDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DishDto.Builder()
                .topImage(rs.getString("top_image"))
                .description(rs.getString("description"))
                .point(rs.getLong("point"))
                .deliveryInfo(rs.getString("delivery_info"))
                .deliveryFee(rs.getString("delivery_fee"))
                .normalPrice(rs.getLong("normal_price"))
                .salePrice(rs.getLong("sale_price"))
                .build();
    }
}
