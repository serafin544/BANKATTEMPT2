package com.example.MacFin.model;

import com.example.MacFin.type.AcctType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private AcctType acctType;

    private String nickName;

    private int rewards;

    private double balance;

    private Long customerId;


    public Account() {
    }

    public Account(Long id, AcctType acctType, String nickName, int rewards, double balance, Long customerId) {
        this.id = id;
        this.acctType = acctType;
        this.nickName = nickName;
        this.rewards = rewards;
        this.balance = balance;
        this.customerId = customerId;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", acctType=" + acctType +
                ", nickName='" + nickName + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", customerId=" + customerId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcctType getAcctType() {
        return acctType;
    }

    public void setAcctType(AcctType acctType) {
        this.acctType = acctType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
