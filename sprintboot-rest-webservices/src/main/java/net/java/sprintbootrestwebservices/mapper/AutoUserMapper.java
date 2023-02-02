package net.java.sprintbootrestwebservices.mapper;

import net.java.sprintbootrestwebservices.dto.UserDto;
import net.java.sprintbootrestwebservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
