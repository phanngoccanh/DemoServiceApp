package com.example.demo1.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_service")
@Getter
@Setter
public class Order extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_name")
    private String orderName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails = new HashSet<>();

}
