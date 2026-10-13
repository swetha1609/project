package com.loan.loan.management.system.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "RepayementSchedule")
public class RepaymentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Repayment_id")
    private Long id;

    @NotNull(message = "InstallmentNumber  is required")
    @Column(name="installment_number")
    private Integer installmentNumber;

    @NotNull(message = "DueDate is required")
    @Column(name="Due_Date")
    private LocalDate dueDate;

    @NotNull(message = "EMI amount is required")
    @Column(name="emi_amount")
    private BigDecimal emiAmount ;

    @NotNull(message = "PrincipalComponent  is required")
    @Column(name="principal_Component")
    private BigDecimal principalComponent;

    @NotNull(message = " InterestComponent is required")
    @Column(name="interest_component")
    private BigDecimal interestComponent ;

    @NotNull(message = "Outstandingprincipal is required")
    @Column(name="Outstanding_principal")
    private BigDecimal outstandingPrincipal ;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private STATUS status;

    public enum STATUS{
        Pending,
        Paid
    }

    @NotNull(message = "loan id is required")
    @Column(name = "loan_id")
    private Long loanId;

    public RepaymentSchedule() {
    }

    public RepaymentSchedule(Long id, Integer installmentNumber, LocalDate dueDate, BigDecimal emiAmount, BigDecimal principalComponent,
                             BigDecimal interestComponent, BigDecimal outstandingPrincipal, STATUS status) {
        this.id = id;
        this.installmentNumber = installmentNumber;
        this.dueDate = dueDate;
        this.emiAmount = emiAmount;
        this.principalComponent = principalComponent;
        this.interestComponent = interestComponent;
        this.outstandingPrincipal = outstandingPrincipal;
        this.status = status;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }
    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getEmiAmount() {
        return emiAmount;
    }
    public void setEmiAmount(BigDecimal emiAmount) {
        this.emiAmount = emiAmount;
    }

    public BigDecimal getPrincipalComponent() {
        return principalComponent;
    }
    public void setPrincipalComponent(BigDecimal principalComponent) {
        this.principalComponent = principalComponent;
    }

    public BigDecimal getInterestComponent() {
        return interestComponent;
    }
    public void setInterestComponent(BigDecimal interestComponent) {
        this.interestComponent = interestComponent;
    }

    public BigDecimal getOutstandingPrincipal() {
        return outstandingPrincipal;
    }
    public void setOutstandingPrincipal(BigDecimal outstandingPrincipal) {this.outstandingPrincipal = outstandingPrincipal;}

    public STATUS getStatus() {
        return status;
    }
    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Long getLoanId() {return loanId;}
    public void setLoanId(Long loanId) {this.loanId = loanId;}
}


