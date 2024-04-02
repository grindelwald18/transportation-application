package com.example.upseh2.services;

import com.example.upseh2.entities.Delivery;
import com.example.upseh2.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {

    Page<Role> getAllRoles(Pageable pageable);

    Role addRole(Role role);
    void delRole(long id);

    Role updateRole(long id, Role updateRole);

    Role findById(long id);
}
