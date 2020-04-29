package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.ktdto.DishDto;
import kr.codesquad.sidedish.business.mapper.BadgeDtoMapper;
import kr.codesquad.sidedish.business.mapper.DishDtoMapper;
import kr.codesquad.sidedish.common.error.exception.DishNotFoundException;
import kr.codesquad.sidedish.common.util.NamedParameterOptionalJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import static kr.codesquad.sidedish.business.sql.SQLKt.BADGE_SQL;
import static kr.codesquad.sidedish.business.sql.SQLKt.DETAIL_SECTION_IMAGE_SQL;
import static kr.codesquad.sidedish.business.sql.SQLKt.DISH_DETAIL_SQL;
import static kr.codesquad.sidedish.business.sql.SQLKt.THUMB_IMAGE_SQL;

@Repository
public class DishDaoDion implements DishDao {
    private static final Logger log = LoggerFactory.getLogger(DishDaoDion.class);

    private final NamedParameterOptionalJdbcTemplate namedParameterJdbcTemplate;
    private final DishDtoMapper dishDtoMapper = new DishDtoMapper();
    private final BadgeDtoMapper badgeDtoMapper = new BadgeDtoMapper();

    public DishDaoDion(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterOptionalJdbcTemplate(dataSource);
    }

    @Override
    public DishDto findDishById(Long id) {
        log.debug("id: {}", id);
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);

        DishDto dishDto = namedParameterJdbcTemplate.queryForOptionalObject(DISH_DETAIL_SQL, parameters, dishDtoMapper).orElseThrow(DishNotFoundException::new);
        dishDto.setThumbImages(namedParameterJdbcTemplate.queryForList(THUMB_IMAGE_SQL, parameters, String.class));
        dishDto.setDetailSectionImages(namedParameterJdbcTemplate.queryForList(DETAIL_SECTION_IMAGE_SQL, parameters, String.class));
        dishDto.setBadges(namedParameterJdbcTemplate.query(BADGE_SQL, parameters, badgeDtoMapper));
        log.debug("dishDto: {}", dishDto);

        return dishDto;
    }
}
