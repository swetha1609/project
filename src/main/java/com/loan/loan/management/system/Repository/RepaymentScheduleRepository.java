package com.loan.loan.management.system.Repository;

import com.loan.loan.management.system.Entity.RepaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepaymentScheduleRepository extends JpaRepository<RepaymentSchedule,Long> {
    List<RepaymentSchedule> findByLoanId(Long loanId);
   RepaymentSchedule findFirstByLoanIdAndStatusOrderByInstallmentNumber(
            Long loanId,
            RepaymentSchedule.STATUS status
    );
}
