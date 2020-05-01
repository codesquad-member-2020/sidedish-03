package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.DishDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDtoMapper implements RowMapper<DishDto> {

    @Override
    public DishDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        DishDto dishDto = new DishDto();
        dishDto.setTopImage(rs.getString("top_image"));
        dishDto.setDescription(rs.getString("description"));
        dishDto.setPoint(rs.getString("point"));
        dishDto.setDeliveryInfo(rs.getString("delivery_info"));
        dishDto.setDeliveryFee(rs.getString("delivery_fee"));
        dishDto.setNormalPrice(rs.getString("normal_price"));
        dishDto.setSalePrice(rs.getString("sale_price"));
        return dishDto;
    }
}
