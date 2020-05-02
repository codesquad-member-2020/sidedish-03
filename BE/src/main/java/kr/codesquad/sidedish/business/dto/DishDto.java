package kr.codesquad.sidedish.business.dto;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DishDto {
    private final String topImage;
    private final String description;
    private final Long point;
    private final String deliveryInfo;
    private final String deliveryFee;
    private final Long normalPrice;
    private final Long salePrice;
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

    public Long getPoint() {
        return point;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public Long getNormalPrice() {
        return normalPrice;
    }

    public Long getSalePrice() {
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
        private Long point;
        private String deliveryInfo;
        private String deliveryFee;
        private Long normalPrice;
        private Long salePrice;

        public Builder topImage(String topImage) {
            this.topImage = topImage;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder point(Long point) {
            this.point = BigMoney.of(CurrencyUnit.of(Locale.KOREA), point).getAmountMajorLong();
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
            this.normalPrice = BigMoney.of(CurrencyUnit.of(Locale.KOREA), normalPrice).getAmountMajorLong();
            return this;
        }

        public Builder salePrice(Long salePrice) {
            this.salePrice = BigMoney.of(CurrencyUnit.of(Locale.KOREA), salePrice).getAmountMajorLong();
            return this;
        }

        public DishDto build() {
            return new DishDto(this);
        }
    }
}
