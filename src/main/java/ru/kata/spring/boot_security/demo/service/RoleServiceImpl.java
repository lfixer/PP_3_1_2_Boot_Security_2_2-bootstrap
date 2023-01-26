package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleOfId(Long id) {
        return roleRepository.findById(id).get();
    }


    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<Role> getUniqAllRoles() {
        return roleRepository.findAll();
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

}
