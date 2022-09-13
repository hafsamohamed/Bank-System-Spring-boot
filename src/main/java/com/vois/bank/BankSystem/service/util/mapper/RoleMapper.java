package com.vois.bank.BankSystem.service.util.mapper;

import com.vois.bank.BankSystem.api.resource.account.AccountDto;
import com.vois.bank.BankSystem.api.resource.role.RoleDto;
import com.vois.bank.BankSystem.api.resource.role.RoleRequest;
import com.vois.bank.BankSystem.api.resource.role.RoleResponse;
import com.vois.bank.BankSystem.service.entity.Account;
import com.vois.bank.BankSystem.service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleDtoToEntity(RoleDto roleDto);

    RoleDto roleToDto(Role role);
    RoleResponse roleToRoleResponse(Role role);

    Role roleRequestToEntity(RoleRequest roleRequest);

    public default List<RoleDto> mapFromListOfRoleToListOfRoleDto(List<Role> roles ) {
        return roles.stream().map(this::roleToDto).collect( Collectors.toList() );
    }

    public default List<Role> mapFromListOfRoleDtoToListOfRole( List<RoleDto> roleDtos ) {
        return roleDtos.stream().map(this::roleDtoToEntity).collect( Collectors.toList() );
    }
}
