package com.example.userbackend.repository;

import com.example.userbackend.entity.RenewRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenewRequestRepository extends JpaRepository<RenewRequest,Long> {
}
