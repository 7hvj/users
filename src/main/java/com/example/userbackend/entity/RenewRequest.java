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
@Table(name = "RenewRequest")
public class RenewRequest {
    @Id
    @Column(name = "renew_request_id")
    private Long renewRequestId;

    private Long studentId;
    private String studentName;
    private String college;
    private String renewDate;
    private String paymentReceipt;
    private String term;
    private String academicYear;

}
