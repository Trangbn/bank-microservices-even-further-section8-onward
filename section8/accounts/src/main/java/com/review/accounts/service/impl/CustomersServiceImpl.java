package com.review.accounts.service.impl;

import com.review.accounts.dto.AccountDto;
import com.review.accounts.dto.CardsDto;
import com.review.accounts.dto.CustomerDetailsDto;
import com.review.accounts.dto.LoanDto;
import com.review.accounts.entity.Account;
import com.review.accounts.entity.Customer;
import com.review.accounts.exception.ResourceNotFoundException;
import com.review.accounts.mapper.AccountMapper;
import com.review.accounts.mapper.CustomerMapper;
import com.review.accounts.repository.AccountRepository;
import com.review.accounts.repository.CustomerRepository;
import com.review.accounts.service.ICustomersService;
import com.review.accounts.service.client.CardsFeignClient;
import com.review.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private LoansFeignClient loansFeignClient;
    private CardsFeignClient cardsFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountDto(AccountMapper.mapToAccountDto(account, new AccountDto()));

        ResponseEntity<LoanDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoanDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
