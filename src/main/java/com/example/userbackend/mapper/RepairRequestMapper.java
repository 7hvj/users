package com.example.userbackend.mapper;

import com.example.userbackend.dto.RepairRequestDto;
import com.example.userbackend.entity.RepairRequest;

public class RepairRequestMapper {
    public static RepairRequestDto mapToRepairRequestDto(RepairRequest repairRequest){
        return new RepairRequestDto(
                repairRequest.getRepairRequestId(),
                repairRequest.getStudentId(),
                repairRequest.getBuilding(),
                repairRequest.getRoom(),
                repairRequest.getRepair(),
                repairRequest.getDescription()
        );
    }

    public static RepairRequest mapToRepairRequest(RepairRequestDto repairRequestDto){
        return new RepairRequest(
                repairRequestDto.getRepairRequestId(),
                repairRequestDto.getStudentId(),
                repairRequestDto.getBuilding(),
                repairRequestDto.getRoom(),
                repairRequestDto.getRepair(),
                repairRequestDto.getDescription()
        );

    }
}
