package net.java.sprintbootrestwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.java.sprintbootrestwebservices.dto.UserDto;
import net.java.sprintbootrestwebservices.entity.User;
import net.java.sprintbootrestwebservices.exception.EmailAlreadyExistsException;
import net.java.sprintbootrestwebservices.exception.ResourceNotFound;
import net.java.sprintbootrestwebservices.mapper.AutoUserMapper;
import net.java.sprintbootrestwebservices.repository.UserRepository;
import net.java.sprintbootrestwebservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
         return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user =  userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFound("User", "id", userId)
        );
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFound("User", "id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFound("User", "id", userId)
        );
        userRepository.deleteById(userId);
    }
}
