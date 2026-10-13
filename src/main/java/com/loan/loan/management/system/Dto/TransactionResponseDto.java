package com.loan.loan.management.system.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionResponseDto {

    private Long id;
    private LocalDate transactionDate;
    private BigDecimal amountPaid;
    private Long loanId;

    public TransactionResponseDto() {
    }

    public TransactionResponseDto(Long id, LocalDate transactionDate, BigDecimal amountPaid, Long loanId) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.amountPaid = amountPaid;
        this.loanId = loanId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public LocalDate getTransactionDate() {return transactionDate;}
    public void setTransactionDate(LocalDate transactionDate) {this.transactionDate = transactionDate;}

    public BigDecimal getAmountPaid() {return amountPaid;}
    public void setAmountPaid(BigDecimal amountPaid) {this.amountPaid = amountPaid;}

    public Long getLoanId() {return loanId;}
    public void setLoanId(Long loanId) {this.loanId = loanId;}
}
