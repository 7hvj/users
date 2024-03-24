package com.example.userbackend.repository;

import com.example.userbackend.entity.NewRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRequestRepository extends JpaRepository<NewRequest,Long> {

}
