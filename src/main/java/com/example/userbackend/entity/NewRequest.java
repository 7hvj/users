package com.example.userbackend.entity;

import com.example.userbackend.role.RequestStatus;
import com.example.userbackend.role.RequestType;
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
@Table(name = "NewRequest")
public class NewRequest {
    @Id
    @Column(name = "new_request_id")
    private Long newRequestId;

    private Long nationalId;
    private String nationalIdDate;
    private String nationalIdSource;
    private String country;
    private String city;
    private String neighborhood;
    private String phone;


}
