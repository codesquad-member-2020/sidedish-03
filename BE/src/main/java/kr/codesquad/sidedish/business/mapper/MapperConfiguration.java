package kr.codesquad.sidedish.business.mapper;

import kr.codesquad.sidedish.business.dto.BadgeDto;
import kr.codesquad.sidedish.business.dto.CategoryDto;
import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import kr.codesquad.sidedish.business.ktdto.DishDto;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import java.util.Locale;

@Configuration
public class MapperConfiguration {
    @Bean
    public RowMapper<BadgeDto> badgeMapper() {
        return (rs, rowNum) -> new BadgeDto(rs.getString("name"), rs.getString("color"));
    }

    @Bean
    public RowMapper<CategoryDto> categoryMapper() {
        return (rs, rowNum) -> new CategoryDto(rs.getLong("id"), rs.getString("name"));
    }

    @Bean
    public RowMapper<DishDto> dishMapper() {
        return (rs, rowNum) -> new DishDto(
                rs.getString("top_image"),
                rs.getString("description"),
                BigMoney.of(CurrencyUnit.of(Locale.KOREA), rs.getLong("point")).getAmountMajorLong(),
                rs.getString("delivery_info"),
                rs.getString("delivery_fee"),
                BigMoney.of(CurrencyUnit.of(Locale.KOREA), rs.getLong("normal_price")).getAmountMajorLong(),
                BigMoney.of(CurrencyUnit.of(Locale.KOREA), rs.getLong("sale_price")).getAmountMajorLong(),
                null,
                null,
                null
        );
    }

    @Bean
    public RowMapper<DishOverviewDto> dishOverviewMapper() {
        return (rs, rowNum) -> new DishOverviewDto.Builder(rs.getLong("id"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .mainImage(rs.getString("main_image"))
                .alt(rs.getString("alt"))
                .normalPrice(rs.getLong("normal_price"))
                .salePrice(rs.getLong("sale_price"))
                .build();
    }

    @Bean
    public RowMapper<FoodTypeDto> foodTypeMapper() {
        return (rs, rowNum) -> new FoodTypeDto(rs.getLong("id"), rs.getString("name"), rs.getString("description"));
    }
}
