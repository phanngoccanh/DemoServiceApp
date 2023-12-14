package com.example.demo1.service;

import com.example.demo1.service.dto.ServiceDTO;
import com.example.demo1.service.dto.ServiceSupplierDTO;
import com.example.demo1.service.request.SearchServiceRequest;

import java.util.List;

public interface ServService {
    void create(ServiceDTO serviceDTO);
    List<ServiceSupplierDTO> search(SearchServiceRequest request);
    List<ServiceDTO> getBySupplier(String supplierId);
}
