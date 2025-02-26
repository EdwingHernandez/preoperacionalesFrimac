package com.frimac.preoperational.domain.services.Role;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.RoleDTO;


public interface RoleService {

    List<RoleDTO> findAll();
    Optional<RoleDTO> findById(Long id);
    RoleDTO save(RoleDTO roleDTO);
    RoleDTO update(Long id, RoleDTO roleDTO);
    Boolean delete(Long id); 

}
