package com.example.demo1.service.mapper;

import com.example.demo1.domain.Supplier;
import com.example.demo1.service.dto.SupplierDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends EntityMapper<SupplierDTO, Supplier> {
}
