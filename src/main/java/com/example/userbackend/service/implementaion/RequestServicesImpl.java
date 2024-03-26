package com.example.userbackend.service.implementaion;

import com.example.userbackend.dto.*;
import com.example.userbackend.entity.*;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.mapper.*;
import com.example.userbackend.repository.*;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestServicesImpl implements RequestServices {
    private NewRequestRepository newRequestRepository;
    private RenewRequestRepository renewRequestRepository;
    private RepairRequestRepository repairRequestRepository;
    private WithdrawalRequestRepository withdrawalRequestRepository;
    private NominateToHousingRepository nominateToHousingRepository;

//    new request functions:
    @Override
    public NewRequestDto addNewRequest(NewRequestDto newRequestDto) {
        NewRequest newRequest= NewRequestMapper.mapToNewRequest(newRequestDto);
        newRequest.setRequestType("NEW_REQUEST");
        newRequest.setRequestStatus("PENDING");
        NewRequest savedRequest=newRequestRepository.save(newRequest);
        return NewRequestMapper.mapToNewRequestDto(savedRequest);
    }

    @Override
    public NewRequestDto getNewRequestById(Long newRequestId) {
        NewRequest newRequest=newRequestRepository.findById(newRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+newRequestId));
        return NewRequestMapper.mapToNewRequestDto(newRequest);
    }
//    update the status of request into approved
    @Override
    public NewRequestDto ApprovedStatus(Long newRequestId) {
        NewRequest newRequest= newRequestRepository.findById(newRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+newRequestId));
        newRequest.setRequestStatus("APPROVED");
        NewRequest savedRequest=newRequestRepository.save(newRequest);
        return NewRequestMapper.mapToNewRequestDto(savedRequest);
    }
    //    update the status of request into rejected
    @Override
    public NewRequestDto RejectedStatus(Long newRequestId) {
        NewRequest newRequest= newRequestRepository.findById(newRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+newRequestId));
        newRequest.setRequestStatus("REJECTED");
        NewRequest savedRequest=newRequestRepository.save(newRequest);
        return NewRequestMapper.mapToNewRequestDto(savedRequest);
    }
//    Delete New Request
    @Override
    public void deleteNewRequest(Long newRequestId) {
        NewRequest newRequest= newRequestRepository.findById(newRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+newRequestId));
        newRequestRepository.deleteById(newRequestId);
    }
//    Get all Request
    @Override
    public List<NewRequestDto> getAllNewRequest() {
        List<NewRequest> newRequests=newRequestRepository.findAll();

        return newRequests.stream()
                .map(NewRequestMapper::mapToNewRequestDto)
                .collect(Collectors.toList());
    }
    //    renew request functions:
    //    add renew request
    @Override
    public RenewRequestDto addRenewRequest(RenewRequestDto renewRequestDto) {
        RenewRequest renewRequest= RenewRequestMapper.mapToRenewRequest(renewRequestDto);
        renewRequest.setRequestType("RENEW_REQUEST");
        renewRequest.setRequestStatus("PENDING");
        renewRequest.setTerm("FIRST_TERM");
        renewRequest.setAcademicYear("2023-2024");
        RenewRequest savedRequest=renewRequestRepository.save(renewRequest);

        return RenewRequestMapper.mapToRenewRequestDto(savedRequest);
    }
// get renew request
    @Override
    public RenewRequestDto getRenewRequestById(Long renewRequestId) {
        RenewRequest renewRequest=renewRequestRepository.findById(renewRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+renewRequestId));
        return RenewRequestMapper.mapToRenewRequestDto(renewRequest);
    }
// update renew request to approved
    @Override
    public RenewRequestDto ApprovedRenewRequest(Long renewRequestId) {
        RenewRequest renewRequest=renewRequestRepository.findById(renewRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+renewRequestId));
        renewRequest.setRequestStatus("APPROVED");
        RenewRequest savedRequest=renewRequestRepository.save(renewRequest);
        return RenewRequestMapper.mapToRenewRequestDto(savedRequest);
    }
    // update renew request to rejected
    @Override
    public RenewRequestDto RejectedRenewRequest(Long renewRequestId) {
        RenewRequest renewRequest=renewRequestRepository.findById(renewRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+renewRequestId));
        renewRequest.setRequestStatus("REJECTED");
        RenewRequest savedRequest=renewRequestRepository.save(renewRequest);
        return RenewRequestMapper.mapToRenewRequestDto(savedRequest);
    }
    // delete renew request
    @Override
    public void deleteRenewRequest(Long renewRequestId) {
        RenewRequest renewRequest=renewRequestRepository.findById(renewRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+renewRequestId));
        renewRequestRepository.deleteById(renewRequestId);

    }
