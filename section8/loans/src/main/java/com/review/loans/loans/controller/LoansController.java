package com.review.loans.loans.controller;

import com.review.loans.loans.constants.LoansConstant;
import com.review.loans.loans.dto.LoanDto;
import com.review.loans.loans.dto.LoansContactInfoDto;
import com.review.loans.loans.dto.ResponseDto;
import com.review.loans.loans.service.ILoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LoansController {

    private ILoanService loanService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private LoansContactInfoDto loansContactInfoDto;

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> findByMobileNumber(@RequestParam String mobileNumber){
        LoanDto byMobileNumber = loanService.findByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(byMobileNumber);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody LoanDto loanDto) {
        loanService.create(loanDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(LoansConstant.STATUS_201, LoansConstant.MESSAGE_201));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam String mobileNumber){
        boolean isDeleted =  loanService.deleteLoan(mobileNumber);
        return isDeleted ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstant.STATUS_200, LoansConstant.MESSAGE_200)) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(LoansConstant.STATUS_417, LoansConstant.MESSAGE_417_DELETE))   ;
    }

    @PatchMapping("/update")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody LoanDto loanDto){
        LoanDto updatedLoan = loanService.updateLoan(loanDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstant.STATUS_417, LoansConstant.MESSAGE_417_UPDATE));
    }

    @GetMapping("/loans-info")
    public ResponseEntity<LoansContactInfoDto> loansInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(loansContactInfoDto);
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> buildInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }
}
