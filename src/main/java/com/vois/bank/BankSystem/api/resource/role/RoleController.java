package com.vois.bank.BankSystem.api.resource.role;

import com.vois.bank.BankSystem.service.RoleService;
import com.vois.bank.BankSystem.service.entity.Role;
import com.vois.bank.BankSystem.service.util.mapper.RoleMapper;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Manages operations on Role ")
@RestController
@RequestMapping(path = "/api/roles",  produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {

    private final RoleService roleService;
    public static RoleMapper roleMapper = RoleMapper.INSTANCE;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<?> getRoles(){
        List<Role> roles = roleService.getRoles();
        List<RoleDto> roleDtos = roleMapper.mapFromListOfRoleToListOfRoleDto(roles);
        return  new ResponseEntity<>(roleDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRole(@PathVariable("id") int id){
        Role role = roleService.getRoleById(id);
        RoleResponse roleResponse = roleMapper.roleToRoleResponse(role);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);

    }


}
