package kr.codesquad.sidedish.business.dto;

import java.util.ArrayList;
import java.util.List;

public class DishOverviewDto {
    private Long id;
    private String mainImage;
    private String alt;
    private String title;
    private String description;
    private String normalPrice;
    private String salePrice;
    private List<String> deliveryType = new ArrayList<>();
    private List<BadgeDto> badge = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<String> getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(List<String> deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(String normalPrice) {
        this.normalPrice = normalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public List<BadgeDto> getBadge() {
        return badge;
    }

    public void setBadge(List<BadgeDto> badge) {
        this.badge = badge;
    }
}
