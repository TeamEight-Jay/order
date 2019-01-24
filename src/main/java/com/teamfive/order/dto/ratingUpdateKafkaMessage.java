package com.teamfive.order.dto;

public class ratingUpdateKafkaMessage {

    String inventoryId;
    String productId;
    String merchantId;
    double rating;

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ratingUpdateKafkaMessage{" +
                "inventoryId='" + inventoryId + '\'' +
                ", productId='" + productId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", rating=" + rating +
                '}';
    }
}
