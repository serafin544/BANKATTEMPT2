package com.example.MacFin.controller;

import com.example.MacFin.feedback.ResponseSetup;
import com.example.MacFin.model.Account;
import com.example.MacFin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //GET all accounts

    @RequestMapping(method = RequestMethod.GET, value ="/accounts")
    public ResponseEntity<?> getAllAccts(Account account){
        List<Account> allAccts = accountService.getAllAccounts(account);
        ResponseSetup r = new ResponseSetup();
        if(!allAccts.isEmpty()){
            r.setCode(HttpStatus.OK.value());
            r.setMessage("Success");
            r.setData(allAccts);
            return new ResponseEntity<>(r, HttpStatus.OK);

        }else{
            r.setCode(HttpStatus.NOT_FOUND.value());
            return  new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    //Get all customer's accounts


    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}/accounts")
    public ResponseEntity<?> getCustomerAccts(@PathVariable Long id){
        ResponseSetup responseSetup = new ResponseSetup();
        List<Account> ca = accountService.getAllCustomersAccounts(id);
        if(!ca.isEmpty()){
            responseSetup.setCode(HttpStatus.OK.value());
            responseSetup.setMessage("Success");
            responseSetup.setData(ca);
            return  new ResponseEntity<>(responseSetup,HttpStatus.OK);
        }else{
            responseSetup.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(responseSetup,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Account by id

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ResponseSetup r = new ResponseSetup();
        Optional<Account> act = accountService.getById(id);
        if(act.isPresent()){
            r.setCode(HttpStatus.OK.value());
            r.setMessage("Success");
            r.setData(act);
            return new ResponseEntity<>(r,HttpStatus.OK);
        }else{
            r.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
        }
    }


    //ADD account

    @RequestMapping(method = RequestMethod.POST, value = "/customers/{id}/accounts")
    public ResponseEntity<?> addAccount(@RequestBody Account account, @PathVariable Long id) {
        Account a = accountService.addAccount(account, id);
        if (a != null) {
            HttpHeaders responseHeaders = new HttpHeaders();
            URI newAcct = ServletUriComponentsBuilder
                    .fromCurrentRequestUri()
                    .path("/{id}")
                    .buildAndExpand(a.getId())
                    .toUri();
            responseHeaders.setLocation(newAcct);
            return new ResponseEntity<>(a, responseHeaders, HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    //Update account

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Optional<Account> tmp =accountService.getById(id);
        if (tmp.isPresent()) {
            Account a = accountService.updateAcct(account, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //Delete Account

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{id}")
    public ResponseEntity<?> deleteAcct(@RequestBody Long id){
        Optional<Account> tmp = accountService.getById(id);
        if(tmp.isPresent()){
            accountService.deleteAccount(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
