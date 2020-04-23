package kr.codesquad.sidedish.business.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    private String categoryName;
    private List<DishOverviewDto> items = new ArrayList<>();

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<DishOverviewDto> getItems() {
        return items;
    }

    public void setItems(List<DishOverviewDto> items) {
        this.items = items;
    }
}
