package com.loan.loan.management.system.Dto;

import com.loan.loan.management.system.Entity.LoanProduct.DayCountConvention;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class LoanProductRequestDto {

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotNull(message = "interest rate is required")
    private BigDecimal interestRate;

    @NotNull(message = "number of repayment is required")
    private Integer numberOfRepayments;

    @NotNull(message = "Day count convention is required")
    private DayCountConvention dayCountConvention;

    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}

    public BigDecimal getInterestRate() {return interestRate;}
    public void setInterestRate(BigDecimal interestRate) {this.interestRate = interestRate;}

    public Integer getNumberOfRepayments() {return numberOfRepayments;}
    public void setNumberOfRepayments(Integer numberOfRepayments) {this.numberOfRepayments = numberOfRepayments;}

    public DayCountConvention getDayCountConvention() {return dayCountConvention;}
    public void setDayCountConvention(DayCountConvention dayCountConvention) {this.dayCountConvention = dayCountConvention;}
}
