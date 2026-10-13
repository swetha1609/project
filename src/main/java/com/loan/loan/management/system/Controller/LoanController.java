package com.loan.loan.management.system.Controller;

import com.loan.loan.management.system.Dto.LoanRequestDto;
import com.loan.loan.management.system.Dto.LoanResponseDto;
import com.loan.loan.management.system.Service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;



    @PostMapping
    public LoanResponseDto create(@Valid @RequestBody LoanRequestDto loan) {
        return loanService.create(loan);
    }

    @GetMapping
    public List<LoanResponseDto> getAll(){
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public LoanResponseDto getById(@PathVariable Long id){
        return loanService.getById(id);
    }

    @PutMapping("/{id}")
    public LoanResponseDto updateProduct(@PathVariable Long id, @Valid @RequestBody LoanRequestDto loan){
        return loanService.update(id,loan);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        loanService.delete(id);
        return "Successfully Deleted.";
    }
}
