package com.example.movietickets.demo.service;


import com.example.movietickets.demo.Enum.Role;
import com.example.movietickets.demo.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;

    public void initializeRoles() {
        for (Role roleEnum : Role.values()) {
            if (!roleRepository.existsRoleByName(roleEnum.name())) {
                com.example.movietickets.demo.model.Role role = new com.example.movietickets.demo.model.Role();
                role.setName(roleEnum.name());
                roleRepository.save(role);
            }
        }
    }
}
