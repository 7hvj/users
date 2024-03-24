package com.example.userbackend.controller;

import com.example.userbackend.dto.NewRequestDto;
import com.example.userbackend.dto.UserDto;
import com.example.userbackend.role.RequestStatus;
import com.example.userbackend.role.RequestType;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/NewRequest")
public class NewRequestController {
    private RequestServices requestServices;

//    Create New Request
@PostMapping("/addRequest")
    public ResponseEntity<NewRequestDto> addNewRequest(@RequestBody NewRequestDto newRequestDto){
    try {
        NewRequestDto savedRequest=requestServices.addNewRequest(newRequestDto);
        return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
    }
    catch (Exception e){
        System.err.println(e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
//    get request by id
    @GetMapping("/{id}")
    public ResponseEntity<NewRequestDto> getNewRequest(@PathVariable("id") Long newRequestId){

    NewRequestDto newRequestDto=requestServices.getNewRequestById(newRequestId);
    return ResponseEntity.ok(newRequestDto);
    }
//    update the status of request into Approved
    @PutMapping("ApprovedRequest/{id}")
    public  ResponseEntity<NewRequestDto>ApprovedStatus(@PathVariable("id") Long newRequestId){
    NewRequestDto newRequestDto1=requestServices.ApprovedStatus(newRequestId);
    return ResponseEntity.ok(newRequestDto1);
    }
    //    update the status of request into Approved
    @PutMapping("RejectedRequest/{id}")
    public  ResponseEntity<NewRequestDto>RejectedStatus(@PathVariable("id") Long newRequestId){
        NewRequestDto newRequestDto1=requestServices.RejectedStatus(newRequestId);
        return ResponseEntity.ok(newRequestDto1);
    }
//    Delete New Request
@DeleteMapping("/Delete/{id}")
    public ResponseEntity<String>deleteNewRequest(@PathVariable("id") Long newRequestId){
    requestServices.deleteNewRequest(newRequestId);
    return ResponseEntity.ok("New Request Deleted Successfully");
    }
    //    Get All new Requests
    @GetMapping("/AllRequests")
    public ResponseEntity<List<NewRequestDto>> getAllNewRequest(){
        List<NewRequestDto> requests=requestServices.getAllNewRequest();
        return ResponseEntity.ok(requests);
    }
}
