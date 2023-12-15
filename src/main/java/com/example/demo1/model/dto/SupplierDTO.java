package com.example.demo1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SupplierDTO implements Serializable {
    private String supplierId;

    private String supplierName;

    private String supplierParentId;

    private String address;

    private String phone;

    private double posX;

    private double posY;
}
