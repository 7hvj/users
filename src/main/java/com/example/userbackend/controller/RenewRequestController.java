package com.example.userbackend.controller;

import com.example.userbackend.dto.RenewRequestDto;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/renewRequest")
public class RenewRequestController {
    private RequestServices requestServices;
//    Create Renew Request
    @PostMapping("/addRequest")
    public ResponseEntity<RenewRequestDto> addRenewRequest(@RequestBody RenewRequestDto renewRequestDto){
        RenewRequestDto savedRequest=requestServices.addRenewRequest(renewRequestDto);
        return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);

    }
//    get renew request by id
    @GetMapping("/{id}")
    public ResponseEntity<RenewRequestDto>getRenewRequest(@PathVariable("id") Long renewRequestId){
            RenewRequestDto renewRequestDto=requestServices.getRenewRequestById(renewRequestId);
            return ResponseEntity.ok(renewRequestDto);
        }
//        update renew request into approved
    @PutMapping("/ApprovedRequest/{id}")
    public ResponseEntity<RenewRequestDto>approvedRenewRequest(@PathVariable("id") Long renewRequestId){
        RenewRequestDto renewRequestDto=requestServices.ApprovedRenewRequest(renewRequestId);
        return ResponseEntity.ok(renewRequestDto);
    }
    //        update renew request into rejected
    @PutMapping("/RejectedRequest/{id}")
    public ResponseEntity<RenewRequestDto>rejectedRenewRequest(@PathVariable("id") Long renewRequestId){
        RenewRequestDto renewRequestDto=requestServices.RejectedRenewRequest(renewRequestId);
        return ResponseEntity.ok(renewRequestDto);
    }
//    delete renew request
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleterenewRequest(@PathVariable("id") Long renewRequestId){
            requestServices.deleteRenewRequest(renewRequestId);
            return ResponseEntity.ok("Renew Request Deleted Successfully");
        }
//        get all renew request
    @GetMapping("/AllRequests")
    public ResponseEntity<List<RenewRequestDto>>getAllrenewRequest(){
            List<RenewRequestDto> requestDtos=requestServices.getAllRenewRequest();
            return ResponseEntity.ok(requestDtos);
        }
}
