package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import kr.codesquad.sidedish.business.mapper.BadgeDtoMapper;
import kr.codesquad.sidedish.business.mapper.DishOverviewDtoMapper;
import kr.codesquad.sidedish.business.mapper.FoodTypeDtoMapper;
import kr.codesquad.sidedish.common.error.exception.FoodTypeNotFoundException;
import kr.codesquad.sidedish.common.util.NamedParameterOptionalJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.codesquad.sidedish.business.sql.SQLKt.*;

@Repository
public class FoodTypeDaoDion implements FoodTypeDao {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeDaoDion.class);

    private final NamedParameterOptionalJdbcTemplate jdbcTemplate;
    private final FoodTypeDtoMapper foodTypeDtoMapper = new FoodTypeDtoMapper();
    private final DishOverviewDtoMapper dishOverViewDtoMapper = new DishOverviewDtoMapper();
    private final BadgeDtoMapper badgeDtoMapper = new BadgeDtoMapper();

    public FoodTypeDaoDion(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterOptionalJdbcTemplate(dataSource);
    }

    @Override
    public List<FoodTypeDto> findAllFoodTypes() {
        List<FoodTypeDto> foodTypes = jdbcTemplate.query(ALL_FOOD_TYPE_SQL, foodTypeDtoMapper);

        for (FoodTypeDto foodType : foodTypes) {
            fillDishOverView(foodType, new MapSqlParameterSource("id", foodType.getId()));
        }

        return foodTypes;
    }

    @Override
    public FoodTypeDto findDishesByFoodTypeId(Long foodTypeId) {
        log.debug("foodTypeId: {}", foodTypeId);
        MapSqlParameterSource parameters = new MapSqlParameterSource("id", foodTypeId);

        FoodTypeDto foodType = jdbcTemplate.queryForOptionalObject(FOOD_TYPE_SQL, parameters, foodTypeDtoMapper)
                                           .orElseThrow(FoodTypeNotFoundException::new);

        fillDishOverView(foodType, parameters);
        return foodType;
    }

    private void fillDishOverView(FoodTypeDto foodType, MapSqlParameterSource parameters) {
        List<DishOverviewDto> dishes = jdbcTemplate.query(DISH_OVERVIEW_SQL, parameters, dishOverViewDtoMapper);

        for (DishOverviewDto dish : dishes) {
            MapSqlParameterSource dishParameters = new MapSqlParameterSource("id", dish.getId());
            dish.setBadges(jdbcTemplate.query(BADGE_SQL, dishParameters, badgeDtoMapper));
            dish.setDeliveryTypes(jdbcTemplate.queryForList(DELIVERY_TYPE_SQL, dishParameters, String.class));
        }
        foodType.setDishes(dishes);
    }

}
