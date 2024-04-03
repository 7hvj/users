package com.example.userbackend.service.implementaion;

import com.example.userbackend.dto.*;
import com.example.userbackend.entity.*;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.mapper.*;
import com.example.userbackend.repository.*;
import com.example.userbackend.service.RequestServices;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestServicesImpl implements RequestServices {
    private NewRequestRepository newRequestRepository;
    private RenewRequestRepository renewRequestRepository;
    private RepairRequestRepository repairRequestRepository;
    private WithdrawalRequestRepository withdrawalRequestRepository;
    private NominateToHousingRepository nominateToHousingRepository;
    private requestsRepository requestsRepository;

//    new request functions:
    @Override
    public NewRequestDto addNewRequest(NewRequestDto newRequestDto) {
        NewRequest newRequest= NewRequestMapper.mapToNewRequest(newRequestDto);
        Requests request=requestsRepository.save(new Requests("NEW_REQUEST","PENDING"));
        newRequest.setNewRequestId(request.getRequestsId());
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
        Requests newRequest=requestsRepository.findById(newRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+newRequestId));

        newRequest.setRequestStatus("APPROVED");
        Requests savedRequest=requestsRepository.save(newRequest);
        return null;
    }
    //    update the status of request into rejected
    @Override
    public NewRequestDto RejectedStatus(Long newRequestId) {
        Requests newRequest=requestsRepository.findById(newRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+newRequestId));

        newRequest.setRequestStatus("REJECTED");
        Requests savedRequest=requestsRepository.save(newRequest);
        return null;
    }
//    Delete New Request
    @Override
    public void deleteNewRequest(Long newRequestId) {
        Requests Request=requestsRepository.findById(newRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+newRequestId));

        newRequestRepository.deleteById(newRequestId);
        requestsRepository.deleteById(newRequestId);
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
        renewRequest.setTerm("FIRST_TERM");
        renewRequest.setAcademicYear("2023-2024");
        Requests request=requestsRepository.save(new Requests("RENEW_REQUEST","PENDING"));
        renewRequest.setRenewRequestId(request.getRequestsId());
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
        Requests renewRequest=requestsRepository.findById(renewRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+renewRequestId));

        renewRequest.setRequestStatus("APPROVED");
        Requests savedRequest=requestsRepository.save(renewRequest);
        return null;
    }
    // update renew request to rejected
    @Override
    public RenewRequestDto RejectedRenewRequest(Long renewRequestId) {
        Requests renewRequest=requestsRepository.findById(renewRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+renewRequestId));

        renewRequest.setRequestStatus("REJECTED");
        Requests savedRequest=requestsRepository.save(renewRequest);
        return null;
    }
    // delete renew request
    @Override
    public void deleteRenewRequest(Long renewRequestId) {
        Requests renewRequest=requestsRepository.findById(renewRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+renewRequestId));

        renewRequestRepository.deleteById(renewRequestId);
        requestsRepository.deleteById(renewRequestId);

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
        Requests repair=requestsRepository.save(new Requests("REPAIR_REQUEST","PENDING"));
        repairRequest.setRepairRequestId(repair.getRequestsId());
        RepairRequest savedRequest=repairRequestRepository.save(repairRequest);
        return RepairRequestMapper.mapToRepairRequestDto(savedRequest);

    }
//    get repair request by id
//
    @Override
    public RepairRequestDto getRepairRequestById(Long repairRequestId) {
        RepairRequest repairRequest=repairRequestRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));

        return RepairRequestMapper.mapToRepairRequestDto(repairRequest);
    }
    // update repair request to approved
    @Override
    public RepairRequestDto ApprovedRepairRequest(Long repairRequestId) {
        Requests repairRequest=requestsRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));

        repairRequest.setRequestStatus("APPROVED");
        Requests savedRequest=requestsRepository.save(repairRequest);
        return null;
    }
