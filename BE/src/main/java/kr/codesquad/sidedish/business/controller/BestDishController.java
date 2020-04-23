package kr.codesquad.sidedish.business.controller;

import kr.codesquad.sidedish.business.dto.CategoryDto;
import kr.codesquad.sidedish.business.service.BestDishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/best")
public class BestDishController {
    private static final Logger log = LoggerFactory.getLogger(BestDishController.class);

    private final BestDishService bestDishService;

    public BestDishController(BestDishService bestDishService) {
        this.bestDishService = bestDishService;
    }

    @GetMapping("")
    public List<CategoryDto> showBestDishes() {
        return bestDishService.findBestDishes();
    }

}
