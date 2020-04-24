package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodTypeDaoSolar implements FoodTypeDao {
    @Override
    public List<FoodTypeDto> findAllFoodType() {
        return null;
    }

    @Override
    public List<DishOverviewDto> findDishesByFoodTypeId(Long foodTypeId) {
        return null;
    }
}
