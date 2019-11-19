package com.example.MacFin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WITHDRAWAL_TABLE")
public class Withdraw{

    @Id
    @Column(name = "WITHDRAW_ID")
    private Long id; //unique identifier for withdrawal

    @Column(name = "TYPE")
    private String type; //type of transaction (pending, cancelled, completed)

    @Column(name = "TRANSACTION_DATE")
    private String transactionDate; //timestamp of deposit execution

    @Column(name = "STATUS")
    private String status; //status of withdrawal (pending, cancelled, completed)

    @Column(name = "PAYER_ID")
    private Long payerId; //id of account executing withdrawal

    @Column(name = "MEDIUM")
    private String medium; //type of withdrawal (balance, rewards)

    @Column(name = "AMOUNT")
    private Double amount;  //withdrawal amount

    @Column(name = "DESCRIPTION")
    private String description; //description of withdrawal

    public Withdraw() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", status='" + status + '\'' +
                ", payerId=" + payerId +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
