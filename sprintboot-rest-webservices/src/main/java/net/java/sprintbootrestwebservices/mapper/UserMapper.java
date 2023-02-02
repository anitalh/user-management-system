//package net.java.sprintbootrestwebservices.mapper;
//
//import net.java.sprintbootrestwebservices.dto.UserDto;
//import net.java.sprintbootrestwebservices.entity.User;
//
//public class UserMapper {
//
//    // Convert User JPA entity into UserDto
//    public static UserDto mapToUserDto(User user){
//        UserDto userDto = new UserDto(
//                user.getId(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getEmail()
//        );
//        return userDto;
//    }
//
//    // Covert UserDto into User JPA Entity
//    public static User mapToUser(UserDto userDto) {
//        User user = new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
//        return user;
//    }
//}
