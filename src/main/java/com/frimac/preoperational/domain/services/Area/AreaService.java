package com.frimac.preoperational.domain.services.Area;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.AreaDTO;
import com.frimac.preoperational.persistence.entities.Area;

public interface AreaService {

    List<AreaDTO> findAll();
    Optional<AreaDTO> findById(Long id);
    AreaDTO save(Area area);
    Area update(Long id, Area area);
    Optional<Area> delete(Long id); 

}
