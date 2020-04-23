package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;

import java.util.List;

public interface FoodTypeDao {
    List<DishOverviewDto> findDishesByFoodTypeId(Long foodTypeId);
}
