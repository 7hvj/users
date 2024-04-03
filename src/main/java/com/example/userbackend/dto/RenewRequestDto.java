package com.example.userbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RenewRequestDto {
    private Long renewRequestId;

    private Long studentId;
    private String studentName;
    private String college;
    private String renewDate;
    private String paymentReceipt;
    private String term;
    private String academicYear;

}
