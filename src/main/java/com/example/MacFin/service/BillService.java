package com.example.MacFin.service;

import com.example.MacFin.model.Bills;
import com.example.MacFin.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {


    @Autowired
    private BillRepository billRepository;



    //get all bills for specific account
    public List<Bills> allBillsByAccountId(Long id){
        List<Bills> listOfBills = new ArrayList<>();
        billRepository.findAccountById(id).forEach(listOfBills::add);
        return listOfBills;
    }



    //get bill by id
    public Optional<Bills> getBillsById(Long id){
        return billRepository.findById(id);
    }



    //get all bills for customer
    public List<Bills> allBillsByCustomerId(Long id) {
        List<Bills> allBillsByCustomerId = new ArrayList<>();
        billRepository.findCustomerById(id).forEach(allBillsByCustomerId::add);
        return allBillsByCustomerId;
    }


    //create a bill
    public Bills addBill(Bills bills, Long id) {
        bills.setId(id);
        return billRepository.save(bills);
    }


    //update a specific existing bill
    public Bills updateBill( Bills bills, Long id) {
        return billRepository.save(bills);
    }


    //delete a specific existing bill
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

