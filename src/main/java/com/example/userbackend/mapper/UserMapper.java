package com.example.userbackend.mapper;

import com.example.userbackend.dto.UserDto;
import com.example.userbackend.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserRole()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getUserRole()
        );
    }
}
