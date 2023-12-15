package com.example.demo1.service.impl;

import com.example.demo1.model.domain.Customer;
import com.example.demo1.model.domain.Order;
import com.example.demo1.model.domain.OrderDetail;
import com.example.demo1.model.domain.Service;
import com.example.demo1.repository.CustomerRepository;
import com.example.demo1.repository.OrderDetailRepository;
import com.example.demo1.repository.OrderRepository;
import com.example.demo1.repository.ServiceRepository;
import com.example.demo1.service.OrderService;
import com.example.demo1.model.dto.OrderDTO;
import com.example.demo1.model.dto.OrderDetailDTO;
import com.example.demo1.model.mapper.OrderMapper;
import com.example.demo1.request.OrderRequest;
import com.example.demo1.request.RatingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements OrderService {
    private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderMapper orderMapper;

    private final CustomerRepository customerRepository;

    private final ServiceRepository serviceRepository;

    private final OrderDetailRepository orderDetailRepository;

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderMapper orderMapper,
                            ServiceRepository serviceRepository,
                            CustomerRepository customerRepository,
                            OrderDetailRepository orderDetailRepository,
                            OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.serviceRepository = serviceRepository;
        this.customerRepository = customerRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(OrderRequest request) {
        try {
            Optional<Customer> customerOpt = this.customerRepository.findById(request.getCustomerId());
            if (customerOpt.isEmpty()) {
                log.error("Customer not found");
                throw new RuntimeException("Customer not found");
            }

            Order order = new Order();
            order.setCustomer(customerOpt.get());
            order.setOrderName(request.getOrderName());
            Order savedOrder = this.orderRepository.save(order);

            request.getServiceIds().forEach(serviceId -> {
                Service service = this.serviceRepository.findById(serviceId).get();
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(savedOrder);
                orderDetail.setService(service);
                orderDetail.setEvaluate(0);

                this.orderDetailRepository.save(orderDetail);
            });

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<OrderDTO> getByCustomerId(String customerId) {
        try {
            Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
            if (customerOptional.isEmpty()) {
                throw new RuntimeException("Customer not found");
            }
            List<Order> orders = this.orderRepository.findByCustomer(customerOptional.get());
            List<OrderDTO> orderDTOs = orders.stream().map(order -> {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setCustomerId(order.getCustomer().getCustomerId());
                orderDTO.setOrderId(order.getOrderId());
                orderDTO.setOrderName(order.getOrderName());
                orderDTO.setOrderDate(order.getCreatedDate());

                return orderDTO;
            }).toList();

            return orderDTOs;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void vote(RatingRequest request) {
        try {
            Optional<OrderDetail> optionalOrderDetail = this.orderDetailRepository.findById(request.getOrderDetailId());
            if (optionalOrderDetail.isEmpty()) {
                throw new RuntimeException("Order detail not found");
            }

            OrderDetail orderDetail = optionalOrderDetail.get();
            orderDetail.setEvaluate(request.getNumberStar());
            this.orderDetailRepository.save(orderDetail);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<OrderDetailDTO> getDetailOrder(String orderId) {
        try {
            Optional<Order> orderOpt = this.orderRepository.findById(orderId);
            if (orderOpt.isEmpty()) {
                throw new RuntimeException("Order not found");
            }
            List<OrderDetail> orderDetails = this.orderDetailRepository.findByOrder(orderOpt.get());
            List<OrderDetailDTO> orderDetailDTOs = orderDetails.stream().map(orderDetail -> {
                OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
                orderDetailDTO.setOrderDetailId(orderDetail.getOrderDetailId());
                orderDetailDTO.setOrderId(orderDetail.getOrder().getOrderId());
                orderDetailDTO.setServiceId(orderDetail.getService().getServiceId());
                orderDetailDTO.setServiceId(orderDetail.getService().getServiceId());
                orderDetailDTO.setEvaluate(orderDetail.getEvaluate());

                return orderDetailDTO;
            }).toList();

            return orderDetailDTOs;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
