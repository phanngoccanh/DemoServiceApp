package com.example.demo1.model.mapper;

import com.example.demo1.model.domain.Service;
import com.example.demo1.model.domain.Supplier;
import com.example.demo1.model.dto.ServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ServiceMapper extends EntityMapper<ServiceDTO, Service> {
    @Mapping(target = "supplierId", source = "supplier", qualifiedByName = "mapSupplierDTO")
    ServiceDTO toDTO(Service entities);

    @Named("mapSupplierDTO")
    static String mapSupplierDTO(Supplier supplier){
        return supplier.getSupplierId();
    }
}
