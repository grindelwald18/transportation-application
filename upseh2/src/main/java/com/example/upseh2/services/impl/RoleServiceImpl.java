package com.example.upseh2.services.impl;

import com.example.upseh2.entities.Delivery;
import com.example.upseh2.entities.Role;
import com.example.upseh2.repositories.RoleRepository;
import com.example.upseh2.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final  RoleRepository roleRepository;

    public Page<Role> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    public Role addRole (Role role) {
        return roleRepository.save(role);
    }

    public void delRole(long id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(long id, Role newRole) {
        newRole.setId(id);
        return  roleRepository.save(newRole);
    }

    public Role findById (long id) {
        return roleRepository.findById(id).orElseThrow();
    }
}