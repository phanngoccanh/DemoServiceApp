package com.example.demo1.service.request;

import java.io.Serializable;

public class RatingRequest implements Serializable {
    private String orderDetailId;

    private int numberStar;

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(int numberStar) {
        this.numberStar = numberStar;
    }
}
