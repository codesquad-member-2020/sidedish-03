package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.dto.FoodTypeDto;

import java.util.List;

public interface FoodTypeDao {
    List<FoodTypeDto> findAllFoodType();

    List<DishOverviewDto> findDishesByFoodTypeId(Long foodTypeId);
}
