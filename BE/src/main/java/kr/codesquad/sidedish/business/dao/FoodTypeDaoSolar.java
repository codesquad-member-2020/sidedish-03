package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import kr.codesquad.sidedish.business.mapper.BadgeDtoMapper;
import kr.codesquad.sidedish.business.mapper.DishOverviewDtoMapper;
import kr.codesquad.sidedish.business.mapper.FoodTypeDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FoodTypeDaoSolar implements FoodTypeDao {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeDaoSolar.class);
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplat;
    private final FoodTypeDtoMapper foodTypeDtoMapper = new FoodTypeDtoMapper();
    private final DishOverviewDtoMapper dishOverviewDtoMapper = new DishOverviewDtoMapper();
    private final BadgeDtoMapper badgeDtoMapper = new BadgeDtoMapper();

    public FoodTypeDaoSolar(DataSource dataSource) {
        this.namedParameterJdbcTemplat = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<FoodTypeDto> findAllFoodTypes() {
        String sqlAllFoodTypes = "select id, name, description from food_type";
        List<FoodTypeDto> foodTypeDtos = namedParameterJdbcTemplat.query(sqlAllFoodTypes, foodTypeDtoMapper);
        for (FoodTypeDto foodTypeDto : foodTypeDtos) {
            referDishOverview(new MapSqlParameterSource("id", foodTypeDto.getId()), foodTypeDto);
        }
        return foodTypeDtos;
    }

    @Override
    public FoodTypeDto findDishesByFoodTypeId(Long foodTypeId) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", foodTypeId);

        String sqlFindFoodType = "SELECT id, name, description FROM food_type WHERE id = :id";
        FoodTypeDto foodTypeDto = namedParameterJdbcTemplat.queryForObject(sqlFindFoodType, parameters, foodTypeDtoMapper);

        referDishOverview(parameters, foodTypeDto);

        return foodTypeDto;
    }

    private void referDishOverview(SqlParameterSource parameters, FoodTypeDto foodTypeDto) {
        String sqlDishesOverview = "SELECT sd.id, image.url AS main_image, sd.alt, sd.title, sd.description" +
                ", FORMAT(sd.normal_price, 0) AS normal_price" +
                ", FORMAT(sd.sale_price, 0) AS sale_price" +
                " FROM side_dish sd" +
                " LEFT OUTER JOIN image ON sd.main_image = image.id" +
                " WHERE sd.food_type = :id";
        List<DishOverviewDto> dishes = namedParameterJdbcTemplat.query(sqlDishesOverview, parameters, dishOverviewDtoMapper);

        String sqlDeliveryType = "SELECT dt.name" +
                " FROM side_dish sd" +
                " INNER JOIN delivery_type_side_dish dtsd ON sd.id = dtsd.side_dish" +
                " INNER JOIN delivery_type dt ON dtsd.delivery_type = dt.id" +
                " WHERE sd.id = :id";
        String sqlBadgeType = "SELECT badge.name, badge.color" +
                " FROM side_dish sd"+
                " INNER JOIN badge_side_dish bsd ON sd.id = bsd.side_dish" +
                " INNER JOIN badge ON bsd.badge = badge.id" +
                " WHERE sd.id = :id";

        for (DishOverviewDto dish : dishes) {
            SqlParameterSource parameterDishId = new MapSqlParameterSource("id", dish.getId());
            dish.setDeliveryTypes(namedParameterJdbcTemplat.queryForList(sqlDeliveryType, parameterDishId, String.class));
            dish.setBadges(namedParameterJdbcTemplat.query(sqlBadgeType, parameterDishId, badgeDtoMapper));
        }
        foodTypeDto.setDishes(dishes);
    }
}
