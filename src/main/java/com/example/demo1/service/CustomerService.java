package com.example.demo1.service;

import com.example.demo1.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getById(String customerId);

    List<CustomerDTO> getAll();

    void create(CustomerDTO customerDTO);
}
