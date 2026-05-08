package com.review.loans.loans.service.impl;

import com.review.loans.loans.dto.LoanDto;
import com.review.loans.loans.entity.Loans;
import com.review.loans.loans.exception.ResourceNotFoundException;
import com.review.loans.loans.mapper.LoanMapper;
import com.review.loans.loans.repository.LoanRepository;
import com.review.loans.loans.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {

    private LoanRepository loanRepository;

    @Override
    public LoanDto findByMobileNumber(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("MobileNumber", "mobileNumber", mobileNumber)
        );

        return LoanMapper.mapToLoanDto(loans, new LoanDto());
    }

    @Override
    public void create(LoanDto loanDto) {
        Loans loans = LoanMapper.mapToLoans(loanDto, new Loans());
        loanRepository.save(loans);
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        boolean result = false;
        Loans loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("MobileNumber", "mobileNumber", mobileNumber)
        );
        loanRepository.delete(loan);
        result = true;
        return result;
    }

    @Override
    public LoanDto updateLoan(LoanDto loanDto) {
        Loans loans = loanRepository.findByMobileNumber(loanDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("MobileNumber", "mobileNumber", loanDto.getMobileNumber())
        );

        LoanMapper.mapToLoans(loanDto, loans);
        Loans save = loanRepository.save(loans);
        return LoanMapper.mapToLoanDto(save, new LoanDto());
    }

}
