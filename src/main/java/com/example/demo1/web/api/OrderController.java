package com.example.demo1.web.api;

import com.example.demo1.service.OrderService;
import com.example.demo1.model.dto.OrderDTO;
import com.example.demo1.model.dto.OrderDetailDTO;
import com.example.demo1.request.OrderRequest;
import com.example.demo1.request.RatingRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/get-by-customer/{customerId}")
    public List<OrderDTO> getByCustomer(@PathVariable("customerId") String customerId){
        return this.orderService.getByCustomerId(customerId);
    }

    @GetMapping("/{orderId}")
    public List<OrderDetailDTO> getOrderDetail(@PathVariable("orderId") String orderId){
        return this.orderService.getDetailOrder(orderId);
    }

    @PostMapping
    public void create(@RequestBody OrderRequest request){
        this.orderService.create(request);
    }

    @PostMapping("/vote")
    public void vote(@RequestBody RatingRequest request){
        this.orderService.vote(request);
    }
}
