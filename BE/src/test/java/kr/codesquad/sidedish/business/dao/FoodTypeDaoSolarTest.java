package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodTypeDaoSolarTest {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeDaoSolar.class);

    @Autowired
    FoodTypeDaoSolar foodTypeDaoSolar;

    @Test
    void findDishesByFoodTypeId() {
        FoodTypeDto foodTypeDto = foodTypeDaoSolar.findDishesByFoodTypeId(2L);
        assertThat(foodTypeDto).isNotNull();
        log.debug("foodTypeDto findDishesByFoodTypeId : {}", foodTypeDto);
    }
}
