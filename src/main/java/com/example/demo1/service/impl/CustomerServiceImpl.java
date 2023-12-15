package com.example.demo1.service.impl;

import com.example.demo1.model.domain.Customer;
import com.example.demo1.repository.CustomerRepository;
import com.example.demo1.service.CustomerService;
import com.example.demo1.model.dto.CustomerDTO;
import com.example.demo1.model.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper,
                               CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerDTO> customerDTOs = customers.stream().map(this.customerMapper::toDTO).toList();
        return customerDTOs;
    }

    @Override
    public void create(CustomerDTO customerDTO) {
        Customer customer = this.customerMapper.toEntity(customerDTO);
        this.customerRepository.save(customer);
    }

    @Override
    public CustomerDTO getById(String customerId) {
        try {
            Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
            if (customerOptional.isEmpty()) {
                throw new RuntimeException("Customer not found");
            }

            return this.customerMapper.toDTO(customerOptional.get());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
