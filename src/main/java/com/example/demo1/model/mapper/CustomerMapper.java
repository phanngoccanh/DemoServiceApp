package com.example.demo1.model.mapper;

import com.example.demo1.model.domain.Customer;
import com.example.demo1.model.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer>{
}
