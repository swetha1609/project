package com.loan.loan.management.system.Controller;


import com.loan.loan.management.system.Dto.RepaymentScheduleResponseDto;
import com.loan.loan.management.system.Service.RepaymentScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repayment")
@RequiredArgsConstructor
public class RepaymentScheduleController {
    private final RepaymentScheduleService repaymentScheduleService;

    @GetMapping
    public List<RepaymentScheduleResponseDto> GetAll(){
        return repaymentScheduleService.getAll();
    }

    @GetMapping("/{id}")
    public RepaymentScheduleResponseDto GetById(@PathVariable Long id){
        return repaymentScheduleService.getById(id);
    }

}
