package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.CategoryDto;

import java.util.List;

public interface BestDishDao {
    List<CategoryDto> findBestDishes();

    CategoryDto findBestDish(Long categoryId);
}
