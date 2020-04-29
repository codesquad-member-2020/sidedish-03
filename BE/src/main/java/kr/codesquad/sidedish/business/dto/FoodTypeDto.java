package kr.codesquad.sidedish.business.dto;

import java.util.ArrayList;
import java.util.List;

public class FoodTypeDto {

    private final Long id;
    private final String name;
    private final String description;
    private List<DishOverviewDto> dishes = new ArrayList<>();

    public FoodTypeDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<DishOverviewDto> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishOverviewDto> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "FoodTypeDto{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", dishes=" + dishes + '}';
    }
}
