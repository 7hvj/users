package com.example.userbackend.controller;

import com.example.userbackend.dto.WithdrawalRequestDto;
import com.example.userbackend.entity.Requests;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/requests")
public class RequestsController {

    private RequestServices requestServices;
    @GetMapping("/import")
    public ResponseEntity<List<Requests>> getAllRequests() {
        List<Requests> requestDos=requestServices.getAllRequests();
        return ResponseEntity.ok(requestDos);
    }

}
