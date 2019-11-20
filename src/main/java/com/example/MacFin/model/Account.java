package com.example.MacFin.model;

import com.example.MacFin.type.AcctType;

import javax.persistence.*;

@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ACCOUNT_ID")
    private Long id;

    @Column(name="Type")
    @Enumerated(EnumType.STRING)
    private AcctType type;

    @Column(name="NICKNAME")
    private String nickName;

    @Column(name="REWARDS")
    private int rewards;

    @Column(name="BALANCE")
    private double balance;

    @Column(name="CustomerID")
    private Long customerId;



    public Account() {
    }

    public Account(Long id, AcctType acctType, String nickName, int rewards, double balance, Long customerId) {
        this.id = id;
        this.type = acctType;
        this.nickName = nickName;
        this.rewards = rewards;
        this.balance = balance;
        this.customerId = customerId;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", acctType=" + type +
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

    public AcctType getType() {
        return type;
    }

    public void setType(AcctType type) {
        this.type = type;
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
