package com.loan.loan.management.system.Service;

import com.loan.loan.management.system.Dto.RepaymentScheduleResponseDto;
import com.loan.loan.management.system.Entity.RepaymentSchedule;
import com.loan.loan.management.system.Repository.RepaymentScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepaymentScheduleService {
    private final RepaymentScheduleRepository repaymentScheduleRepository;

    public List<RepaymentScheduleResponseDto> getAll() {
        return repaymentScheduleRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public RepaymentScheduleResponseDto getById(Long id) {
        return toResponseDto(repaymentScheduleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Repayment Schedule Not Found")));
    }

    private RepaymentScheduleResponseDto toResponseDto(RepaymentSchedule schedule){
        return new RepaymentScheduleResponseDto(
                schedule.getId(),
                schedule.getInstallmentNumber(),
                schedule.getDueDate(),
                schedule.getEmiAmount(),
                schedule.getPrincipalComponent(),
                schedule.getInterestComponent(),
                schedule.getOutstandingPrincipal(),
                schedule.getStatus(),
                schedule.getLoanId()
        );
    }
}
