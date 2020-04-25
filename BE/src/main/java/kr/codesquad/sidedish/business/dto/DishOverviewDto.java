package kr.codesquad.sidedish.business.dto;

import java.util.ArrayList;
import java.util.List;

public class DishOverviewDto {
    private final Long id;
    private final String mainImage;
    private final String alt;
    private final String title;
    private final String description;
    private final String normalPrice;
    private final String salePrice;
    private List<String> deliveryTypes = new ArrayList<>();
    private List<BadgeDto> badges = new ArrayList<>();

    private DishOverviewDto(Builder builder) {
        this.id = builder.id;
        this.mainImage = builder.mainImage;
        this.alt = builder.alt;
        this.title = builder.title;
        this.description = builder.description;
        this.normalPrice = builder.normalPrice;
        this.salePrice = builder.salePrice;
    }

    public Long getId() {
        return id;
    }

    public String getMainImage() {
        return mainImage;
    }

    public String getAlt() {
        return alt;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public List<String> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(List<String> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
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

    public static class Builder {
        private final Long id;
        private String mainImage;
        private String alt;
        private String title;
        private String description;
        private String normalPrice;
        private String salePrice;

        public Builder(Long id) {
            this.id = id;
        }

        public Builder mainImage(String mainImage) {
            this.mainImage = mainImage;
            return this;
        }

        public Builder alt(String alt) {
            this.alt = alt;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder normalPrice(String normalPrice) {
            this.normalPrice = normalPrice;
            return this;
        }

        public Builder salePrice(String salePrice) {
            this.salePrice = salePrice;
            return this;
        }

        public DishOverviewDto build() {
            return new DishOverviewDto(this);
        }
    }
}
