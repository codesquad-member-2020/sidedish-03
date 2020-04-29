package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishDto;
import kr.codesquad.sidedish.common.error.exception.DishNotFoundException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class DishDaoDionTest {
    private static final Logger log = LoggerFactory.getLogger(DishDaoDionTest.class);

    @Qualifier("dishDaoDion")
    @Autowired
    private DishDao dishDao;

    @Test
    void 잘와요() {
        DishDto dto = dishDao.findDishById(1L);
        assertThat(dto).isNotNull();
        log.debug("dto: {}", dto);
    }

    @Test
    void 잘안와요() {
        assertThatThrownBy(() -> {
            DishDto dto = dishDao.findDishById(30L);
        }).isInstanceOf(DishNotFoundException.class)
          .hasMessageContaining(" 해당 반찬은 존재하지 않아요!");
    }

}
