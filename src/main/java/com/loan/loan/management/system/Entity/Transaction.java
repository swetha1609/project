package com.loan.loan.management.system.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name="Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transaction_id")
    private Long id;

    @NotNull(message = "Transaction Date is required")
    @Column(name="Transaction_date")
    private LocalDate transactionDate;

    @NotNull(message = "Amount paid is required")
    @Column(name="amount_paid")
    private BigDecimal amountPaid ;

    @NotNull(message = "loan id is required")
    @Column(name = "loan_id")
    private Long loanId;

    public Transaction() {
    }

    public Transaction(Long id, LocalDate transactionDate, BigDecimal amountPaid, Long loanId) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.amountPaid = amountPaid;
        this.loanId = loanId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Long getLoanId() {return loanId;}
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

}
