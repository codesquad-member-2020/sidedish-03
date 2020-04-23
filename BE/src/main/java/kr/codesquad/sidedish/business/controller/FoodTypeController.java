package kr.codesquad.sidedish.business.controller;

import kr.codesquad.sidedish.business.dto.DishOverviewDto;
import kr.codesquad.sidedish.business.service.FoodTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foodtype/{foodtypeId}")
public class FoodTypeController {
    private static final Logger log = LoggerFactory.getLogger(FoodTypeController.class);

    private final FoodTypeService foodTypeService;

    public FoodTypeController(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    @GetMapping("")
    public List<DishOverviewDto> showDishesInFoodType(@PathVariable Long foodtypeId) {
        return foodTypeService.findDishesByFoodTypeId(foodtypeId);
    }
}
