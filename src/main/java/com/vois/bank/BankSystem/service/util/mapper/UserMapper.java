package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.user.UserDto;
import com.vois.bank.BankSystem.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = { AccountMapper.class, RoleMapper.class })
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToEntity(UserDto userDto);

    UserDto userToDto(User user);

    public default List<UserDto> mapFromListOfUserToListOfUserDto( List<User> users ) {
        return users.stream().map(this::userToDto).collect( Collectors.toList() );
    }

    public default List<User> mapFromListOfUserDtoToListOfUser( List<UserDto> userDtos ) {
        return userDtos.stream().map(this::userDtoToEntity).collect( Collectors.toList() );
    }

}
