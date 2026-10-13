package com.loan.loan.management.system.Controller;

import com.loan.loan.management.system.Dto.LoanProductRequestDto;
import com.loan.loan.management.system.Dto.LoanProductResponseDto;
import com.loan.loan.management.system.Service.LoanProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class LoanProductController {
    private final LoanProductService loanProductService;

    @PostMapping
    public LoanProductResponseDto createProduct(@Valid @RequestBody LoanProductRequestDto loanProduct){
        return loanProductService.create(loanProduct);
    }

    @GetMapping
    public List<LoanProductResponseDto> getAll(){
        return loanProductService.getAll();
    }

    @GetMapping("/{id}")
    public LoanProductResponseDto getById(@PathVariable Long id){
        return loanProductService.getById(id);
    }

    @PutMapping("/{id}")
    public LoanProductResponseDto updateProduct(@PathVariable Long id,@Valid @RequestBody LoanProductRequestDto loanProduct){
        return loanProductService.update(id,loanProduct);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
         loanProductService.delete(id);
         return "Successfully Deleted.";
    }
}
