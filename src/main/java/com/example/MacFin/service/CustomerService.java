package com.example.MacFin.service;

import com.example.MacFin.model.Customer;
import com.example.MacFin.model.Deposit;
import com.example.MacFin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){

        return customerRepository.save( customer );
    }

    public Optional<Customer> getCustomerbyID(Long id){

        return customerRepository.findById( id );
    }


    public void deleteCustomer(Long customerId){

        customerRepository.deleteById( customerId );

    }

    public List<Customer> getAllCustomers(Customer customer){

        List<Customer> c = new ArrayList<>(  );
        customerRepository.findAll().forEach( c::add );
        return c;
    }

    public Customer updateCustomer(Customer customer,Long customerId ){

        customer.setId( customerId );

        return customerRepository.save( customer );
    }

}
