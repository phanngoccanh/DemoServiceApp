package com.example.demo1.service;

import com.example.demo1.model.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    void create(SupplierDTO supplierDTO);


    List<SupplierDTO> getAll();
}
