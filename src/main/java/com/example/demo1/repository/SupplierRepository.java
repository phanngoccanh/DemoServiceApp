package com.example.demo1.repository;

import com.example.demo1.model.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
}
