package com.example.MacFin.controller;

import com.example.MacFin.feedback.ResponseSetup;
import com.example.MacFin.model.Bills;
import com.example.MacFin.service.BillService;
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
public class BillController {

    @Autowired
    private BillService billService;


    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}/bills")
    public ResponseEntity<?> getAllBillsByAccountId(@PathVariable Long id)
    {
        List<Bills> b = billService.allBillsByAccountId(id);
        ResponseSetup r = new ResponseSetup();
        if(!b.isEmpty()){
            r.setCode(HttpStatus.OK.value());
            r.setMessage("Success");
            r.setData(b);
            return new ResponseEntity<>(r,HttpStatus.OK);
        }else{
            r.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/bills/{id}")
    public ResponseEntity<?> getBillsById(@PathVariable Long id){
        Optional<Bills> b = billService.getBillsById(id);
        ResponseSetup r = new ResponseSetup();
        if(b.isPresent()) {
            return new ResponseEntity<>(b, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Message: Error fetching Bills", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{customerId}/bills")
    public ResponseEntity<?> getAllBillsForCustomerById(@PathVariable Long customerId){
        List<Bills> b = billService.allBillsByCustomerId(customerId);
        ResponseSetup r = new ResponseSetup();
        if (!b.isEmpty()) {
            r.setCode(HttpStatus.OK.value());
            r.setMessage("Success");
            r.setData(b);
            return new ResponseEntity<>(r, HttpStatus.OK);
        } else
        {
            r.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/bills")
    public ResponseEntity<?> addBill(@RequestBody Bills bills, @PathVariable Long accountId){

        Bills b = billService.addBill(bills,accountId);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(b.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(bills, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/bills/{id}")
    public ResponseEntity<?> updateBill(@RequestBody Bills bills, @PathVariable Long id){
        Bills updateBill = billService.updateBill(bills,id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/bills/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }