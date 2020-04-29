package kr.codesquad.sidedish.business.dao;


import kr.codesquad.sidedish.business.ktdto.DishDto;

public interface DishDao {
    DishDto findDishById(Long id);
}
