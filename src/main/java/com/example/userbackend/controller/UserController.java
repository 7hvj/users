package com.example.userbackend.controller;

import com.example.userbackend.dto.UserDto;
import com.example.userbackend.role.UserRole;
import com.example.userbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

//    add admin
@PostMapping("/addAdmin")
    public ResponseEntity<UserDto> addAdmin(@RequestBody UserDto userDto, @RequestParam(name = "userRole", defaultValue = "ROLE_ADMIN") UserRole userRole){
        UserDto savedAdmin=userService.addAdmin(userDto,userRole);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);

    }
//  add employee
    @PostMapping("/addEmployee")
    public ResponseEntity<UserDto> addEmployee(@RequestBody UserDto userDto, @RequestParam(name = "userRole", defaultValue = "ROLE_EMPLOYEE") UserRole userRole){
        UserDto savedEmployee=userService.addEmployee(userDto,userRole);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }
//  get admin by id
    @GetMapping("/admin/{id}")
    public ResponseEntity<UserDto> getAdmin(@PathVariable("id") Long adminId){
    UserDto userDto=userService.getAdminById(adminId);
    return ResponseEntity.ok(userDto);
    }

//    get employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<UserDto> getEmployee(@PathVariable("id")Long employeeId){
    UserDto userDto=userService.getEmployeeById(employeeId);
    return ResponseEntity.ok(userDto);
    }

//    edit Admin
    @PutMapping("/admin/{id}")
    public ResponseEntity<UserDto> updateAdminObj(@PathVariable("id") Long adminId ,@RequestBody UserDto updateAdminDto){
        UserDto userDto=userService.updateAdmin(adminId,updateAdminDto);
        return ResponseEntity.ok(userDto);
    }
//    edit Employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<UserDto> updateEmployee(@PathVariable("id") Long employeeId ,@RequestBody UserDto updateEmployeeDto){
        UserDto userDto=userService.updateEmployee(employeeId,updateEmployeeDto);
        return ResponseEntity.ok(userDto);
    }
//    delete admin
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long adminId){
    userService.deleteAdmin(adminId);
        return ResponseEntity.ok("Admin Deleted Successfully ");

    }
    //    delete Employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        userService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully ");

    }
//    Get All Admins
    @GetMapping("/admins")
    public ResponseEntity<List<UserDto>> getAllAdmins(){
    List<UserDto> admins=userService.getAllAdmin();
    return ResponseEntity.ok(admins);
    }
//    Get All Employees
    @GetMapping("/employees")
    public ResponseEntity<List<UserDto>> getAllEmployees(){
    List<UserDto> employees=userService.getAllEmployee();
    return ResponseEntity.ok(employees);
    }
}