//    get all renew request
    @Override
    public List<RenewRequestDto> getAllRenewRequest() {
        List<RenewRequest> renewRequests=renewRequestRepository.findAll();

        return renewRequests.stream()
                .map(RenewRequestMapper::mapToRenewRequestDto)
                .collect(Collectors.toList());
    }
//    Repair request function:
//    addRenewRequest
    @Override
    public RepairRequestDto addRepairRequest(RepairRequestDto repairRequestDto) {
        RepairRequest repairRequest= RepairRequestMapper.mapToRepairRequest(repairRequestDto);
        repairRequest.setRequestType("REPAIR_REQUEST");
        repairRequest.setRequestStatus("PENDING");
        RepairRequest savedRequest=repairRequestRepository.save(repairRequest);
        return RepairRequestMapper.mapToRepairRequestDto(savedRequest);

    }
//    get repair request by id

    @Override
    public RepairRequestDto getRepairRequestById(Long repairRequestId) {
        RepairRequest repairRequest=repairRequestRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));

        return RepairRequestMapper.mapToRepairRequestDto(repairRequest);
    }
    // update repair request to approved
    @Override
    public RepairRequestDto ApprovedRepairRequest(Long repairRequestId) {
        RepairRequest repairRequest=repairRequestRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));
        repairRequest.setRequestStatus("APPROVED");
        RepairRequest savedRequest=repairRequestRepository.save(repairRequest);
        return RepairRequestMapper.mapToRepairRequestDto(savedRequest);
    }
    // update repair request to rejected
    @Override
    public RepairRequestDto RejectedRepairRequest(Long repairRequestId) {
        RepairRequest repairRequest=repairRequestRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));
        repairRequest.setRequestStatus("REJECTED");
        RepairRequest savedRequest=repairRequestRepository.save(repairRequest);
        return RepairRequestMapper.mapToRepairRequestDto(savedRequest);
    }
    // delete repair request
    @Override
    public void deleteRepairRequest(Long repairRequestId) {
        RepairRequest repairRequest=repairRequestRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));
        repairRequestRepository.deleteById(repairRequestId);
    }
    // get all repair request
    @Override
    public List<RepairRequestDto> getAllRepairRequest() {
        List<RepairRequest> repairRequests=repairRequestRepository.findAll();

        return repairRequests.stream()
                .map(RepairRequestMapper::mapToRepairRequestDto)
                .collect(Collectors.toList());

    }
// Withdrawal request functions:
    @Override
    public WithdrawalRequestDto addWithdrawalRequest(WithdrawalRequestDto withdrawalRequestDto) {
        WithdrawalRequest withdrawalRequest= WithdrawalRequestMapper.mapToWithdrawalRequest(withdrawalRequestDto);
        withdrawalRequest.setRequestType("WITHDRAWAL_REQUEST");
        withdrawalRequest.setRequestStatus("PENDING");
        WithdrawalRequest savedRequest=withdrawalRequestRepository.save(withdrawalRequest);
        return WithdrawalRequestMapper.mapToWithdrawalRequestDto(savedRequest);
    }
//get Withdrawal
    @Override
    public WithdrawalRequestDto getWithdrawalRequestById(Long withdrawalId) {
        WithdrawalRequest withdrawalRequest=withdrawalRequestRepository.findById(withdrawalId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+withdrawalId));

        return WithdrawalRequestMapper.mapToWithdrawalRequestDto(withdrawalRequest);
    }
