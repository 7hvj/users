package com.example.userbackend.controller;

import com.example.userbackend.dto.RepairRequestDto;
import com.example.userbackend.dto.WithdrawalRequestDto;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/withdrawalRequest")
public class WithdrawalRequestController {
    private RequestServices requestServices;

    //    Create withdrawalRequest
    @PostMapping("/addRequest")
    public ResponseEntity<WithdrawalRequestDto> addWithdrawalRequest(@RequestBody WithdrawalRequestDto withdrawalRequestDto){
        WithdrawalRequestDto savedRequest=requestServices.addWithdrawalRequest(withdrawalRequestDto);
        return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
    }
    //    get withdrawalRequest by id
    @GetMapping("/{id}")
    public ResponseEntity<WithdrawalRequestDto>getWithdrawalRequest(@PathVariable("id") Long withdrawalId){
        WithdrawalRequestDto withdrawalRequestDto=requestServices.getWithdrawalRequestById(withdrawalId);
        return ResponseEntity.ok(withdrawalRequestDto);

    }
//    update withdrawalRequest into approved
    @PutMapping("/ApprovedRequest/{id}")
    public ResponseEntity<WithdrawalRequestDto>approvedWithdrawalRequest(@PathVariable("id") Long withdrawalId){
        WithdrawalRequestDto withdrawalRequestDto=requestServices.ApprovedWithdrawalRequestById(withdrawalId);
        return ResponseEntity.ok(withdrawalRequestDto);

    }
//    //    update withdrawalRequest into rejected
    @PutMapping("/RejectedRequest/{id}")
    public ResponseEntity<WithdrawalRequestDto>rejectedWithdrawalRequest(@PathVariable("id") Long withdrawalId){
        WithdrawalRequestDto withdrawalRequestDto=requestServices.RejectedWithdrawalRequestById(withdrawalId);
        return ResponseEntity.ok(withdrawalRequestDto);

    }
    //    delete withdrawalRequest request
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String>deleteWithdrawalRequest(@PathVariable("id") Long withdrawalId){
        requestServices.deleteWithdrawalRequest(withdrawalId);
        return ResponseEntity.ok("withdrawalRequest Request Deleted Successfully");

    }
    @GetMapping("/AllRequests")
    public ResponseEntity<List<WithdrawalRequestDto>>getAllWithdrawalRequest(){
        List<WithdrawalRequestDto> requestDos=requestServices.getAllWithdrawalRequest();
        return ResponseEntity.ok(requestDos);

    }

}
