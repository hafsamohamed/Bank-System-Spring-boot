package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.role.RoleDto;
import com.vois.bank.BankSystem.api.resource.role.RoleRequest;
import com.vois.bank.BankSystem.api.resource.role.RoleResponse;
import com.vois.bank.BankSystem.service.entity.Role;
import com.vois.bank.BankSystem.service.enums.ERole;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T03:36:57+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role roleDtoToEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        if ( roleDto.getName() != null ) {
            role.setName( Enum.valueOf( ERole.class, roleDto.getName() ) );
        }

        return role;
    }

    @Override
    public RoleDto roleToDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        if ( role.getName() != null ) {
            roleDto.setName( role.getName().name() );
        }

        return roleDto;
    }

    @Override
    public RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId( role.getId() );
        roleResponse.setName( role.getName() );

        return roleResponse;
    }

    @Override
    public Role roleRequestToEntity(RoleRequest roleRequest) {
        if ( roleRequest == null ) {
            return null;
        }

        Role role = new Role();

        if ( roleRequest.getName() != null ) {
            role.setName( Enum.valueOf( ERole.class, roleRequest.getName() ) );
        }

        return role;
    }
}
