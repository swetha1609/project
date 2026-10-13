package com.loan.loan.management.system.Service;

import com.loan.loan.management.system.Dto.TransactionRequestDto;
import com.loan.loan.management.system.Dto.TransactionResponseDto;
import com.loan.loan.management.system.Entity.Loan;
import com.loan.loan.management.system.Entity.RepaymentSchedule;
import com.loan.loan.management.system.Entity.Transaction;
import com.loan.loan.management.system.Repository.LoanRepository;
import com.loan.loan.management.system.Repository.RepaymentScheduleRepository;
import com.loan.loan.management.system.Repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class    TransactionService {
    private final TransactionRepository transactionRepository;
    private final LoanRepository loanRepository;
    private final RepaymentScheduleRepository repaymentScheduleRepository;

    public TransactionResponseDto create(Long loanId, TransactionRequestDto dto) {

        // Find the loan
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        // Associate the transaction with the loan
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(dto.getTransactionDate());
        transaction.setAmountPaid(dto.getAmountPaid());
        transaction.setLoanId(loan.getId());

        // Save the transaction
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Update the first pending repayment schedule
        RepaymentSchedule schedule =
                repaymentScheduleRepository
                        .findFirstByLoanIdAndStatusOrderByInstallmentNumber(
                                loan.getId(),
                                RepaymentSchedule.STATUS.Pending);

        if (schedule != null) {
            schedule.setStatus(RepaymentSchedule.STATUS.Paid);
            repaymentScheduleRepository.save(schedule);
        }

        // Check whether all installments are paid
        List<RepaymentSchedule> schedules =
                repaymentScheduleRepository.findByLoanId(loan.getId());

        boolean hasPending = schedules.stream()
                .anyMatch(s -> s.getStatus() == RepaymentSchedule.STATUS.Pending);

        if (!hasPending) {
            loan.setStatus(Loan.LoanStatus.CLOSED);
            loanRepository.save(loan);
        }

        return toResponseDto(savedTransaction);
    }

    public List<TransactionResponseDto> getAll() {

        List<Transaction> transactions=  transactionRepository.findAll();

        List<TransactionResponseDto> transactionResponseDtos =  new ArrayList<>();
        for(Transaction tx: transactions){
            TransactionResponseDto dto  =  toResponseDto(tx);
            transactionResponseDtos.add(dto);
        }
        return transactionResponseDtos;
    }

    public TransactionResponseDto getById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return toResponseDto(transaction);
    }

    private TransactionResponseDto toResponseDto(Transaction transaction){
        return new TransactionResponseDto(
                transaction.getId(),
                transaction.getTransactionDate(),
                transaction.getAmountPaid(),
                transaction.getLoanId()
        );
    }
}
