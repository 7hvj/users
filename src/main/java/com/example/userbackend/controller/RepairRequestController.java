package com.example.userbackend.controller;

import com.example.userbackend.dto.RenewRequestDto;
import com.example.userbackend.dto.RepairRequestDto;
import com.example.userbackend.dto.merged;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/repairRequest")
public class RepairRequestController {
    private RequestServices requestServices;
    //    Create repair Request
    @PostMapping("/addRequest")
    public ResponseEntity<RepairRequestDto> addRepairRequest(@RequestBody RepairRequestDto repairRequestDto){
        try{
        RepairRequestDto savedRequest=requestServices.addRepairRequest(repairRequestDto);
            return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    //    get repair request by id
    @GetMapping("/{id}")
    public ResponseEntity<RepairRequestDto>getRepairRequest(@PathVariable("id") Long repairRequestId){
        RepairRequestDto repairRequestDto=requestServices.getRepairRequestById(repairRequestId);
        return ResponseEntity.ok(repairRequestDto);

    }
    //        update repair request into approved
    @PutMapping("/ApprovedRequest/{id}")
    public ResponseEntity<RepairRequestDto>approvedRepairRequest(@PathVariable("id") Long repairRequestId){
        RepairRequestDto repairRequestDto=requestServices.ApprovedRepairRequest(repairRequestId);
        return ResponseEntity.ok(repairRequestDto);
    }
//    //        update repair request into rejected
    @PutMapping("/RejectedRequest/{id}")
    public ResponseEntity<RepairRequestDto>rejectedRepairRequest(@PathVariable("id") Long repairRequestId){
        RepairRequestDto repairRequestDto=requestServices.RejectedRepairRequest(repairRequestId);
        return ResponseEntity.ok(repairRequestDto);
    }
    //    delete repair request
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteRepairRequest(@PathVariable("id") Long repairRequestId){
        requestServices.deleteRepairRequest(repairRequestId);
        return ResponseEntity.ok("Repair Request Deleted Successfully");
    }
    //        get all repair request
    @GetMapping("/AllRequests")
    public ResponseEntity<List<Map<String, Object >>>getAllRepairRequest(){
        try {
            List<Map<String, Object >> requestDos = requestServices.getAllRepairRequest();
            return ResponseEntity.ok(requestDos);
        }
                catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
