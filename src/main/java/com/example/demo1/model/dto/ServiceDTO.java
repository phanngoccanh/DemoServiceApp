package com.example.demo1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class ServiceDTO implements Serializable {
    private String serviceId;

    private String supplierId;

    private String serviceName;

    private String description;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}
