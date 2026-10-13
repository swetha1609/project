package com.loan.loan.management.system.Service;

import com.loan.loan.management.system.Dto.LoanRequestDto;
import com.loan.loan.management.system.Dto.LoanResponseDto;
import com.loan.loan.management.system.Entity.Loan;
import com.loan.loan.management.system.Entity.LoanProduct;
import com.loan.loan.management.system.Entity.RepaymentSchedule;
import com.loan.loan.management.system.Repository.LoanProductRepository;
import com.loan.loan.management.system.Repository.LoanRepository;
import com.loan.loan.management.system.Repository.RepaymentScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanProductRepository loanProductRepository;
    private final RepaymentScheduleRepository repaymentScheduleRepository;

    public LoanResponseDto create(LoanRequestDto dto) {

        LoanProduct product = loanProductRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Loan product not found"));

        Loan loan = new Loan();
        loan.setCustomerId(dto.getCustomerId());
        loan.setPrincipalAmount(dto.getPrincipalAmount());
        loan.setStartDate(dto.getStartDate());
        loan.setProductId(product.getId());
        loan.setStatus(Loan.LoanStatus.ACTIVE);
        loan.setEndDate(dto.getStartDate().plusMonths(product.getNumberOfRepayments()));

        Loan savedLoan = loanRepository.save(loan);

        generateRepaymentSchedule(savedLoan, product);

        return toResponseDto(savedLoan);
    }

    private BigDecimal calculateEMI(BigDecimal principal,
                                    BigDecimal annualRate,
                                    Integer months) {

        // Monthly interest rate
        double rate = annualRate.doubleValue() / 12 / 100;

        // PMT Formula
        double emi = (principal.doubleValue() * rate)
                / (1 - Math.pow(1 + rate, -months));

        return BigDecimal.valueOf(emi)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private void generateRepaymentSchedule(Loan loan, LoanProduct product) {
        Integer month = product.getNumberOfRepayments();

        BigDecimal emi = calculateEMI(loan.getPrincipalAmount(), product.getInterestRate(), month);
        BigDecimal outstanding = loan.getPrincipalAmount();
        BigDecimal monthlyRate = product.getInterestRate().divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP).
                divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

        for (int i = 1; i <= month; i++) {

            BigDecimal interest = outstanding.multiply(monthlyRate);
            BigDecimal principal = emi.subtract(interest);
            outstanding = outstanding.subtract(principal);

            if (i == month) {
                outstanding = BigDecimal.ZERO;
            }

            RepaymentSchedule schedule = new RepaymentSchedule();
            schedule.setLoanId(loan.getId());
            schedule.setInstallmentNumber(i);
            schedule.setDueDate(loan.getStartDate().plusMonths(i));
            schedule.setEmiAmount(emi);
            schedule.setInterestComponent(interest);
            schedule.setPrincipalComponent(principal);
            schedule.setOutstandingPrincipal(outstanding);
            schedule.setStatus(RepaymentSchedule.STATUS.Pending);

            repaymentScheduleRepository.save(schedule);
        }
    }

    public List<LoanResponseDto> getAll(){
        return loanRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public LoanResponseDto getById(Long id){
        return toResponseDto(findEntityById(id));
    }

    public LoanResponseDto update(Long id, LoanRequestDto dto){
        Loan existing = findEntityById(id);

        LoanProduct product = loanProductRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Loan product not found"));

        existing.setCustomerId(dto.getCustomerId());
        existing.setPrincipalAmount(dto.getPrincipalAmount());
        existing.setStartDate(dto.getStartDate());
        existing.setProductId(product.getId());
        existing.setEndDate(dto.getStartDate().plusMonths(product.getNumberOfRepayments()));

        return toResponseDto(loanRepository.save(existing));
    }

    public void delete(Long id){
        loanRepository.deleteById(id);
    }

    private Loan findEntityById(Long id){
        return loanRepository.findById(id).orElseThrow(()->new RuntimeException("loan not found"));
    }

    private LoanResponseDto toResponseDto(Loan loan){
        return new LoanResponseDto(
                loan.getId(),
                loan.getCustomerId(),
                loan.getPrincipalAmount(),
                loan.getStartDate(),
                loan.getEndDate(),
                loan.getStatus(),
                loan.getProductId()
        );
    }
}
