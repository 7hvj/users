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
public class NominateToHousingDto {
    private Long nominateToHousingId;

    private Long nationalId;
    private String Name;
    private String city;
    private String nationalAddress;
    private String schoolName;
    private String neighborhood;
    private String graduationCity;
    private String phone;
    private String requestType;
    private String requestStatus;
}
