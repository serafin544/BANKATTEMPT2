package com.example.MacFin.controller;


import com.example.MacFin.feedback.ResponseSetup;
import com.example.MacFin.model.Customer;
import com.example.MacFin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET, value = "/allcustomers")
    public ResponseEntity<?> getAllCustomers(Customer customer) {

        List<Customer> allCustomers = customerService.getAllCustomers(customer);

        ResponseSetup r = new ResponseSetup(  );
        if(!allCustomers.isEmpty()){
            r.setCode( HttpStatus.OK.value() );
            r.setMessage( "Success" );
            r.setData( allCustomers );
            return new ResponseEntity<>( r, HttpStatus.OK );
        }else{

            r.setCode( HttpStatus.NOT_FOUND.value() );
            return new ResponseEntity<>( r, HttpStatus.INTERNAL_SERVER_ERROR );
        }


        }

        @RequestMapping(method = RequestMethod.GET, value = "/customer/{customerId}")
        public ResponseEntity<?> getCustomerById(@RequestBody Long customerId){
         Optional<Customer> customer = customerService.getCustomerbyID( customerId );

         ResponseSetup r = new ResponseSetup(  );
         if(customer.isPresent()){
                 r.setCode( HttpStatus.OK.value() );
                 r.setMessage( "Success" );
                 r.setData( customer );
                 return new ResponseEntity<>( r, HttpStatus.OK );

         }else{

             r.setCode( HttpStatus.NOT_FOUND.value() );

             return new ResponseEntity<>( r, HttpStatus.INTERNAL_SERVER_ERROR );
         }


    }
    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
    Customer newCustomer = customerService.createCustomer( customer );

    ResponseSetup r = new ResponseSetup(  );
        r.setCode( HttpStatus.CREATED.value());
        r.setMessage( "Customer created" );
        r.setData( customer );
        return new ResponseEntity<>( r,HttpStatus.CREATED );
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId){
    Optional<Customer> customer1 = customerService.getCustomerbyID( customerId );

    if (!customer1.isPresent()){

        return new ResponseEntity<>( HttpStatus.NOT_FOUND );
    }else{

        customerService.updateCustomer( customer,customerId );
         return new ResponseEntity<>( HttpStatus.OK );

         }


    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){

        Optional<Customer> customer = customerService.getCustomerbyID( customerId );
        if(customer.isPresent()){

            customerService.deleteCustomer( customerId );
            return new ResponseEntity<>( HttpStatus.OK );
        }else{
            ResponseSetup res = new ResponseSetup(  );
            res.setCode(HttpStatus.NOT_FOUND.value());
            res.setMessage( "NO USER EXISTS" );
            return new ResponseEntity<>( res,HttpStatus.NOT_FOUND );

        }


    }


}
