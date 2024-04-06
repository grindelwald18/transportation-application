package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.RoleDTO;
import com.example.upseh2.entities.Delivery;
import com.example.upseh2.entities.Role;
import com.example.upseh2.mappers.RoleMapper;
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
    private final RoleMapper roleMapper;

    public Page<RoleDTO> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable)
                .map(roleMapper::toRoleDTO);
    }

    public RoleDTO addRole (Role role) {
        return roleMapper.toRoleDTO(roleRepository.save(role));
    }

    public void delRole(long id) {
        roleRepository.deleteById(id);
    }

    public RoleDTO updateRole(long id, Role newRole) {
        newRole.setId(id);
        return roleMapper.toRoleDTO(roleRepository.save(newRole));
    }

    public RoleDTO findById (long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toRoleDTO)
                .orElseThrow();
    }
}