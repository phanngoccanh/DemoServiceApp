package com.example.demo1.web.api;

import com.example.demo1.service.ServService;
import com.example.demo1.service.dto.ServiceDTO;
import com.example.demo1.service.dto.ServiceSupplierDTO;
import com.example.demo1.service.request.SearchServiceRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    private final ServService servService;

    public ServiceController(ServService servService){
        this.servService = servService;
    }

    @GetMapping("/get-by-supplier/{supplierId}")
    public List<ServiceDTO> getBySupplier(@PathVariable("supplierId") String supplierId){
        return this.servService.getBySupplier(supplierId);
    }

    @GetMapping("/search")
    public List<ServiceSupplierDTO> search(@RequestBody SearchServiceRequest request){
        return this.servService.search(request);
    }

    @PostMapping("/create")
    public void create(@RequestBody ServiceDTO serviceDTO){
        this.servService.create(serviceDTO);
    }

}
