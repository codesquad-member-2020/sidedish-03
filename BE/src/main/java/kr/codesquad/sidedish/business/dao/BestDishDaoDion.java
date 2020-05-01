package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.BadgeDto;
import kr.codesquad.sidedish.business.dto.BestDishDto;
import kr.codesquad.sidedish.business.dto.CategoryDto;
import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.common.error.exception.CategoryNotFoundException;
import kr.codesquad.sidedish.common.util.NamedParameterOptionalJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.codesquad.sidedish.business.sql.SQLKt.*;

@Repository
public class BestDishDaoDion implements BestDishDao {
    private static final Logger log = LoggerFactory.getLogger(BestDishDaoDion.class);

    private final NamedParameterOptionalJdbcTemplate jdbcTemplate;
    private final RowMapper<CategoryDto> categoryMapper;
    private final RowMapper<DishOverviewDto> dishOverViewMapper;
    private final RowMapper<BadgeDto> badgeMapper;

    public BestDishDaoDion(DataSource dataSource,
                           RowMapper<CategoryDto> categoryMapper,
                           RowMapper<DishOverviewDto> dishOverViewMapper,
                           RowMapper<BadgeDto> badgeMapper) {
        this.jdbcTemplate = new NamedParameterOptionalJdbcTemplate(dataSource);
        this.categoryMapper = categoryMapper;
        this.dishOverViewMapper = dishOverViewMapper;
        this.badgeMapper = badgeMapper;
    }

    @Override
    public BestDishDto findBestDishes() {
        List<CategoryDto> categories = jdbcTemplate.query(ALL_CATEGORIES_SQL, categoryMapper);

        for (CategoryDto category : categories) {
            MapSqlParameterSource parameters = new MapSqlParameterSource("id", category.getCategoryId());
            fillItems(category, parameters);
        }

        return BestDishDto.of(categories);
    }

    @Override
    public CategoryDto findBestDish(Long categoryId) {
        log.debug("categoryId: {}", categoryId);

        MapSqlParameterSource parameters = new MapSqlParameterSource("id", categoryId);

        CategoryDto categoryDto = jdbcTemplate.queryForOptionalObject(CATEGORY_SQL, parameters, categoryMapper)
                                              .orElseThrow(CategoryNotFoundException::new);
        fillItems(categoryDto, parameters);
        return categoryDto;
    }

    private void fillItems(CategoryDto category, MapSqlParameterSource parameters) {
        List<DishOverviewDto> items = jdbcTemplate.query(CATEGORY_DISH_OVERVIEW_SQL, parameters, dishOverViewMapper);
        for (DishOverviewDto item : items) {
            MapSqlParameterSource dishParameters = new MapSqlParameterSource("id", item.getId());
            item.setBadges(jdbcTemplate.query(BADGE_SQL, dishParameters, badgeMapper));
            item.setDeliveryTypes(jdbcTemplate.queryForList(DELIVERY_TYPE_SQL, dishParameters, String.class));
        }
        category.setItems(items);
    }
}
