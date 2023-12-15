package com.example.demo1.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();

}
