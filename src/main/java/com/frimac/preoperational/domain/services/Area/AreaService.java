package com.frimac.preoperational.domain.services.Area;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.AreaDTO;

public interface AreaService {

    List<AreaDTO> findAll();
    Optional<AreaDTO> findById(Long id);
    AreaDTO save(AreaDTO areaDTO);
    AreaDTO update(Long id, AreaDTO areaDTO);
    Boolean delete(Long id); 

}
