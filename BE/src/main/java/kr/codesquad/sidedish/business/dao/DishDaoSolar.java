package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DishDaoSolar implements DishDao {
    private static final Logger log = LoggerFactory.getLogger(DishDaoSolar.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DishDaoSolar(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public DishDto findDishById(Long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

        String sqlDefaultInfo = "SELECT image.url AS top_image, description, FORMAT(sd.point, 0) AS point, delivery_info, delivery_fee, FORMAT(normal_price, 0) AS normal_price, FORMAT(sale_price, 0) AS sale_price" +
                " FROM side_dish sd" +
                " JOIN image ON sd.top_image = image.id" +
                " WHERE sd.id = :id";
        DishDto dishDto = namedParameterJdbcTemplate.queryForObject(sqlDefaultInfo, namedParameters, (rs, rowNum) -> {
                DishDto dto = new DishDto();
                dto.setTopImage(rs.getString("top_image"));
                dto.setDescription(rs.getString("description"));
                dto.setPoint(rs.getString("point"));
                dto.setDeliveryInfo(rs.getString("delivery_info"));
                dto.setDeliveryFee(rs.getString("delivery_fee"));
                dto.setNormalPrice(rs.getString("normal_price"));
                dto.setSalePrice(rs.getString("sale_price"));
                return dto;
        });

        String sqlThumbImages = "SELECT image.url AS thumbimages FROM side_dish sd" +
                " LEFT OUTER JOIN image ON sd.id = image.side_dish" +
                " WHERE image.thumb_image_order IS NOT NULL" +
                "   AND sd.id = :id" +
                " ORDER BY image.thumb_image_order";
        List<String> thumbImages = namedParameterJdbcTemplate.queryForList(sqlThumbImages, namedParameters, String.class);
        dishDto.setThumbImages(thumbImages);

        String sqlDetailSectionImages = "SELECT image.url AS detailsectionimages" +
                "  FROM side_dish sd" +
                "  LEFT OUTER JOIN image ON sd.id = image.side_dish" +
                " WHERE image.detail_section_image_order IS NOT NULL" +
                "   AND sd.id = :id" +
                " ORDER BY image.detail_section_image_order";
        List<String> detailSectionImages = namedParameterJdbcTemplate.queryForList(sqlDetailSectionImages, namedParameters, String.class);
        dishDto.setDetailSectionImages(detailSectionImages);

        return dishDto;
    }
}
