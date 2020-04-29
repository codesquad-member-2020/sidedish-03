package kr.codesquad.sidedish.business.service;

import kr.codesquad.sidedish.business.dao.FoodTypeDao;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeService {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeService.class);

    private final FoodTypeDao foodTypeDao;

    public FoodTypeService(FoodTypeDao foodTypeDao) {
        this.foodTypeDao = foodTypeDao;
    }

    public List<FoodTypeDto> findAllFoodTypes() {
        return foodTypeDao.findAllFoodTypes();
    }

    public FoodTypeDto findDishesByFoodTypeId(Long foodTypeId) {
        return foodTypeDao.findDishesByFoodTypeId(foodTypeId);
    }
}
