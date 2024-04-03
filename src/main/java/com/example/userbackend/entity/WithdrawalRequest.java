package com.example.userbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WithdrawalRequest")
public class WithdrawalRequest {
    @Id
    @Column(name = "withdrawal_request_id")
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
//    step 2
//    @Column(name = "request_status")
//    private String requestStatus;

}
