package com.example.userbackend.mapper;

import com.example.userbackend.dto.NewRequestDto;
import com.example.userbackend.entity.NewRequest;

public class NewRequestMapper {
    public static NewRequestDto mapToNewRequestDto(NewRequest newRequest){
        return new NewRequestDto(
                newRequest.getNewRequestId(),
                newRequest.getNationalId(),
                newRequest.getNationalIdDate(),
                newRequest.getNationalIdSource(),
                newRequest.getCountry(),
                newRequest.getCity(),
                newRequest.getNeighborhood(),
                newRequest.getPhone(),
                newRequest.getRequestType(),
                newRequest.getRequestStatus()
        );
    }

    public static NewRequest mapToNewRequest(NewRequestDto newRequestDto){
        return new NewRequest(
                newRequestDto.getNewRequestId(),
                newRequestDto.getNationalId(),
                newRequestDto.getNationalIdDate(),
                newRequestDto.getNationalIdSource(),
                newRequestDto.getCountry(),
                newRequestDto.getCity(),
                newRequestDto.getNeighborhood(),
                newRequestDto.getPhone(),
                null,
                null
        );
    }
}
