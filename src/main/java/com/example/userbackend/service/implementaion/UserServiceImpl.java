package com.example.userbackend.service.implementaion;

import com.example.userbackend.dto.UserDto;
import com.example.userbackend.entity.User;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.mapper.UserMapper;
import com.example.userbackend.repository.UserRepository;
import com.example.userbackend.role.UserRole;
import com.example.userbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDto addAdmin(UserDto userDto, UserRole userRole) {
        User user= UserMapper.mapToUser(userDto);
        user.setUserRole(userRole);
        User savedAdmin=userRepository.save(user);
        return UserMapper.mapToUserDto(savedAdmin);
    }

    @Override
    public UserDto addEmployee(UserDto userDto, UserRole userRole) {
        User user= UserMapper.mapToUser(userDto);
        user.setUserRole(userRole);
        User savedEmployee=userRepository.save(user);
        return UserMapper.mapToUserDto(savedEmployee);
    }

    @Override
    public UserDto getAdminById(Long userId) {
        User admin=userRepository.findById(userId)
                .filter(user -> user.getUserRole() == UserRole.ROLE_ADMIN)
                .orElseThrow(()->new NotFoundException("Not Found id: "+userId));
        return UserMapper.mapToUserDto(admin);
    }

    @Override
    public UserDto getEmployeeById(Long userId) {
        User employee=userRepository.findById(userId)
                .filter(user -> user.getUserRole() == UserRole.ROLE_EMPLOYEE)
                .orElseThrow(()->new NotFoundException("Not Found id: "+userId));
        return UserMapper.mapToUserDto(employee);
    }

    @Override
    public UserDto updateAdmin(Long userId, UserDto updateAdminDto) {
        User admin=userRepository.findById(userId)
                .filter(user -> user.getUserRole() == UserRole.ROLE_ADMIN)
                .orElseThrow(()->new NotFoundException("Not Found id: "+userId));
        admin.setFirstName(updateAdminDto.getFirstName());
        admin.setLastName(updateAdminDto.getLastName());
        admin.setEmail(updateAdminDto.getEmail());
        User updatedAdmin=userRepository.save(admin);

        return UserMapper.mapToUserDto(updatedAdmin);
    }

    @Override
    public UserDto updateEmployee(Long userId, UserDto updateAdminDto) {
        User employee=userRepository.findById(userId)
                .filter(user -> user.getUserRole() == UserRole.ROLE_EMPLOYEE)
                .orElseThrow(()->new NotFoundException("Not Found id: "+userId));
        employee.setFirstName(updateAdminDto.getFirstName());
        employee.setLastName(updateAdminDto.getLastName());
        employee.setEmail(updateAdminDto.getEmail());
        User updatedEmployee=userRepository.save(employee);

        return UserMapper.mapToUserDto(updatedEmployee);
    }

    @Override
    public void deleteAdmin(Long userId) {
        User admin=userRepository.findById(userId)
                .filter(user -> user.getUserRole() == UserRole.ROLE_ADMIN)
                .orElseThrow(()->new NotFoundException("Not Found id: "+userId));
        userRepository.deleteById(userId);

    }

    @Override
    public void deleteEmployee(Long userId) {
        User employee=userRepository.findById(userId)
                .filter(user -> user.getUserRole() == UserRole.ROLE_EMPLOYEE)
                .orElseThrow(()->new NotFoundException("Not Found id: "+userId));
        userRepository.deleteById(userId);

    }

    @Override
    public List<UserDto> getAllAdmin() {
        List<User> admins=userRepository.findAll();
        return admins.stream()
                .filter(user -> user.getUserRole() == UserRole.ROLE_ADMIN)
                .map((user)->UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getAllEmployee() {
        List<User> employees=userRepository.findAll();
        return employees.stream()
                .filter(user -> user.getUserRole() == UserRole.ROLE_EMPLOYEE)
                .map((user)->UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

}
