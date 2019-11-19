package com.example.MacFin.service;

import com.example.MacFin.model.Account;
import com.example.MacFin.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;


    //Get all Accounts
    public List<Account> getAllAccounts(Account account){
        List<Account> a = new ArrayList<>();
        accountRepository.findAll().forEach(a::add);

        return a;
    }


    //Get all accounts from one Customer
    public List<Account> getAllCustomersAccounts(Long id){
        List<Account> a = new ArrayList<>();
        accountRepository.findAcctByCustomerId(id).forEach(a::add);
        return a;
    }


    //Get Accounts by ID

    public Optional<Account> getById(Long id){
        return accountRepository.findById(id);
    }


    //Create Account
    public Account addAccount(Account account, Long id){
        account.setId(id);
        return accountRepository.save(account);

    }


    //Update an Account
    public Account updateAcct(Account account, Long id){
        account.setId(id);
        return accountRepository.save(account);

    }

    //Delete an Account by Id
    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }




}
