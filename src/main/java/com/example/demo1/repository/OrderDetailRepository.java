package com.example.demo1.repository;

import com.example.demo1.domain.Order;
import com.example.demo1.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrder(Order order);
}
