package com.loan.loan.management.system.Controller;


import com.loan.loan.management.system.Dto.TransactionRequestDto;
import com.loan.loan.management.system.Dto.TransactionResponseDto;
import com.loan.loan.management.system.Service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionResponseDto> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public TransactionResponseDto getById(@PathVariable Long id) {
        return transactionService.getById(id);
    }

    @PostMapping("/{loanId}")
    public TransactionResponseDto create(@PathVariable Long loanId,
                              @Valid @RequestBody TransactionRequestDto transaction) {

        return transactionService.create(loanId, transaction);
    }

}
