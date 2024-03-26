package com.example.userbackend.mapper;

import com.example.userbackend.dto.NominateToHousingDto;
import com.example.userbackend.entity.NominateToHousing;

public class NominateToHousingMapper {
    public static NominateToHousingDto mapToNominateToHousingDto(NominateToHousing nominateToHousing){
        return new NominateToHousingDto(
                nominateToHousing.getNominateToHousingId(),
                nominateToHousing.getNationalId(),
                nominateToHousing.getName(),
                nominateToHousing.getCity(),
                nominateToHousing.getNationalAddress(),
                nominateToHousing.getSchoolName(),
                nominateToHousing.getNeighborhood(),
                nominateToHousing.getGraduationCity(),
                nominateToHousing.getPhone(),
                nominateToHousing.getRequestType(),
                nominateToHousing.getRequestStatus()
        );
    }
    public static NominateToHousing mapToNominateToHousing(NominateToHousingDto nominateToHousingDto){
        return new NominateToHousing(
                nominateToHousingDto.getNominateToHousingId(),
                nominateToHousingDto.getNationalId(),
                nominateToHousingDto.getName(),
                nominateToHousingDto.getCity(),
                nominateToHousingDto.getNationalAddress(),
                nominateToHousingDto.getSchoolName(),
                nominateToHousingDto.getNeighborhood(),
                nominateToHousingDto.getGraduationCity(),
                nominateToHousingDto.getPhone(),
                null,
                null
        );
    }
}
