package kr.codesquad.sidedish.business.dto;

import java.util.ArrayList;
import java.util.List;

public class FoodTypeDto {

    private Long id;
    private String name;
    private String description;
    private List<DishOverviewDto> dishes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
