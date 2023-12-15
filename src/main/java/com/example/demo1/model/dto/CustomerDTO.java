package com.example.demo1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class CustomerDTO implements Serializable {
    private String customerId;

    private String customerName;

    private String address;

    private String phone;
}
