package kr.codesquad.sidedish.business.dao;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodTypeDaoDion implements FoodTypeDao {
    @Override
    public List<DishOverviewDto> findDishesByFoodTypeId(Long foodTypeId) {
        return null;
    }
}