//approve Withdrawal
    @Override
    public WithdrawalRequestDto ApprovedWithdrawalRequestById(Long withdrawalId) {
        WithdrawalRequest withdrawalRequest=withdrawalRequestRepository.findById(withdrawalId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+withdrawalId));
        withdrawalRequest.setRequestStatus("APPROVED");
        WithdrawalRequest savedRequest=withdrawalRequestRepository.save(withdrawalRequest);
        return WithdrawalRequestMapper.mapToWithdrawalRequestDto(savedRequest);
    }
// reject: Withdrawal
    @Override
    public WithdrawalRequestDto RejectedWithdrawalRequestById(Long withdrawalId) {
        WithdrawalRequest withdrawalRequest=withdrawalRequestRepository.findById(withdrawalId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+withdrawalId));
        withdrawalRequest.setRequestStatus("REJECTED");
        WithdrawalRequest savedRequest=withdrawalRequestRepository.save(withdrawalRequest);
        return WithdrawalRequestMapper.mapToWithdrawalRequestDto(savedRequest);    }
//delete Withdrawal
    @Override
    public void deleteWithdrawalRequest(Long withdrawalId) {
        WithdrawalRequest withdrawalRequest=withdrawalRequestRepository.findById(withdrawalId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+withdrawalId));
        withdrawalRequestRepository.deleteById(withdrawalId);
    }
//get all Withdrawal
    @Override
    public List<WithdrawalRequestDto> getAllWithdrawalRequest() {
        List<WithdrawalRequest> withdrawalRequests=withdrawalRequestRepository.findAll();

        return withdrawalRequests.stream()
                .map(WithdrawalRequestMapper::mapToWithdrawalRequestDto)
                .collect(Collectors.toList());
    }
// nominate function
//    add nominate request
    @Override
    public NominateToHousingDto addNominateToHousing(NominateToHousingDto nominateToHousingDto) {
        NominateToHousing nominateToHousing= NominateToHousingMapper.mapToNominateToHousing(nominateToHousingDto);
        nominateToHousing.setRequestType("NOMINATE_REQUEST");
        nominateToHousing.setRequestStatus("PENDING");
        NominateToHousing savedRequest=nominateToHousingRepository.save(nominateToHousing);
        return NominateToHousingMapper.mapToNominateToHousingDto(savedRequest);
    }
    //    get nominate request
    @Override
    public NominateToHousingDto getNominateToHousingId(Long nominateToHousingId) {
        NominateToHousing nominateToHousing=nominateToHousingRepository.findById(nominateToHousingId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+nominateToHousingId));

        return NominateToHousingMapper.mapToNominateToHousingDto(nominateToHousing);
    }
    //    approve nominate request
    @Override
    public NominateToHousingDto ApprovedNominateToHousing(Long nominateToHousingId) {
        NominateToHousing nominateToHousing=nominateToHousingRepository.findById(nominateToHousingId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+nominateToHousingId));
        nominateToHousing.setRequestStatus("APPROVED");
        NominateToHousing savedRequest=nominateToHousingRepository.save(nominateToHousing);
        return NominateToHousingMapper.mapToNominateToHousingDto(savedRequest);

    }
    //    reject nominate request
    @Override
    public NominateToHousingDto RejectedNominateToHousing(Long nominateToHousingId) {
        NominateToHousing nominateToHousing=nominateToHousingRepository.findById(nominateToHousingId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+nominateToHousingId));
        nominateToHousing.setRequestStatus("REJECTED");
        NominateToHousing savedRequest=nominateToHousingRepository.save(nominateToHousing);
        return NominateToHousingMapper.mapToNominateToHousingDto(savedRequest);
    }
    //    delete nominate request
    @Override
    public void deleteNominateToHousing(Long nominateToHousingId) {
        NominateToHousing nominateToHousing=nominateToHousingRepository.findById(nominateToHousingId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+nominateToHousingId));
        nominateToHousingRepository.deleteById(nominateToHousingId);
    }
    //    get all nominate request
    @Override
    public List<NominateToHousingDto> getAllNominateToHousing() {
        List<NominateToHousing> nominateToHousings=nominateToHousingRepository.findAll();

        return nominateToHousings.stream()
                .map(NominateToHousingMapper::mapToNominateToHousingDto)
                .collect(Collectors.toList());
    }

}
