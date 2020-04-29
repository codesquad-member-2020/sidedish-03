package kr.codesquad.sidedish.business.dto;

import java.util.List;

public class BestDishDto {
    private final String name = "베스트셀러";
    private final String description = "후기가 증명하는 베스트 반찬";
    private final List<CategoryDto> bestDishes;

    private BestDishDto(List<CategoryDto> bestDishes) {
        this.bestDishes = bestDishes;
    }

    public static BestDishDto of(List<CategoryDto> bestDishes) {
        return new BestDishDto(bestDishes);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<CategoryDto> getBestDishes() {
        return bestDishes;
    }

    @Override
    public String toString() {
        return "BestMenuDto{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", bestDishes=" + bestDishes + '}';
    }
}
