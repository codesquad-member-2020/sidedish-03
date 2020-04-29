package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishDto;

public interface DishDao {
    DishDto findDishById(Long id);
}
