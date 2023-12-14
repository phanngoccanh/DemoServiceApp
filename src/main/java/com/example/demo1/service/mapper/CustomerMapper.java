package com.example.demo1.service.mapper;

import com.example.demo1.domain.Customer;
import com.example.demo1.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer>{
}
