package com.example.demo1.service.impl;

import com.example.demo1.domain.Supplier;
import com.example.demo1.repository.SupplierRepository;
import com.example.demo1.service.SupplierService;
import com.example.demo1.service.dto.SupplierDTO;
import com.example.demo1.service.mapper.SupplierMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final Logger log = LoggerFactory.getLogger(Supplier.class);
    private final SupplierMapper supplierMapper;

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierMapper supplierMapper,
            SupplierRepository supplierRepository){
        this.supplierMapper = supplierMapper;
        this. supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierDTO> getAll() {
        List<SupplierDTO> supplierDTOList = this.supplierMapper.toDTOs(this.supplierRepository.findAll());
        return supplierDTOList;
    }

    @Override
    public void create(SupplierDTO supplierDTO) {
        try{
            Supplier supplier = this.supplierMapper.toEntity(supplierDTO);
            this.supplierRepository.save(supplier);
        } catch (Exception e){
           log.error(e.getMessage());
        }
    }

}
