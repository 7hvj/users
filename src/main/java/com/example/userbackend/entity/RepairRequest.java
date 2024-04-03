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
@Table(name = "RepairRequest")
public class RepairRequest {
    @Id
    @Column(name = "repair_request_id")
    private Long repairRequestId;

    private Long studentId;
    private String building;
    private String room;
    private String repair;
    private String description;


}
