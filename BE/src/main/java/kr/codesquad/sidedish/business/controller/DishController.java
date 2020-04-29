package kr.codesquad.sidedish.business.controller;

import kr.codesquad.sidedish.business.ktdto.DishDto;
import kr.codesquad.sidedish.business.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish/{dishId}")
public class DishController {
    private static final Logger log = LoggerFactory.getLogger(DishController.class);

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("")
    public DishDto showDish(@PathVariable Long dishId) {
        return dishService.findDishById(dishId);
    }
}
