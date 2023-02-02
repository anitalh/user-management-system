package net.java.sprintbootrestwebservices.service;

import net.java.sprintbootrestwebservices.dto.UserDto;

import java.util.List;
public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    void deleteUser(Long userId);
}
