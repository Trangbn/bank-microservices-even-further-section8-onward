package com.review.loans.loans.repository;

import com.review.loans.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loans,Long> {
    public Optional<Loans> findByMobileNumber(String mobileNumber);
}
