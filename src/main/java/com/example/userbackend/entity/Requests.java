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
@Table(name = "Requests")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Requests_id")
    private Long RequestsId;

    @Column(name = "request_type")
    private String requestType;
    @Column(name = "request_status")
    private String requestStatus;
// step one
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "request_id",referencedColumnName = "repair_request_id")
//    private RepairRequest repairRequest;


    public Requests(String requestType, String requestStatus) {
        this.requestType = requestType;
        this.requestStatus = requestStatus;
    }


}
