package com.example.demo1.service.impl;

import com.example.demo1.domain.Service;
import com.example.demo1.domain.Supplier;
import com.example.demo1.repository.ServiceRepository;
import com.example.demo1.repository.SupplierRepository;
import com.example.demo1.service.ServService;
import com.example.demo1.service.dto.ServiceDTO;
import com.example.demo1.service.dto.ServiceSupplierDTO;
import com.example.demo1.service.dto.SupplierDTO;
import com.example.demo1.service.mapper.ServiceMapper;
import com.example.demo1.service.request.SearchServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServServiceImpl implements ServService {
    private final Logger log = LoggerFactory.getLogger(ServServiceImpl.class);

    private static final double DEFAULT_DISTANCE = 10;
    private final ServiceMapper serviceMapper;

    private final ServiceRepository serviceRepository;

    private final SupplierRepository supplierRepository;


    public ServServiceImpl(ServiceMapper serviceMapper,
                           ServiceRepository serviceRepository,
                           SupplierRepository supplierRepository) {
        this.serviceMapper = serviceMapper;
        this.serviceRepository = serviceRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void create(ServiceDTO serviceDTO) {
        try {
            Supplier supplier = this.supplierRepository.findById(serviceDTO.getSupplierId()).get();
            Service service = this.serviceMapper.toEntity(serviceDTO);
            service.setSupplier(supplier);
            this.serviceRepository.save(service);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<ServiceSupplierDTO> search(SearchServiceRequest request) {
        String searchKey = request.getKeyword() != null ? request.getKeyword().toLowerCase() : null;
        List<Object[]> services = this.serviceRepository.findBySearch(searchKey);
        if (request.getDistance() == null) {
            request.setDistance(DEFAULT_DISTANCE);
        }
        int maxRateService = this.serviceRepository.findMaxRateService(searchKey);

        // get service if distance is satisfied with distance input or has rating equal to max rating
        List<ServiceSupplierDTO> serviceSupplierDTOS = services.stream()
                .filter(obj -> Math.sqrt(
                        Math.pow((request.getPosUserX() - (double) obj[7]), 2) +
                                Math.pow((request.getPosUserY() - (double) obj[8]), 2)) < request.getDistance() ||
                        Integer.parseInt(obj[10].toString()) == maxRateService)
                .map(obj -> mapToServiceSupplierDTO(obj, request)).toList();

        return serviceSupplierDTOS;
    }

    private ServiceSupplierDTO mapToServiceSupplierDTO(Object[] obj, SearchServiceRequest request) {
        double posSupplierX = (double) obj[7];
        double posSupplierY = (double) obj[8];

        ServiceSupplierDTO serviceSupplierDTO = new ServiceSupplierDTO();
        serviceSupplierDTO.setServiceId((String) obj[0]);
        serviceSupplierDTO.setServiceName((String) obj[1]);
        serviceSupplierDTO.setDescription((String) obj[2]);

        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierId((String) obj[3]);
        supplierDTO.setSupplierName((String) obj[4]);
        supplierDTO.setSupplierParentId((String) obj[9]);
        supplierDTO.setAddress((String) obj[5]);
        supplierDTO.setPhone((String) obj[6]);
        supplierDTO.setPosX(posSupplierX);
        supplierDTO.setPosY(posSupplierY);

        double distance = Math.sqrt(
                Math.pow((request.getPosUserX() - posSupplierX), 2) + Math.pow((request.getPosUserY() - posSupplierY), 2));
        serviceSupplierDTO.setDistance((double) Math.round(distance * 10) / 10);
        serviceSupplierDTO.setRate((int) Math.ceil(Double.parseDouble(obj[10].toString())));
        serviceSupplierDTO.setSupplierDTO(supplierDTO);

        return serviceSupplierDTO;
    }


    @Override
    public List<ServiceDTO> getBySupplier(String supplierId) {
        try {
            Optional<Supplier> supplierOpt = this.supplierRepository.findById(supplierId);
            if (supplierOpt.isEmpty()) {
                throw new RuntimeException("Supplier not found");
            }
            List<Service> services = this.serviceRepository.findAlBySupplier(supplierOpt.get());
            List<ServiceDTO> serviceDTOList = services.stream().map(serviceMapper::toDTO).collect(Collectors.toList());
            return serviceDTOList;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
