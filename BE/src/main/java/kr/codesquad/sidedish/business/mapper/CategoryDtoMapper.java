package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.CategoryDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDtoMapper implements RowMapper<CategoryDto> {
    @Override
    public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(rs.getLong("id"));
        categoryDto.setCategoryName(rs.getString("name"));
        return categoryDto;
    }
}
