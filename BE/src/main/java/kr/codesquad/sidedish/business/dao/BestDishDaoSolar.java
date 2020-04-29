package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.BestDishDto;
import kr.codesquad.sidedish.business.dto.CategoryDto;
import org.springframework.stereotype.Repository;

@Repository
public class BestDishDaoSolar implements BestDishDao {
    @Override
    public BestDishDto findBestDishes() {
        return null;
    }

    @Override
    public CategoryDto findBestDish(Long categoryId) {
        return null;
    }
}
