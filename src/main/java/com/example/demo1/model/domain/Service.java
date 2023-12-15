package com.example.demo1.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
public class Service extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "service")
    private Set<OrderDetail> orderDetails = new HashSet<>();

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
