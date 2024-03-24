package com.example.userbackend.service.implementaion;

import com.example.userbackend.dto.NewRequestDto;
import com.example.userbackend.dto.UserDto;
import com.example.userbackend.entity.NewRequest;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.mapper.NewRequestMapper;
import com.example.userbackend.repository.NewRequestRepository;
import com.example.userbackend.service.RequestServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestServicesImpl implements RequestServices {
    private NewRequestRepository newRequestRepository;

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
}
