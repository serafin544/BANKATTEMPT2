package com.example.MacFin.model;


import javax.persistence.*;

@Entity
@Table(name = "BILLS_TABLE")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BILLS_ID")
    private Long id; //bill unique identifier

    @Column(name="STATUS")
    private String status;   //enumerated value showing bill status (pending, cancelled, completed, recurring)

    @Column(name="PAYEE")
    private String payee; //place bill will be paid to

    @Column(name="NICKNAME")
    private String nickname;  //nickname of bill to help identify it

    @Column(name="CREATION_DATE")
    private String creationDate;//date bill was created

    @Column(name="PAYMENT_DATE")
    private String paymentDate;  //date bill is going to be paid or was paid

    @Column(name="RECURRING_DATE")
    private Integer recurringDate;  //date bill recurs monthly

    @Column(name="UPCOMING_PAYMENT_DATE")
    private String upcomingPaymentDate;  //next bill payment date

    @Column(name="PAYMENT_AMOUNT")
    private Double paymentAmount;  //amount of payment

    @Column(name="ACCOUNT_ID")
    private String accountId;  //id account will be associated

    public Bills(){

    }

    public Bills(Long id, String status, String payee, String nickname, String creationDate, String paymentDate,
                 Integer recurringDate, String upcomingPaymentDate, Double paymentAmount, String accountId)
    {
        this.id = id;
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.recurringDate = recurringDate;
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.paymentAmount = paymentAmount;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getRecurringDate() {
        return recurringDate;
    }

    public void setRecurringDate(Integer recurringDate) {
        this.recurringDate = recurringDate;
    }

    public String getUpcomingPaymentDate() {
        return upcomingPaymentDate;
    }

    public void setUpcomingPaymentDate(String upcomingPaymentDate) {
        this.upcomingPaymentDate = upcomingPaymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", recurringDate=" + recurringDate +
                ", upcomingPaymentDate='" + upcomingPaymentDate + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", accountId='" + accountId + '\'' +
                '}';
    }

}
