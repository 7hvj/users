package com.example.userbackend.repository;

import com.example.userbackend.entity.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface requestsRepository extends JpaRepository<Requests,Long> {
}
