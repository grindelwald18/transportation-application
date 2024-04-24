package com.example.upseh2.mappers;

import com.example.upseh2.dtos.RoleDTO;
import com.example.upseh2.entities.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    Role toRole(RoleDTO roleDTO);

    RoleDTO toRoleDTO(Role role);
}