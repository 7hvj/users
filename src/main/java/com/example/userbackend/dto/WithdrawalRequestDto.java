package com.example.userbackend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalRequestDto {
    private Long withdrawalRequestId;

    private Long studentId;
    private String studentName;
    private String college;
    private String department;
    private String building;
    private String room;
    private String phone;
    private String withdrawalReason;
    private String iban;
    private String bankName;
    private String requestType;
    private String requestStatus;
}
