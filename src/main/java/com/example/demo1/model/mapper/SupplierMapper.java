package com.example.demo1.model.mapper;

import com.example.demo1.model.domain.Supplier;
import com.example.demo1.model.dto.SupplierDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends EntityMapper<SupplierDTO, Supplier> {
}
