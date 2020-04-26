package kr.codesquad.sidedish.business.dto;


import kr.codesquad.sidedish.business.wrapper.Money;

import java.util.ArrayList;
import java.util.List;

public class DishDto {
    private final String topImage;
    private final String description;
    private final String point;
    private final String deliveryInfo;
    private final String deliveryFee;
    private final String normalPrice;
    private final String salePrice;
    private List<String> thumbImages = new ArrayList<>();
    private List<String> detailSectionImages = new ArrayList<>();
    private List<BadgeDto> badges = new ArrayList<>();

    private DishDto(Builder builder) {
        this.topImage = builder.topImage;
        this.description = builder.description;
        this.point = builder.point;
        this.deliveryInfo = builder.deliveryInfo;
        this.deliveryFee = builder.deliveryFee;
        this.normalPrice = builder.normalPrice;
        this.salePrice = builder.salePrice;
    }

    public String getTopImage() {
        return topImage;
    }

    public String getDescription() {
        return description;
    }

    public String getPoint() {
        return point;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public List<String> getThumbImages() {
        return thumbImages;
    }

    public void setThumbImages(List<String> thumbImages) {
        this.thumbImages = thumbImages;
    }

    public List<String> getDetailSectionImages() {
        return detailSectionImages;
    }

    public void setDetailSectionImages(List<String> detailSectionImages) {
        this.detailSectionImages = detailSectionImages;
    }

    public List<BadgeDto> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeDto> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return "DishDto{" + "topImage='" + topImage + '\'' + ", description='" + description + '\'' + ", point='" + point + '\'' + ", deliveryInfo='" + deliveryInfo + '\'' + ", deliveryFee='" + deliveryFee + '\'' + ", normalPrice='" + normalPrice + '\'' + ", salePrice='" + salePrice + '\'' + ", thumbImages=" + thumbImages + ", detailSectionImages=" + detailSectionImages + ", badges=" + badges + '}';
    }

    public static class Builder {
        private String topImage;
        private String description;
        private String point;
        private String deliveryInfo;
        private String deliveryFee;
        private String normalPrice;
        private String salePrice;

        public Builder topImage(String topImage) {
            this.topImage = topImage;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder point(Long point) {
            this.point = Money.valueOf(point).format();
            return this;
        }

        public Builder deliveryInfo(String deliveryInfo) {
            this.deliveryInfo = deliveryInfo;
            return this;
        }

        public Builder deliveryFee(String deliveryFee) {
            this.deliveryFee = deliveryFee;
            return this;
        }

        public Builder normalPrice(Long normalPrice) {
            this.normalPrice = Money.valueOf(normalPrice).format();
            return this;
        }

        public Builder salePrice(Long salePrice) {
            this.salePrice = Money.valueOf(salePrice).format();
            return this;
        }

        public DishDto build() {
            return new DishDto(this);
        }
    }
}
