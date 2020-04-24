package kr.codesquad.sidedish.business.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private List<DishOverviewDto> items = new ArrayList<>();

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

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

    @Override
    public String toString() {
        return "CategoryDto{" + "categoryId=" + categoryId + ", categoryName='" + categoryName + '\'' + ", items=" + items + '}';
    }
}
