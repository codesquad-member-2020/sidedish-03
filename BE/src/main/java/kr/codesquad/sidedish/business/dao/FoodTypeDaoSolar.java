package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import kr.codesquad.sidedish.business.dto.BadgeDto;
import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class FoodTypeDaoSolar implements FoodTypeDao {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeDaoSolar.class);
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplat;

    public FoodTypeDaoSolar(DataSource dataSource) {
        this.namedParameterJdbcTemplat = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<FoodTypeDto> findAllFoodType() {
        return null;
    }

    public FoodTypeDto findDishesByFoodTypeId(Long foodTypeId) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", foodTypeId);

        String sqlFindFoodType = "SELECT id, name, description FROM food_type WHERE id = :id";
        FoodTypeDto foodTypeDto = namedParameterJdbcTemplat.queryForObject(sqlFindFoodType, parameters, (ResultSet rs, int rowNum) -> {
            FoodTypeDto dto = new FoodTypeDto();
            dto.setId(rs.getLong("id"));
            dto.setName(rs.getString("name"));
            dto.setDescription(rs.getString("description"));
            return dto;
        });

        String sqlDishesOverview = "SELECT sd.id, image.url AS main_image, sd.alt, sd.title, sd.description, sd.normal_price, sd.sale_price" +
                ", FORMAT(sd.normal_price, 0) AS normal_price" +
                ", FORMAT(sd.sale_price, 0) AS sale_price" +
                " FROM side_dish sd" +
                " LEFT OUTER JOIN image ON sd.main_image = image.id" +
                " WHERE sd.food_type = :id";
        List<DishOverviewDto> dishes = namedParameterJdbcTemplat.query(sqlDishesOverview, parameters, (ResultSet rs, int rowNum) -> {
            DishOverviewDto dto = new DishOverviewDto();
            dto.setId(rs.getLong("id"));
            dto.setMainImage(rs.getString("main_image"));
            dto.setAlt(rs.getString("alt"));
            dto.setTitle(rs.getString("title"));
            dto.setNormalPrice(rs.getString("normal_price"));
            dto.setSalePrice(rs.getString("sale_price"));
            return dto;
        });

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
            dish.setBadges(namedParameterJdbcTemplat.query(sqlBadgeType, parameterDishId, (ResultSet rs, int rowNum) -> {
                BadgeDto badgeDto = new BadgeDto();
                badgeDto.setName(rs.getString("name"));
                badgeDto.setColor(rs.getString("color"));
                return badgeDto;
            }));
        }
        foodTypeDto.setDishes(dishes);

        return foodTypeDto;
    }
}
