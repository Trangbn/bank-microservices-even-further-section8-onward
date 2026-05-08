package com.review.loans.loans.mapper;

import com.review.loans.loans.dto.LoanDto;
import com.review.loans.loans.entity.Loans;

public class LoanMapper {

    public static LoanDto mapToLoanDto(Loans loan, LoanDto loanDto){
        loanDto.setTotalLoan(loan.getTotalLoan());
        loanDto.setAmountPaid(loan.getAmountPaid());
        loanDto.setOutstandingAmount(loan.getOutstandingAmount());
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setMobileNumber(loan.getMobileNumber());
        return loanDto;
    }

    public static Loans mapToLoans(LoanDto loanDto, Loans loans){
        loans.setTotalLoan(loanDto.getTotalLoan());
        loans.setAmountPaid(loanDto.getAmountPaid());
        loans.setOutstandingAmount(loanDto.getOutstandingAmount());
        loans.setLoanNumber(loanDto.getLoanNumber());
        loans.setLoanType(loanDto.getLoanType());
        loans.setMobileNumber(loanDto.getMobileNumber());
        return loans;
    }

}
