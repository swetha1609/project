package com.loan.loan.management.system.Dto;

import com.loan.loan.management.system.Entity.LoanProduct.DayCountConvention;

import java.math.BigDecimal;

public class LoanProductResponseDto {

    private Long id;
    private String productName;
    private BigDecimal interestRate;
    private Integer numberOfRepayments;
    private DayCountConvention dayCountConvention;

    public LoanProductResponseDto() {
    }

    public LoanProductResponseDto(Long id, String productName, BigDecimal interestRate,
                                   Integer numberOfRepayments, DayCountConvention dayCountConvention) {
        this.id = id;
        this.productName = productName;
        this.interestRate = interestRate;
        this.numberOfRepayments = numberOfRepayments;
        this.dayCountConvention = dayCountConvention;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}

    public BigDecimal getInterestRate() {return interestRate;}
    public void setInterestRate(BigDecimal interestRate) {this.interestRate = interestRate;}

    public Integer getNumberOfRepayments() {return numberOfRepayments;}
    public void setNumberOfRepayments(Integer numberOfRepayments) {this.numberOfRepayments = numberOfRepayments;}

    public DayCountConvention getDayCountConvention() {return dayCountConvention;}
    public void setDayCountConvention(DayCountConvention dayCountConvention) {this.dayCountConvention = dayCountConvention;}
}
