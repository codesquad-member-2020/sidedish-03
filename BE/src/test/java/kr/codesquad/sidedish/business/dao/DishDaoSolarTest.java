package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishDto;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DishDaoSolarTest {
    private static final Logger log = LoggerFactory.getLogger(DishDaoSolar.class);

    @Autowired
    private DishDaoSolar dishDaoSolar;

    @Test
    void findDishById() {
        DishDto dishDto = dishDaoSolar.findDishById(1L);
        assertThat(dishDto).isNotNull();
        log.debug("dishDaoSolar findById: {}", dishDto);
    }

    @Test
    void findDishesById() {
        List<DishDto> dishDtos = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            DishDto dishDto = dishDaoSolar.findDishById(((long) i));
            dishDtos.add(dishDto);
        }
        assertThat(dishDtos).isNotNull();
        log.debug("dishDtos : {}", dishDtos.toString());
    }
}
