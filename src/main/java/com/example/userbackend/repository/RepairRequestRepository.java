package com.example.userbackend.repository;

import com.example.userbackend.entity.RepairRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRequestRepository extends JpaRepository<RepairRequest,Long> {
}
