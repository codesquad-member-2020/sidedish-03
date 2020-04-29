package kr.codesquad.sidedish.business.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    private final Long categoryId;
    private final String categoryName;
    private List<DishOverviewDto> items = new ArrayList<>();

    public CategoryDto(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<DishOverviewDto> getItems() {
        return items;
    }

    public void setItems(List<DishOverviewDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CategoryDto{" + "categoryId=" + categoryId + ", categoryName='" + categoryName + '\'' + ", items=" + items + '}';
    }
}
