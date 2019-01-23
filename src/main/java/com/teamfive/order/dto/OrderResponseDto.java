package com.teamfive.order.dto;

public class OrderResponseDto {
    private String status;
    private String message;
    private fullOrderDTO order;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public fullOrderDTO getOrder() {
        return order;
    }

    public void setOrder(fullOrderDTO order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", order=" + order +
                '}';
    }
}
