package com.example.MacFin.service;

import com.example.MacFin.model.Account;
import com.example.MacFin.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AccountService {


    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts(Account account){
        List<Account> a = new ArrayList<>();
        accountRepository.findAll().forEach(a::add);

        return a;
    }
}
