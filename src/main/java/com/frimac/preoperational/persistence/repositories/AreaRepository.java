package com.frimac.preoperational.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frimac.preoperational.persistence.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {


}
