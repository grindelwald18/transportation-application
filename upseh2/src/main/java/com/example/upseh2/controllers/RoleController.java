package com.example.upseh2.controllers;

import com.example.upseh2.dtos.RoleDTO;
import com.example.upseh2.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<RoleDTO> getAllRoles(Pageable pageable){
        return roleService.getAllRoles(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO getRoleById(@PathVariable long id){
        return roleService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO addRole(@RequestBody RoleDTO RoleDTO) {
        return roleService.addRole(RoleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delRole(@PathVariable long id) {
        roleService.delRole(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO updateRole(@PathVariable long id, @RequestBody RoleDTO RoleDTO) {
        return roleService.updateRole(id, RoleDTO);
    }
}
