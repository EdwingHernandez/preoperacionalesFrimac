package com.frimac.preoperational.domain.services.Area;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.AreaDTO;
import com.frimac.preoperational.persistence.entities.Area;
import com.frimac.preoperational.persistence.repositories.AreaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public List<AreaDTO> findAll() {
        return areaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AreaDTO> findById(Long id) {
        Optional<Area> area = areaRepository.findById(id);
        return area.map(this::toDTO);
    }  
    
    @Override
    public AreaDTO save(Area area) {
        Area newAreaDTO = areaRepository.save(area);
        return toDTO(newAreaDTO);
    }    

    @Override
    public Area update(Long id, Area area) {
        if (!areaRepository.existsById(id)) {
            throw new EntityNotFoundException("Area no encontrada con id " + id);
        }
        area.setId(id); 
        return areaRepository.save(area);
    }    

    @Override
    @Transactional
    public Optional<Area> delete(Long id) {
        Optional<Area> area = areaRepository.findById(id);
        if (area.isPresent()) {
            areaRepository.deleteById(id);
        }
        return area;
    }

    private AreaDTO toDTO(Area area){
        return new AreaDTO(area.getId(), area.getName());
    }


}
