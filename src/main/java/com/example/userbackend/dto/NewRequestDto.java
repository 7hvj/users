package com.example.userbackend.dto;

import com.example.userbackend.role.RequestStatus;
import com.example.userbackend.role.RequestType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewRequestDto {
    private Long newRequestId;

    private Long nationalId;
    private String nationalIdDate;
    private String nationalIdSource;
    private String country;
    private String city;
    private String neighborhood;
    private String phone;
}
