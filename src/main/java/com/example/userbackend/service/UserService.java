package com.example.userbackend.service;

import com.example.userbackend.dto.UserDto;
import com.example.userbackend.role.UserRole;

import java.util.List;

public interface UserService {
    UserDto addAdmin(UserDto userDto, UserRole userRole);
    UserDto addEmployee(UserDto userDto, UserRole userRole);
    UserDto getAdminById(Long userId);
    UserDto getEmployeeById(Long userId);
    UserDto updateAdmin(Long userId , UserDto updateAdminDto);
    UserDto updateEmployee(Long userId , UserDto updateAdminDto);
    void deleteAdmin(Long userId);
    void deleteEmployee(Long userId);
    List<UserDto> getAllAdmin();
    List<UserDto> getAllEmployee();
}