//    // update repair request to rejected
    @Override
    public RepairRequestDto RejectedRepairRequest(Long repairRequestId) {
        Requests repairRequest=requestsRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));

        repairRequest.setRequestStatus("REJECTED");
        Requests savedRequest=requestsRepository.save(repairRequest);
        return null;
    }
    // delete repair request
    @Override
    public void deleteRepairRequest(Long repairRequestId) {
        Requests Request=requestsRepository.findById(repairRequestId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+repairRequestId));

        repairRequestRepository.deleteById(repairRequestId);
        requestsRepository.deleteById(repairRequestId);
    }
    // get all repair request
    @Override
    public List<Map<String, Object >> getAllRepairRequest() {
        return repairRequestRepository.getRequests();
    }
// Withdrawal request functions:
    @Override
    public WithdrawalRequestDto addWithdrawalRequest(WithdrawalRequestDto withdrawalRequestDto) {
        WithdrawalRequest withdrawalRequest= WithdrawalRequestMapper.mapToWithdrawalRequest(withdrawalRequestDto);
        Requests withdrawal=requestsRepository.save(new Requests("WITHDRAWAL_REQUEST","PENDING"));
        withdrawalRequest.setWithdrawalRequestId(withdrawal.getRequestsId());
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
        Requests withdrawalRequest=requestsRepository.findById(withdrawalId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+withdrawalId));

        withdrawalRequest.setRequestStatus("APPROVED");
        Requests savedRequest=requestsRepository.save(withdrawalRequest);
        return null;
    }
//// reject: Withdrawal
    @Override
    public WithdrawalRequestDto RejectedWithdrawalRequestById(Long withdrawalId) {
        Requests withdrawalRequest=requestsRepository.findById(withdrawalId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+withdrawalId));

        withdrawalRequest.setRequestStatus("REJECTED");
        Requests savedRequest=requestsRepository.save(withdrawalRequest);
        return null;
    }
//delete Withdrawal
    @Override
    public void deleteWithdrawalRequest(Long withdrawalId) {
        Requests Request=requestsRepository.findById(withdrawalId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+withdrawalId));

        withdrawalRequestRepository.deleteById(withdrawalId);
        requestsRepository.deleteById(withdrawalId);
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
        Requests nominate=requestsRepository.save(new Requests("NOMINATE_REQUEST","PENDING"));
        nominateToHousing.setNominateToHousingId(nominate.getRequestsId());
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
        Requests nominateToHousing=requestsRepository.findById(nominateToHousingId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+nominateToHousingId));

        nominateToHousing.setRequestStatus("APPROVED");
        Requests savedRequest=requestsRepository.save(nominateToHousing);
        return null;

    }
    //    reject nominate request
    @Override
    public NominateToHousingDto RejectedNominateToHousing(Long nominateToHousingId) {
        Requests nominateToHousing=requestsRepository.findById(nominateToHousingId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+nominateToHousingId));

        nominateToHousing.setRequestStatus("REJECTED");
        Requests savedRequest=requestsRepository.save(nominateToHousing);
        return null;
    }
    //    delete nominate request
    @Override
    public void deleteNominateToHousing(Long nominateToHousingId) {
        Requests nominateToHousing=requestsRepository.findById(nominateToHousingId)
                .orElseThrow(()->new NotFoundException("Not Found id: "+nominateToHousingId));
        nominateToHousingRepository.deleteById(nominateToHousingId);
        requestsRepository.deleteById(nominateToHousingId);
    }
    //    get all nominate request
    @Override
    public List<NominateToHousingDto> getAllNominateToHousing() {
        List<NominateToHousing> nominateToHousings=nominateToHousingRepository.findAll();

        return nominateToHousings.stream()
                .map(NominateToHousingMapper::mapToNominateToHousingDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Requests> getAllRequests() {
        List<Requests> Requests =requestsRepository.findAll();
        return Requests;
    }


}
