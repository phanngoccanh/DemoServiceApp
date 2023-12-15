package com.example.demo1.repository;

import com.example.demo1.model.domain.Service;
import com.example.demo1.model.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, String> {
    List<Service> findAlBySupplier(Supplier supplier);

    @Query(value = "select s.service_id, s.service_name, s.description, sup.supplier_id, sup.supplier_name, sup.address, sup.phone, " +
            "sup.posx, sup.posy, sup.supplier_parent_id, coalesce(od.rate, 0) " +
            "from (select od.service_id as service_id, avg(od.evaluate) as rate from order_detail od group by od.service_id) od " +
            "right join Service s on od.service_id = s.service_id  inner join Supplier sup on s.supplier_id = sup.supplier_id " +
            "where (:keyword is null) or (lower(s.service_name) like %:keyword%)", nativeQuery = true)
    List<Object[]> findBySearch(@Param("keyword") String keyword);

    @Query(value = "select max(coalesce(od.rate,0)) " +
            "from (select od.service_id as service_id, avg(od.evaluate) as rate from order_detail od group by od.service_id) od " +
            "right join Service s on od.service_id = s.service_id " +
            "where (:keyword is null) or (lower(s.service_name) like %:keyword%)",nativeQuery = true)
    int findMaxRateService(@Param("keyword") String keyword);

}
