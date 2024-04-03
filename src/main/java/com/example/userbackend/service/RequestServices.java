package com.example.userbackend.service;

import com.example.userbackend.dto.*;
import com.example.userbackend.entity.Requests;
import com.example.userbackend.entity.WithdrawalRequest;


import java.util.List;
import java.util.Map;

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
    List<Map<String, Object >> getAllRepairRequest();

//    withdrawal Request functions:
    WithdrawalRequestDto addWithdrawalRequest(WithdrawalRequestDto withdrawalRequestDto);
    WithdrawalRequestDto getWithdrawalRequestById(Long withdrawalId);
    WithdrawalRequestDto ApprovedWithdrawalRequestById(Long withdrawalId);
    WithdrawalRequestDto RejectedWithdrawalRequestById(Long withdrawalId);
    void deleteWithdrawalRequest(Long withdrawalId);
    List<WithdrawalRequestDto> getAllWithdrawalRequest();

    //    NominateToHousing Request functions:
    NominateToHousingDto addNominateToHousing(NominateToHousingDto nominateToHousingDto);
    NominateToHousingDto getNominateToHousingId(Long nominateToHousingId);
    NominateToHousingDto ApprovedNominateToHousing(Long nominateToHousingId);
    NominateToHousingDto RejectedNominateToHousing(Long nominateToHousingId);
    void deleteNominateToHousing(Long nominateToHousingId);
    List<NominateToHousingDto> getAllNominateToHousing();
//    Requests
    List<Requests> getAllRequests();

}
