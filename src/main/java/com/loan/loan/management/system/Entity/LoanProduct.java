package com.loan.loan.management.system.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Entity
@Table(name = "loanProduct")
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @NotBlank(message = "Product name is required")
    @Column (name = "product_name")
    private String productName;

    @NotNull(message = "interest rate is required")
    @Column(name="interest_Rate")
    private BigDecimal interestRate;


    @NotNull(message = "number of repayment is required")
    @Column(name="number_of_repayments")
    private Integer numberOfRepayments;

    @NotNull(message = "Day count convention is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "day_count_convention")
    private DayCountConvention dayCountConvention;


    public enum DayCountConvention {
        ACTUAL_360,
        ACTUAL_365,
        THIRTY_360
    }
    public LoanProduct(){}
    public LoanProduct(Long id,String productName,BigDecimal interestRate,Integer numberOfRepayments,DayCountConvention dayCountConvention){
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
