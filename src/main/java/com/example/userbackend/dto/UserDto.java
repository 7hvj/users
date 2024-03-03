package com.example.userbackend.dto;

import com.example.userbackend.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    //    this variable used for PostMan
    private String firstName;
    private String lastName;
    private String email;
    private UserRole userRole;
}
