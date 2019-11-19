package com.example.MacFin.controller;


import com.example.MacFin.feedback.ResponseSetup;
import com.example.MacFin.model.Withdraw;
import com.example.MacFin.service.WithdrawService;
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
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;

    //Get all withdraws from account
    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdraws")
    public ResponseEntity<?> getAllWithdraws(@PathVariable Long accountId){
        List<Withdraw> w = withdrawService.getAllWithdraws(accountId);
        ResponseSetup rep = new ResponseSetup();

        if(!w.isEmpty())
        {
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Success");
            rep.setData(w);
            return new ResponseEntity<>(rep, HttpStatus.OK);
        }
        else
        {
            rep.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }


    //Get withdraws by an id

    @RequestMapping(method = RequestMethod.GET, value = "/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawId){
        Optional<Withdraw> w = withdrawService.getWithdrawById(withdrawId);
        if(w.isPresent()) {
            return new ResponseEntity<>(w, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Message: Error fetching Withdraw By ID", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Add withdraws

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<?> addWithdraw(@RequestBody Withdraw withdraw, @PathVariable Long accountId){
        Withdraw w = withdrawService.addWithdraw(withdraw, accountId);
        if(w != null){
            HttpHeaders responseHeaders = new HttpHeaders();
            URI nw = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(w.getId())
                    .toUri();
            responseHeaders.setLocation(nw);
            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //Update a withdraw

    @RequestMapping(method = RequestMethod.PUT, value = "/withdrawals/{withdrawId}")
    public ResponseEntity<?> updateWithdraw( @RequestBody Withdraw withdraw, @PathVariable Long withdrawId){
        Optional<Withdraw> tmp =withdrawService.getWithdrawById(withdrawId);
        if (tmp.isPresent()) {
            Withdraw updateWithdraw = withdrawService.updateWithdraw(withdraw, withdrawId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }






    }


    //Delete the withdraw


    @RequestMapping(method = RequestMethod.DELETE, value = "/withdrawals/{withdrawalId}")
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawId) {
        Optional<Withdraw> tmp = withdrawService.getWithdrawById(withdrawId);
        if(tmp.isPresent()){
            withdrawService.deleteWithdraw(withdrawId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }



}
