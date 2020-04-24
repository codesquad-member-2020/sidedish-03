package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import kr.codesquad.sidedish.business.mapper.BadgeDtoMapper;
import kr.codesquad.sidedish.business.mapper.DishOverViewDtoMapper;
import kr.codesquad.sidedish.business.mapper.FoodTypeDtoMapper;
import kr.codesquad.sidedish.common.util.NamedParameterOptionalJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.codesquad.sidedish.business.sql.SQLKt.ALL_FOOD_TYPE_SQL;
import static kr.codesquad.sidedish.business.sql.SQLKt.BADGE_SQL;
import static kr.codesquad.sidedish.business.sql.SQLKt.DELIVERY_TYPE_SQL;
import static kr.codesquad.sidedish.business.sql.SQLKt.DISH_OVERVIEW_SQL;

@Repository
public class FoodTypeDaoDion implements FoodTypeDao {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeDaoDion.class);

    private final NamedParameterOptionalJdbcTemplate jdbcTemplate;
    private final FoodTypeDtoMapper foodTypeDtoMapper = new FoodTypeDtoMapper();
    private final DishOverViewDtoMapper dishOverViewDtoMapper = new DishOverViewDtoMapper();
    private final BadgeDtoMapper badgeDtoMapper = new BadgeDtoMapper();

    public FoodTypeDaoDion(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterOptionalJdbcTemplate(dataSource);
    }

    @Override
    public List<FoodTypeDto> findAllFoodType() {
        List<FoodTypeDto> foodTypes = jdbcTemplate.query(ALL_FOOD_TYPE_SQL, foodTypeDtoMapper);

        for (FoodTypeDto foodType : foodTypes) {
            List<DishOverviewDto> dishes = jdbcTemplate.query(DISH_OVERVIEW_SQL,
                    new MapSqlParameterSource("id", foodType.getId()),
                    dishOverViewDtoMapper);

            for (DishOverviewDto dish : dishes) {
                MapSqlParameterSource parameters = new MapSqlParameterSource("id", dish.getId());
                dish.setBadges(jdbcTemplate.query(BADGE_SQL, parameters, badgeDtoMapper));
                dish.setDeliveryTypes(jdbcTemplate.queryForList(DELIVERY_TYPE_SQL, parameters, String.class));
            }
            foodType.setDishes(dishes);
        }

        return foodTypes;
    }

    @Override
    public List<DishOverviewDto> findDishesByFoodTypeId(Long foodTypeId) {
        log.debug("foodTypeId: {}", foodTypeId);

        List<DishOverviewDto> dishes = jdbcTemplate.query(DISH_OVERVIEW_SQL,
                new MapSqlParameterSource("id", foodTypeId),
                dishOverViewDtoMapper);

        for (DishOverviewDto dish : dishes) {
            MapSqlParameterSource parameters = new MapSqlParameterSource("id", dish.getId());
            dish.setBadges(jdbcTemplate.query(BADGE_SQL, parameters, badgeDtoMapper));
            dish.setDeliveryTypes(jdbcTemplate.queryForList(DELIVERY_TYPE_SQL, parameters, String.class));
        }
        return dishes;
    }

}
