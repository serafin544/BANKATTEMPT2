package com.example.MacFin.service;

import com.example.MacFin.model.Withdraw;
import com.example.MacFin.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawService {

    @Autowired
    private WithdrawRepository withdrawRepository;


    // Withdraw


    //get all withdrawals for a specific account
    public List<Withdraw> getAllWithdraws(Long accountId){
        List<Withdraw> listOfWithdraws = new ArrayList<>();
        withdrawRepository.findAll().forEach(listOfWithdraws::add);

        List<Withdraw> valid = new ArrayList<>();
        for(Withdraw w : listOfWithdraws){
            if(w.getPayerId() == accountId){
                valid.add(w);
            }
        }
        return valid;
    }

    //get withdrawal by id
    public Optional<Withdraw> getWithdrawById(Long withdrawalId){

        return withdrawRepository.findById(withdrawalId);
    }

    //create a withdrawal

    public Withdraw addWithdraw(Withdraw withdraw, Long accountId) {
        withdraw.setId(accountId);
        return withdrawRepository.save(withdraw);
    }

    //update a specific existing withdrawal

    public Withdraw updateWithdraw( Withdraw withdraw, Long withdrawId) {

        withdraw.setId(withdrawId);
        return withdrawRepository.save(withdraw);
    }

    //delete a specific existing withdrawal

    public void deleteWithdraw(Long withdrawId) {

        withdrawRepository.deleteById(withdrawId);
    }

}