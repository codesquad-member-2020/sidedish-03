package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.BestDishDto;
import kr.codesquad.sidedish.business.dto.CategoryDto;

public interface BestDishDao {
    BestDishDto findBestDishes();

    CategoryDto findBestDish(Long categoryId);
}
