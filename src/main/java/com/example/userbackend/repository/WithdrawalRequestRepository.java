package com.example.userbackend.repository;

import com.example.userbackend.entity.WithdrawalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRequestRepository extends JpaRepository<WithdrawalRequest,Long> {
}
