package kr.codesquad.sidedish.business.dto;


import java.util.ArrayList;
import java.util.List;

public class DishDto {
    private String topImage;
    private String description;
    private String point;
    private String deliveryInfo;
    private String deliveryFee;
    private String normalPrice;
    private String salePrice;
    private List<String> thumbImages = new ArrayList<>();
    private List<String> detailSectionImages = new ArrayList<>();

    public String getTopImage() {
        return topImage;
    }

    public void setTopImage(String topImage) {
        this.topImage = topImage;
    }

    public List<String> getThumbImages() {
        return thumbImages;
    }

    public void setThumbImages(List<String> thumbImages) {
        this.thumbImages = thumbImages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
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

    public List<String> getDetailSectionImages() {
        return detailSectionImages;
    }

    public void setDetailSectionImages(List<String> detailSectionImages) {
        this.detailSectionImages = detailSectionImages;
    }
}
