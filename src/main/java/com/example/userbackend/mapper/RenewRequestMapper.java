package com.example.userbackend.mapper;

import com.example.userbackend.dto.RenewRequestDto;
import com.example.userbackend.entity.RenewRequest;

public class RenewRequestMapper {
    public static RenewRequestDto mapToRenewRequestDto(RenewRequest renewRequest){
        return new RenewRequestDto(
                renewRequest.getRenewRequestId(),
                renewRequest.getStudentId(),
                renewRequest.getStudentName(),
                renewRequest.getCollege(),
                renewRequest.getRenewDate(),
                renewRequest.getPaymentReceipt(),
                renewRequest.getTerm(),
                renewRequest.getAcademicYear()
        );
    }
    public static RenewRequest mapToRenewRequest(RenewRequestDto renewRequestDto){
        return new RenewRequest(
                renewRequestDto.getRenewRequestId(),
                renewRequestDto.getStudentId(),
                renewRequestDto.getStudentName(),
                renewRequestDto.getCollege(),
                renewRequestDto.getRenewDate(),
                renewRequestDto.getPaymentReceipt(),
                null,
                null
        );
    }
}
