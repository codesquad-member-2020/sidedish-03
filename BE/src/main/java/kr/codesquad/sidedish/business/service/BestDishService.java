package kr.codesquad.sidedish.business.service;

import kr.codesquad.sidedish.business.dao.BestDishDao;
import kr.codesquad.sidedish.business.dto.CategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestDishService {
    private static final Logger log = LoggerFactory.getLogger(BestDishService.class);

    private final BestDishDao bestDishDao;

    public BestDishService(BestDishDao bestDishDao) {
        this.bestDishDao = bestDishDao;
    }

    public List<CategoryDto> findBestDishes() {
        return bestDishDao.findBestDishes();
    }
}
