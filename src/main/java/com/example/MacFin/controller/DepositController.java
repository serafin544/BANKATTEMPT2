package com.example.MacFin.controller;


import com.example.MacFin.feedback.ResponseSetup;
import com.example.MacFin.model.Deposit;
import com.example.MacFin.service.AccountService;
import com.example.MacFin.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepositController {

    @Autowired
    private  DepositService depositService;

    @Autowired
    private AccountService accountService;

@RequestMapping(method = RequestMethod.GET, value = "/deposits")
    public ResponseEntity<?> getAllDeposits(Deposit deposit){

    List<Deposit> allDeposits = depositService.getAllDeposits( deposit );

    ResponseSetup r = new ResponseSetup(  );
    if(!allDeposits.isEmpty()){
        r.setCode( HttpStatus.OK.value() );
        r.setData( allDeposits );
        r.setMessage( "Success" );
        return new ResponseEntity<>( r,HttpStatus.OK );

    }else {

        r.setCode( HttpStatus.NOT_FOUND.value() );
        return new ResponseEntity<>( r, HttpStatus.INTERNAL_SERVER_ERROR );
    }


    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/deposits")
    public ResponseEntity<?> createDeposit(@Valid @RequestBody Deposit deposit){
    Deposit deposit1 = depositService.createDeposit( deposit );

    ResponseSetup r = new ResponseSetup(  );
    r.setCode( HttpStatus.CREATED.value() );
    r.setData( deposit1 );
    r.setMessage( "Deposit created" );

    return new ResponseEntity<>( r, HttpStatus.CREATED );
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deposits{depositId}")
    public ResponseEntity<?> updateDeposit(@Valid @RequestBody Deposit deposit, @PathVariable Long depositId){
    Optional<Deposit> deposit1 = depositService.getDepositbyId( depositId );

    if ((!deposit1.isPresent())){

        return new ResponseEntity<>( HttpStatus.NOT_FOUND );

    }else{

        depositService.updateDeposit( deposit,depositId );
        return new ResponseEntity<>( HttpStatus.OK );
    }


    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deposits{depositId}")
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
    Optional<Deposit> deposit = depositService.getDepositbyId( depositId );
    if(!deposit.isPresent()){

        depositService.deleteDeposit( depositId );
        return new ResponseEntity<>( HttpStatus.OK );

    }else {

        ResponseSetup r = new ResponseSetup(  );
        r.setMessage( "DEPOSIT NOT FOUND" );
        r.setCode( HttpStatus.NOT_FOUND.value() );
        return new ResponseEntity<>( r,HttpStatus.NOT_FOUND );
    }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/deposits/{depositId}")
    public ResponseEntity<?> getDepositsById(@RequestBody Long depositId){
    Optional<Deposit> deposit = depositService.getDepositbyId( depositId );

    ResponseSetup r = new ResponseSetup(  );
    if (deposit.isPresent()){
        r.setCode( HttpStatus.OK.value() );
        r.setMessage( "Success" );
        r.setData( deposit );
        return new ResponseEntity<>( r, HttpStatus.OK );


    }else {

        r.setCode( HttpStatus.NOT_FOUND.value() );

        return new ResponseEntity<>( r,HttpStatus.INTERNAL_SERVER_ERROR );
    }


    }

}

