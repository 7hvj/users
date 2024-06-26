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
@Table(name = "NominateToHousing")
public class NominateToHousing {
    @Id
    @Column(name = "NominateToHousing_id")
    private Long nominateToHousingId;

    private Long nationalId;
    private String Name;
    private String city;
    private String nationalAddress;
    private String schoolName;
    private String neighborhood;
    private String graduationCity;
    private String phone;
}
