package com.frimac.preoperational.domain.services.Role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.persistence.entities.Role;
import com.frimac.preoperational.persistence.repositories.RoleRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }  
    
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }    

    @Override
    public Role update(Long id, Role role) {
        if (!roleRepository.existsById(id)) {
            throw new EntityNotFoundException("Role no encontrada con id " + id);
        }
        role.setId(id); 
        return roleRepository.save(role);
    }    

    @Override
    @Transactional
    public Optional<Role> delete(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            roleRepository.deleteById(id);
        }
        return role;
    }


}
