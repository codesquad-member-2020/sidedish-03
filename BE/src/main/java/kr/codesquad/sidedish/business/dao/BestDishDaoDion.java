package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.CategoryDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BestDishDaoDion implements BestDishDao {
    @Override
    public List<CategoryDto> findBestDishes() {
        return null;
    }
}
