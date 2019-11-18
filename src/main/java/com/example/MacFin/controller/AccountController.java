package com.example.MacFin.controller;

import com.example.MacFin.feedback.ResponseSetup;
import com.example.MacFin.model.Account;
import com.example.MacFin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class AccountController {
    @Autowired
    private AccountService accountService;

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
}
