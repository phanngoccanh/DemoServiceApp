package com.example.demo1.web.api;

import com.example.demo1.service.SupplierService;
import com.example.demo1.service.dto.SupplierDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping("/get-all")
    public List<SupplierDTO> getAll(){
        return this.supplierService.getAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody SupplierDTO supplierDTO){
        this.supplierService.create(supplierDTO);
    }
}
