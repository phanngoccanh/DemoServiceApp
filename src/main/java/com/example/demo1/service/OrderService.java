package com.example.demo1.service;

import com.example.demo1.domain.OrderDetail;
import com.example.demo1.service.dto.OrderDTO;
import com.example.demo1.service.dto.OrderDetailDTO;
import com.example.demo1.service.request.OrderRequest;
import com.example.demo1.service.request.RatingRequest;

import java.util.List;

public interface OrderService {
    void create(OrderRequest request);

    List<OrderDTO> getByCustomerId(String customerId);

    void vote(RatingRequest request);

    List<OrderDetailDTO> getDetailOrder(String orderId);

}
