package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishOverviewDtoMapper implements RowMapper<DishOverviewDto> {
    @Override
    public DishOverviewDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DishOverviewDto.Builder(rs.getLong("id"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .mainImage(rs.getString("main_image"))
                .alt(rs.getString("alt"))
                .normalPrice(rs.getString("normal_price"))
                .salePrice(rs.getString("sale_price"))
                .build();
    }
}
