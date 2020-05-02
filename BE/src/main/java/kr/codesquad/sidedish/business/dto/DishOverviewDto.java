package kr.codesquad.sidedish.business.dto;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DishOverviewDto {
    private final Long id;
    private final String mainImage;
    private final String alt;
    private final String title;
    private final String description;
    private final Long normalPrice;
    private final Long salePrice;
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

    public Long getNormalPrice() {
        return normalPrice;
    }

    public Long getSalePrice() {
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
        private Long normalPrice;
        private Long salePrice;

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

        public Builder normalPrice(Long normalPrice) {
            this.normalPrice = BigMoney.of(CurrencyUnit.of(Locale.KOREA), normalPrice).getAmountMajorLong();
            return this;
        }

        public Builder salePrice(Long salePrice) {
            this.salePrice = BigMoney.of(CurrencyUnit.of(Locale.KOREA), salePrice).getAmountMajorLong();
            return this;
        }

        public DishOverviewDto build() {
            return new DishOverviewDto(this);
        }
    }
}
