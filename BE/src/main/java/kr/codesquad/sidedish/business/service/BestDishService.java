package kr.codesquad.sidedish.business.service;

import kr.codesquad.sidedish.business.dao.BestDishDao;
import kr.codesquad.sidedish.business.dto.BestDishDto;
import kr.codesquad.sidedish.business.dto.CategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BestDishService {
    private static final Logger log = LoggerFactory.getLogger(BestDishService.class);

    private final BestDishDao bestDishDao;

    public BestDishService(BestDishDao bestDishDao) {
        this.bestDishDao = bestDishDao;
    }

    public BestDishDto findBestDishes() {
        return bestDishDao.findBestDishes();
    }

    public CategoryDto findBestDish(Long categoryId) {
        return bestDishDao.findBestDish(categoryId);
    }
}
