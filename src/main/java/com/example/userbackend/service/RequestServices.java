package com.example.userbackend.service;

import com.example.userbackend.dto.NewRequestDto;
import com.example.userbackend.dto.UserDto;
import com.example.userbackend.role.RequestStatus;
import com.example.userbackend.role.RequestType;

import java.util.List;

public interface RequestServices {
//    New Request functions:
    NewRequestDto addNewRequest(NewRequestDto newRequestDto);
    NewRequestDto getNewRequestById(Long newRequestId);
    NewRequestDto ApprovedStatus(Long newRequestId);
    NewRequestDto RejectedStatus(Long newRequestId);
    void deleteNewRequest(Long newRequestId);
    List<NewRequestDto> getAllNewRequest();
}
