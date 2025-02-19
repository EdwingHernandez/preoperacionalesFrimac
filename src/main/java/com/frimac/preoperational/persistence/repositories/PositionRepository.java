package com.frimac.preoperational.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frimac.preoperational.persistence.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{

}
