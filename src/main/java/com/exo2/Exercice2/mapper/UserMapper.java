package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.UserDto;
import com.exo2.Exercice2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = UserMapper.class)
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtos(List<User> users);

    List<User> toEntities(List<UserDto> usersDto);
}
