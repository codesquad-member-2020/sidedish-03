package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.FoodTypeDto;

import java.util.List;

public interface FoodTypeDao {
    List<FoodTypeDto> findAllFoodTypes();

    FoodTypeDto findDishesByFoodTypeId(Long foodTypeId);
}
