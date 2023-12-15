package com.example.demo1.service;

import com.example.demo1.model.dto.ServiceDTO;
import com.example.demo1.model.dto.ServiceSupplierDTO;
import com.example.demo1.model.request.SearchServiceRequest;

import java.util.List;

public interface ServService {
    void create(ServiceDTO serviceDTO);
    List<ServiceSupplierDTO> search(SearchServiceRequest request);
    List<ServiceDTO> getBySupplier(String supplierId);
}
