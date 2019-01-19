package com.teamfive.order.entity;

import com.teamfive.order.dto.CustomerDTO;
import com.teamfive.order.dto.MerchantDTO;
import com.teamfive.order.dto.ProductDTO;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity
public class Order {

    private String orderId;
    private ProductDTO product;
    private MerchantDTO merchant;
    private int price;
    private String modeOfPayment;
    private String address;
    private Date date;
    private CustomerDTO customer;
    private int orderRating=-1;
    private String status;



    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", product='" + product + '\'' +
                ", merchant='" + merchant + '\'' +
                ", price=" + price +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", address=" + address +
                ", date=" + date +
                ", customer=" + customer +
                ", orderRating=" + orderRating +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(this.orderId, order.orderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, product, merchant, price, modeOfPayment, address, date, customer, orderRating, status);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public MerchantDTO getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDTO merchant) {
        this.merchant = merchant;
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
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
