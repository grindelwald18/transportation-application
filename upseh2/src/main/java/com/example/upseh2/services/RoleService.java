package com.example.upseh2.services;

import com.example.upseh2.dtos.RoleDTO;
import com.example.upseh2.entities.Delivery;
import com.example.upseh2.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {

    Page<RoleDTO> getAllRoles(Pageable pageable);

    RoleDTO addRole(Role role);
    void delRole(long id);

    RoleDTO updateRole(long id, Role updateRole);

    RoleDTO findById(long id);
}
