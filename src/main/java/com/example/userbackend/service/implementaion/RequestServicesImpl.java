package com.example.userbackend.service.implementaion;

import com.example.userbackend.dto.NewRequestDto;
import com.example.userbackend.dto.RenewRequestDto;
import com.example.userbackend.dto.RepairRequestDto;
import com.example.userbackend.dto.UserDto;
import com.example.userbackend.entity.NewRequest;
import com.example.userbackend.entity.RenewRequest;
import com.example.userbackend.entity.RepairRequest;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.mapper.NewRequestMapper;
import com.example.userbackend.mapper.RenewRequestMapper;
import com.example.userbackend.mapper.RepairRequestMapper;
import com.example.userbackend.mapper.UserMapper;
import com.example.userbackend.repository.NewRequestRepository;
import com.example.userbackend.repository.RenewRequestRepository;
import com.example.userbackend.repository.RepairRequestRepository;
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
}
