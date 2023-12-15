package com.example.demo1.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "supplier")
@Getter
@Setter
public class Supplier extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_parent_id")
    private String supplierParentId;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "posX")
    private double posX;

    @Column(name = "posY")
    private double posY;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private Set<Service> services = new HashSet<>();

}
