package com.example.MacFin.repository;

import com.example.MacFin.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bills, Long> {
    List<Bills> findAccountById(Long accountId);
    List<Bills> findCustomerById(Long customerId);
}
