package com.example.demo1.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
public class OrderDetail extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_detail_id")
    private String orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "evaluate")
    private int evaluate;
}
