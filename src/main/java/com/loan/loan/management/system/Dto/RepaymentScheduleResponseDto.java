package com.loan.loan.management.system.Dto;

import com.loan.loan.management.system.Entity.RepaymentSchedule.STATUS;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RepaymentScheduleResponseDto {

    private Long id;
    private Integer installmentNumber;
    private LocalDate dueDate;
    private BigDecimal emiAmount;
    private BigDecimal principalComponent;
    private BigDecimal interestComponent;
    private BigDecimal outstandingPrincipal;
    private STATUS status;
    private Long loanId;

    public RepaymentScheduleResponseDto() {
    }

    public RepaymentScheduleResponseDto(Long id, Integer installmentNumber, LocalDate dueDate, BigDecimal emiAmount,
                                         BigDecimal principalComponent, BigDecimal interestComponent,
                                         BigDecimal outstandingPrincipal, STATUS status, Long loanId) {
        this.id = id;
        this.installmentNumber = installmentNumber;
        this.dueDate = dueDate;
        this.emiAmount = emiAmount;
        this.principalComponent = principalComponent;
        this.interestComponent = interestComponent;
        this.outstandingPrincipal = outstandingPrincipal;
        this.status = status;
        this.loanId = loanId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Integer getInstallmentNumber() {return installmentNumber;}
    public void setInstallmentNumber(Integer installmentNumber) {this.installmentNumber = installmentNumber;}

    public LocalDate getDueDate() {return dueDate;}
    public void setDueDate(LocalDate dueDate) {this.dueDate = dueDate;}

    public BigDecimal getEmiAmount() {return emiAmount;}
    public void setEmiAmount(BigDecimal emiAmount) {this.emiAmount = emiAmount;}

    public BigDecimal getPrincipalComponent() {return principalComponent;}
    public void setPrincipalComponent(BigDecimal principalComponent) {this.principalComponent = principalComponent;}

    public BigDecimal getInterestComponent() {return interestComponent;}
    public void setInterestComponent(BigDecimal interestComponent) {this.interestComponent = interestComponent;}

    public BigDecimal getOutstandingPrincipal() {return outstandingPrincipal;}
    public void setOutstandingPrincipal(BigDecimal outstandingPrincipal) {this.outstandingPrincipal = outstandingPrincipal;}

    public STATUS getStatus() {return status;}
    public void setStatus(STATUS status) {this.status = status;}

    public Long getLoanId() {return loanId;}
    public void setLoanId(Long loanId) {this.loanId = loanId;}
}
