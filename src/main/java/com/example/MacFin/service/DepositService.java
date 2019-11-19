package com.example.MacFin.service;


import com.example.MacFin.model.Deposit;
import com.example.MacFin.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositService {

@Autowired
    DepositRepository depositRepository;


public Deposit createDeposit(Deposit deposit){

    return depositRepository.save( deposit );

    }

    public Optional<Deposit> getDepositbyId(Long id){

    return depositRepository.findById( id );



    }

    public List<Deposit> getAllDeposits(Deposit deposit){

        List<Deposit> d = new ArrayList<>(  );
        depositRepository.findAll().forEach( d::add );
        return d;
    }


    public Optional<Deposit> getDeposits(Long id){

    return depositRepository.findById( id );
    }

    public Deposit updateDeposit(Deposit deposit, Long depositId){
    deposit.setId( depositId );
    return depositRepository.save( deposit );

    }

    public void deleteDeposit(Long depositId){

    depositRepository.deleteById( depositId );
    }
}
