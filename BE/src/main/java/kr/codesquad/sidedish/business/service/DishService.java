package kr.codesquad.sidedish.business.service;

import kr.codesquad.sidedish.business.dao.DishDao;
import kr.codesquad.sidedish.business.dto.DishDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DishService {
    private static final Logger log = LoggerFactory.getLogger(DishService.class);

    private final DishDao dishDao;

    public DishService(@Qualifier("dishDaoDion") DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public DishDto findDishById(Long id) {
        return dishDao.findDishById(id);
    }
}
