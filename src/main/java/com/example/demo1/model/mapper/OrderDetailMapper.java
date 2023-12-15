package com.example.demo1.model.mapper;

import com.example.demo1.model.domain.OrderDetail;
import com.example.demo1.model.dto.OrderDetailDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper extends EntityMapper<OrderDetailDTO, OrderDetail>{
}
