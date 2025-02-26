package com.frimac.preoperational.domain.services.Role;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.RoleDTO;
import com.frimac.preoperational.persistence.entities.Role;
import com.frimac.preoperational.persistence.repositories.RoleRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleDTO> findById(Long id) {
        return roleRepository.findById(id).map(this::toDTO);
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        if (roleRepository.existsByName(roleDTO.getName())) {
            throw new EntityExistsException("El rol '" + roleDTO.getName() + "' ya existe.");
        }

        Role role = new Role(roleDTO.getName());
        Role savedRole = roleRepository.save(role);
        return toDTO(savedRole);
    }

    @Override
    public RoleDTO update(Long id, RoleDTO roleDTO) {
        Role existingRole = roleRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado con id " + id));

        if (roleDTO.getName() != null) {
            if (roleRepository.existsByName(roleDTO.getName()) && !existingRole.getName().equals(roleDTO.getName())) {
                throw new EntityExistsException("El rol '" + roleDTO.getName() + "' ya existe.");
            }
            existingRole.setName(roleDTO.getName());
        }

        Role updatedRole = roleRepository.save(existingRole);
        return toDTO(updatedRole);
    }

    @Override
    public Boolean delete(Long id) {
        if (!roleRepository.existsById(id)) {
            return false;
        }
        roleRepository.deleteById(id);
        return true;
    }

    private RoleDTO toDTO(Role role) {
        return new RoleDTO(role.getId(), role.getName());
    }
}

