package com.teamfive.order.entity;

import com.teamfive.order.dto.MerchantDTO;
import com.teamfive.order.dto.ProductDTO;

import java.util.Date;
import java.util.Objects;

public class Order {

    private String orderId;
    private ProductDTO productId;
    private MerchantDTO merchantId;
    private int price;
    private String modeOfPayment;
    private String address;
    private Date date;
    private Customer customerId;
    private int orderRating=-1;
    private String status;



    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", price=" + price +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", address=" + address +
                ", date=" + date +
                ", customerId=" + customerId +
                ", orderRating=" + orderRating +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, productId, merchantId, price, modeOfPayment, address, date, customerId, orderRating, status);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ProductDTO getProductId() {
        return productId;
    }

    public void setProductId(ProductDTO productId) {
        this.productId = productId;
    }

    public MerchantDTO getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(MerchantDTO merchantId) {
        this.merchantId = merchantId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public int getOrderRating() {
        return orderRating;
    }

    public void setOrderRating(int orderRating) {
        this.orderRating = orderRating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
