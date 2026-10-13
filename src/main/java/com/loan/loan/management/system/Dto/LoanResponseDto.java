package com.loan.loan.management.system.Dto;

import com.loan.loan.management.system.Entity.Loan.LoanStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanResponseDto {

    private Long id;
    private String customerId;
    private BigDecimal principalAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private LoanStatus status;
    private Long productId;

    public LoanResponseDto() {
    }

    public LoanResponseDto(Long id, String customerId, BigDecimal principalAmount, LocalDate startDate,
                            LocalDate endDate, LoanStatus status, Long productId) {
        this.id = id;
        this.customerId = customerId;
        this.principalAmount = principalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.productId = productId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getCustomerId() {return customerId;}
    public void setCustomerId(String customerId) {this.customerId = customerId;}

    public BigDecimal getPrincipalAmount() {return principalAmount;}
    public void setPrincipalAmount(BigDecimal principalAmount) {this.principalAmount = principalAmount;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public LoanStatus getStatus() {return status;}
    public void setStatus(LoanStatus status) {this.status = status;}

    public Long getProductId() {return productId;}
    public void setProductId(Long productId) {this.productId = productId;}
}
