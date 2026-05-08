package com.review.loans.loans.service;

import com.review.loans.loans.dto.LoanDto;

public interface ILoanService {
    public LoanDto findByMobileNumber(String mobileNumber);
    public void create(LoanDto loanDto);
    public boolean deleteLoan(String mobileNumber);
    public LoanDto updateLoan(LoanDto loanDto);
}
