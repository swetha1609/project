 package com.loan.loan.management.system.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanRequestDto {

    @NotBlank(message = "Customer  name is required")
    private String customerId;

    @NotNull(message = "principal amount is required")
    private BigDecimal principalAmount;

    @NotNull(message = "date is required")
    private LocalDate startDate;

    @NotNull(message = "product id is required")
    private Long productId;

    public String getCustomerId() {return customerId;}
    public void setCustomerId(String customerId) {this.customerId = customerId;}

    public BigDecimal getPrincipalAmount() {return principalAmount;}
    public void setPrincipalAmount(BigDecimal principalAmount) {this.principalAmount = principalAmount;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public Long getProductId() {return productId;}
    public void setProductId(Long productId) {this.productId = productId;}
}
