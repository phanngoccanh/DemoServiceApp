package com.example.demo1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Getter
@Setter
public class OrderDTO implements Serializable {
    private String orderId;

    private String orderName;

    private String customerId;

    private Instant orderDate;
}
