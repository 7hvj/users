package com.example.userbackend.mapper;

import com.example.userbackend.dto.WithdrawalRequestDto;
import com.example.userbackend.entity.WithdrawalRequest;

public class WithdrawalRequestMapper {
    public static WithdrawalRequestDto mapToWithdrawalRequestDto(WithdrawalRequest withdrawalRequest){
        return new WithdrawalRequestDto(
                withdrawalRequest.getWithdrawalRequestId(),
                withdrawalRequest.getStudentId(),
                withdrawalRequest.getStudentName(),
                withdrawalRequest.getCollege(),
                withdrawalRequest.getDepartment(),
                withdrawalRequest.getBuilding(),
                withdrawalRequest.getRoom(),
                withdrawalRequest.getPhone(),
                withdrawalRequest.getWithdrawalReason(),
                withdrawalRequest.getIban(),
                withdrawalRequest.getBankName(),
                withdrawalRequest.getRequestType(),
                withdrawalRequest.getRequestStatus()
        );
    }
    public static WithdrawalRequest mapToWithdrawalRequest(WithdrawalRequestDto withdrawalRequestDto){
        return new WithdrawalRequest(
                withdrawalRequestDto.getWithdrawalRequestId(),
                withdrawalRequestDto.getStudentId(),
                withdrawalRequestDto.getStudentName(),
                withdrawalRequestDto.getCollege(),
                withdrawalRequestDto.getDepartment(),
                withdrawalRequestDto.getBuilding(),
                withdrawalRequestDto.getRoom(),
                withdrawalRequestDto.getPhone(),
                withdrawalRequestDto.getWithdrawalReason(),
                withdrawalRequestDto.getIban(),
                withdrawalRequestDto.getBankName(),
                null,
                null
        );
    }
}
