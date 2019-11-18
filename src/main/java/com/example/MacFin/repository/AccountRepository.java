package com.example.MacFin.repository;

import com.example.MacFin.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAcctByCustomerId(Long customerId);
}
