package com.example.userbackend.repository;

import com.example.userbackend.dto.merged;
import com.example.userbackend.entity.RepairRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RepairRequestRepository extends JpaRepository<RepairRequest,Long> {

    @Query(value = "select requests_id, request_status, request_type, building,room from requests INNER JOIN repair_request on requests_id=repair_request_id", nativeQuery = true)
    List<Map<String, Object >> getRequests ();
}
