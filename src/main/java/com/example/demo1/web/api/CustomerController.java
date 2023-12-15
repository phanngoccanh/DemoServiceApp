package com.example.demo1.web.api;

import com.example.demo1.service.CustomerService;
import com.example.demo1.model.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAll(){
        return this.customerService.getAll();
    }

    @PostMapping
    public void create(@RequestBody CustomerDTO customerDTO){
        this.customerService.create(customerDTO);
    }
}
