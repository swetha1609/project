package com.loan.loan.management.system.Dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequestDto {

    @NotNull(message = "Transaction Date is required")
    private LocalDate transactionDate;

    @NotNull(message = "Amount paid is required")
    private BigDecimal amountPaid;

    public LocalDate getTransactionDate() {return transactionDate;}
    public void setTransactionDate(LocalDate transactionDate) {this.transactionDate = transactionDate;}

    public BigDecimal getAmountPaid() {return amountPaid;}
    public void setAmountPaid(BigDecimal amountPaid) {this.amountPaid = amountPaid;}
}
