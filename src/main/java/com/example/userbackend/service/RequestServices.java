package com.example.userbackend.service;

import com.example.userbackend.dto.NewRequestDto;
import com.example.userbackend.dto.RenewRequestDto;
import com.example.userbackend.dto.RepairRequestDto;


import java.util.List;

public interface RequestServices {
//    New Request functions:
    NewRequestDto addNewRequest(NewRequestDto newRequestDto);
    NewRequestDto getNewRequestById(Long newRequestId);
    NewRequestDto ApprovedStatus(Long newRequestId);
    NewRequestDto RejectedStatus(Long newRequestId);
    void deleteNewRequest(Long newRequestId);
    List<NewRequestDto> getAllNewRequest();

    //    reNew Request functions:
    RenewRequestDto addRenewRequest(RenewRequestDto renewRequestDto);
    RenewRequestDto getRenewRequestById(Long renewRequestId);
    RenewRequestDto ApprovedRenewRequest(Long renewRequestId);
    RenewRequestDto RejectedRenewRequest(Long renewRequestId);
    void deleteRenewRequest(Long renewRequestId);
    List<RenewRequestDto> getAllRenewRequest();

    //    Repair Request functions:
    RepairRequestDto addRepairRequest(RepairRequestDto repairRequestDto);
    RepairRequestDto getRepairRequestById(Long repairRequestId);
    RepairRequestDto ApprovedRepairRequest(Long repairRequestId);
    RepairRequestDto RejectedRepairRequest(Long repairRequestId);
    void deleteRepairRequest(Long repairRequestId);
    List<RepairRequestDto> getAllRepairRequest();
}
