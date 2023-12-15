package com.example.demo1.service;

import com.example.demo1.model.dto.OrderDTO;
import com.example.demo1.model.dto.OrderDetailDTO;
import com.example.demo1.model.request.OrderRequest;
import com.example.demo1.model.request.RatingRequest;

import java.util.List;

public interface OrderService {
    void create(OrderRequest request);

    List<OrderDTO> getByCustomerId(String customerId);

    void vote(RatingRequest request);

    List<OrderDetailDTO> getDetailOrder(String orderId);

}
