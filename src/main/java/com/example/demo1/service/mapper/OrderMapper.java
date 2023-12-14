package com.example.demo1.service.mapper;

import com.example.demo1.domain.Order;
import com.example.demo1.service.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order>{
}
