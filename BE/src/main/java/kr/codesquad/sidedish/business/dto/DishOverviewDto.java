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
    private List<String> deliveryTypes = new ArrayList<>();
    private List<BadgeDto> badges = new ArrayList<>();

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

    public List<String> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(List<String> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
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

    public List<BadgeDto> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeDto> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return "DishOverviewDto{" + "id=" + id + ", mainImage='" + mainImage + '\'' + ", alt='" + alt + '\'' + ", title='" + title + '\'' + ", description='" + description + '\'' + ", normalPrice='" + normalPrice + '\'' + ", salePrice='" + salePrice + '\'' + ", deliveryTypes=" + deliveryTypes + ", badges=" + badges + '}';
    }
}
