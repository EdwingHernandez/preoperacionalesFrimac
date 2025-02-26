package com.frimac.preoperational.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frimac.preoperational.persistence.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    boolean existsByName(String name);
}

