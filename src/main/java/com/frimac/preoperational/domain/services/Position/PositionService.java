package com.frimac.preoperational.domain.services.Position;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.Position;

public interface PositionService {

    List<Position> findAll();
    Optional<Position> findById(Long id);
    Position save(Position position);
    Position update(Long id, Position position);
    Optional<Position> delete(Long id); 
}
