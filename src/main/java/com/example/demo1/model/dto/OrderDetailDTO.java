package com.example.demo1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class OrderDetailDTO implements Serializable {
    private String orderDetailId;

    private String orderId;

    private String serviceId;

    private int evaluate;
}
