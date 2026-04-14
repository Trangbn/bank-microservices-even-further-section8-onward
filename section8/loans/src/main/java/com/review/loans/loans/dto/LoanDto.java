package com.review.loans.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoanDto {

    @Pattern(regexp = "^\\+?[0-9]{9,10}$", message = "Phone number is invalid")
    private String mobileNumber;

    @NotEmpty(message = "LoanNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "LoanNumber must be 10 digits")
    private String loanNumber;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;

}
