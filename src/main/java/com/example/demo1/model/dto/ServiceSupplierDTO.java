package com.example.demo1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ServiceSupplierDTO implements Serializable {
    private String serviceId;

    private String serviceName;

    private String description;

    private Double distance;

    private int rate;

   private SupplierDTO supplierDTO;

}
