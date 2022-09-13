package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.user.UserDto;
import com.vois.bank.BankSystem.service.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T03:36:57+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserName( userDto.getUserName() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public UserDto userToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserName( user.getUserName() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }
}
