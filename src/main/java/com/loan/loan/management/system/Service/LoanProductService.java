package com.loan.loan.management.system.Service;

import com.loan.loan.management.system.Dto.LoanProductRequestDto;
import com.loan.loan.management.system.Dto.LoanProductResponseDto;
import com.loan.loan.management.system.Entity.LoanProduct;
import com.loan.loan.management.system.Repository.LoanProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  LoanProductService {
    private final LoanProductRepository loanProductRepository;

    public LoanProductResponseDto create(LoanProductRequestDto dto){
        LoanProduct loanProduct = new LoanProduct();
        loanProduct.setProductName(dto.getProductName());
        loanProduct.setInterestRate(dto.getInterestRate());
        loanProduct.setNumberOfRepayments(dto.getNumberOfRepayments());
        loanProduct.setDayCountConvention(dto.getDayCountConvention());

        return toResponseDto(loanProductRepository.save(loanProduct));
    }

    public List<LoanProductResponseDto> getAll(){
        return loanProductRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public LoanProductResponseDto getById(Long id){
        return toResponseDto(findEntityById(id));
    }

    public LoanProductResponseDto update(Long id, LoanProductRequestDto dto){
        LoanProduct existing = findEntityById(id);

        existing.setProductName(dto.getProductName());
        existing.setInterestRate(dto.getInterestRate());
        existing.setNumberOfRepayments(dto.getNumberOfRepayments());
        existing.setDayCountConvention(dto.getDayCountConvention());

        return toResponseDto(loanProductRepository.save(existing));
    }

    public void delete(Long id){
        loanProductRepository.deleteById(id);
    }

    private LoanProduct findEntityById(Long id){
        return loanProductRepository.findById(id).orElseThrow(()->new RuntimeException("loan product not found"));
    }

    private LoanProductResponseDto toResponseDto(LoanProduct loanProduct){
        return new LoanProductResponseDto(
                loanProduct.getId(),
                loanProduct.getProductName(),
                loanProduct.getInterestRate(),
                loanProduct.getNumberOfRepayments(),
                loanProduct.getDayCountConvention()
        );
    }
}
