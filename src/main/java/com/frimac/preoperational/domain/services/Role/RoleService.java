package com.frimac.preoperational.domain.services.Role;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.Role;


public interface RoleService {

    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    Role update(Long id, Role role);
    Optional<Role> delete(Long id); 

}
