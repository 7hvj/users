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
public class RepairRequestDto {
    private Long repairRequestId;

    private Long studentId;
    private String building;
    private String room;
    private String repair;
    private String description;
    private String requestType;
    private String requestStatus;
}
