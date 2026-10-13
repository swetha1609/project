package com.loan.loan.management.system.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @NotBlank(message = "Customer  name is required")
    @Column(name = "customer_id")
    private String customerId;

    @NotNull(message = "interest rate is required")
    @Column(name = "Principle_Amount")
    private BigDecimal principalAmount;

    @NotNull(message = "date is required")
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus status;

    public enum LoanStatus {
        ACTIVE,
        CLOSED
    }

    @NotNull(message = "product id is required")
    @Column(name = "product_id")
    private Long productId;

    public Loan() {
    }

    public Loan(Long id, String customerId,
                BigDecimal principalAmount,
                LocalDate startDate,
                LocalDate endDate,
                LoanStatus status,
                Long productId) {

        this.id = id;
        this.customerId = customerId;
        this.principalAmount = principalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.productId = productId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
