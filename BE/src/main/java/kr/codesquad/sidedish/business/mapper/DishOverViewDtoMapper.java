package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishOverviewDtoMapper implements RowMapper<DishOverviewDto> {
    @Override
    public DishOverviewDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        DishOverviewDto dishOverviewDto = new DishOverviewDto();
        dishOverviewDto.setId(rs.getLong("id"));
        dishOverviewDto.setMainImage(rs.getString("main_image"));
        dishOverviewDto.setAlt(rs.getString("alt"));
        dishOverviewDto.setTitle(rs.getString("title"));
        dishOverviewDto.setNormalPrice(rs.getString("normal_price"));
        dishOverviewDto.setSalePrice(rs.getString("sale_price"));
        return dishOverviewDto;
    }
}
