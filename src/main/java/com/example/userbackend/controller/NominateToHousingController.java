package com.example.userbackend.controller;

import com.example.userbackend.dto.NominateToHousingDto;
import com.example.userbackend.dto.WithdrawalRequestDto;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/nominateToHousing")
public class NominateToHousingController {
    private RequestServices requestServices;
    //    create nominateToHousing request
    @PostMapping("/addRequest")
    public ResponseEntity<NominateToHousingDto> addNominateToHousing(@RequestBody NominateToHousingDto nominateToHousingDto){
            NominateToHousingDto savedRequest=requestServices.addNominateToHousing(nominateToHousingDto);
            return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
        }
    //    get nominateToHousing by id
    @GetMapping("/{id}")
    public ResponseEntity<NominateToHousingDto>getNominateToHousing(@PathVariable("id") Long nominateToHousingId){
        NominateToHousingDto NominateToHousingDto=requestServices.getNominateToHousingId(nominateToHousingId);
        return ResponseEntity.ok(NominateToHousingDto);

    }
    //    update nominateToHousing into approved
    @PutMapping("/ApprovedRequest/{id}")
    public ResponseEntity<NominateToHousingDto>approvedNominateToHousing(@PathVariable("id") Long nominateToHousingId){
        NominateToHousingDto NominateToHousingDto=requestServices.ApprovedNominateToHousing(nominateToHousingId);
        return ResponseEntity.ok(NominateToHousingDto);

    }
    //    update nominateToHousing into approved
    @PutMapping("/RejectedRequest/{id}")
    public ResponseEntity<NominateToHousingDto>rejectedNominateToHousing(@PathVariable("id") Long nominateToHousingId){
        NominateToHousingDto NominateToHousingDto=requestServices.RejectedNominateToHousing(nominateToHousingId);
        return ResponseEntity.ok(NominateToHousingDto);

    }
    //    delete nominateToHousing request
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String>deleteNominateToHousing(@PathVariable("id") Long nominateToHousingId){
        requestServices.deleteNominateToHousing(nominateToHousingId);
        return ResponseEntity.ok("nominateToHousing Request Deleted Successfully");

    }
    @GetMapping("/AllRequests")
    public ResponseEntity<List<NominateToHousingDto>>getAllNominateToHousing(){
        List<NominateToHousingDto> requestDos=requestServices.getAllNominateToHousing();
        return ResponseEntity.ok(requestDos);

    }

}
