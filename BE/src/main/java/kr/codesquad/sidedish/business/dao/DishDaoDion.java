package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishDto;
import kr.codesquad.sidedish.common.error.exception.DishNotFoundException;
import kr.codesquad.sidedish.common.util.NamedParameterOptionalJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DishDaoDion implements DishDao {
    private static final Logger log = LoggerFactory.getLogger(DishDaoDion.class);

    private final NamedParameterOptionalJdbcTemplate namedParameterJdbcTemplate;

    public DishDaoDion(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterOptionalJdbcTemplate(dataSource);
    }

    @Override
    public DishDto findDishById(Long id) {
        log.debug("id: {}", id);

        String dishDetailSql = "SELECT img.url AS top_image, sd.description AS description, FORMAT(sd.point, 0) AS point, sd.delivery_info AS delivery_info, sd.delivery_fee AS delivery_fee, FORMAT(sd.normal_price, 0) AS normal_price, FORMAT(sd.sale_price, 0) AS sale_price FROM side_dish AS sd INNER JOIN image AS img ON img.id = sd.top_image WHERE sd.id = :id;";
        String thumbImageSql = "SELECT img.url FROM image AS img LEFT OUTER JOIN side_dish AS sd ON img.side_dish = sd.id WHERE img.thumb_image_order IS NOT NULL AND sd.id = :id ORDER BY img.thumb_image_order;";
        String detailSectionImageSql = "SELECT img.url FROM image AS img LEFT OUTER JOIN side_dish AS sd ON img.side_dish = sd.id WHERE img.detail_section_image_order IS NOT NULL AND sd.id = :id ORDER BY img.detail_section_image_order;";

        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);

        DishDto dishDto = namedParameterJdbcTemplate.queryForOptionalObject(dishDetailSql, parameters, (rs, rowNum) -> {
            DishDto dto = new DishDto();
            dto.setTopImage(rs.getString("top_image"));
            dto.setDescription(rs.getString("description"));
            dto.setPoint(rs.getString("point"));
            dto.setDeliveryInfo(rs.getString("delivery_info"));
            dto.setDeliveryFee(rs.getString("delivery_fee"));
            dto.setNormalPrice(rs.getString("normal_price"));
            dto.setSalePrice(rs.getString("sale_price"));
            return dto;
        }).orElseThrow(DishNotFoundException::new);

        dishDto.setThumbImages(namedParameterJdbcTemplate.queryForList(thumbImageSql, parameters, String.class));
        dishDto.setDetailSectionImages(namedParameterJdbcTemplate.queryForList(detailSectionImageSql, parameters, String.class));

        return dishDto;
    }
}
