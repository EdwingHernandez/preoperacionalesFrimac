package com.frimac.preoperational.domain.services.Position;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.PositionDTO;

public interface PositionService {

    List<PositionDTO> findAll();
    Optional<PositionDTO> findById(Long id);
    PositionDTO save(PositionDTO PositionDTO);
    PositionDTO update(Long id, PositionDTO positionDTO);
    Boolean delete(Long id); 
}
