package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.BadgeDto;
import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import kr.codesquad.sidedish.common.error.exception.FoodTypeNotFoundException;
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
public class FoodTypeDaoDion implements FoodTypeDao {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeDaoDion.class);

    private final NamedParameterOptionalJdbcTemplate jdbcTemplate;
    private final RowMapper<FoodTypeDto> foodTypeMapper;
    private final RowMapper<DishOverviewDto> dishOverViewMapper;
    private final RowMapper<BadgeDto> badgeMapper;

    public FoodTypeDaoDion(DataSource dataSource,
                           RowMapper<FoodTypeDto> foodTypeMapper,
                           RowMapper<DishOverviewDto> dishOverViewMapper,
                           RowMapper<BadgeDto> badgeMapper) {
        this.jdbcTemplate = new NamedParameterOptionalJdbcTemplate(dataSource);
        this.foodTypeMapper = foodTypeMapper;
        this.dishOverViewMapper = dishOverViewMapper;
        this.badgeMapper = badgeMapper;
    }

    @Override
    public List<FoodTypeDto> findAllFoodTypes() {
        List<FoodTypeDto> foodTypes = jdbcTemplate.query(ALL_FOOD_TYPE_SQL, foodTypeMapper);

        for (FoodTypeDto foodType : foodTypes) {
            fillDishOverView(foodType, new MapSqlParameterSource("id", foodType.getId()));
        }

        return foodTypes;
    }

    @Override
    public FoodTypeDto findDishesByFoodTypeId(Long foodTypeId) {
        log.debug("foodTypeId: {}", foodTypeId);
        MapSqlParameterSource parameters = new MapSqlParameterSource("id", foodTypeId);

        FoodTypeDto foodType = jdbcTemplate.queryForOptionalObject(FOOD_TYPE_SQL, parameters, foodTypeMapper)
                                           .orElseThrow(FoodTypeNotFoundException::new);

        fillDishOverView(foodType, parameters);
        return foodType;
    }

    private void fillDishOverView(FoodTypeDto foodType, MapSqlParameterSource parameters) {
        List<DishOverviewDto> dishes = jdbcTemplate.query(DISH_OVERVIEW_SQL, parameters, dishOverViewMapper);

        for (DishOverviewDto dish : dishes) {
            MapSqlParameterSource dishParameters = new MapSqlParameterSource("id", dish.getId());
            dish.setBadges(jdbcTemplate.query(BADGE_SQL, dishParameters, badgeMapper));
            dish.setDeliveryTypes(jdbcTemplate.queryForList(DELIVERY_TYPE_SQL, dishParameters, String.class));
        }
        foodType.setDishes(dishes);
    }

}
