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

    private final AreaRepository areaRepository;

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
        return areaRepository.findById(id).map(this::toDTO);
    }  

    @Override
    public AreaDTO save(AreaDTO areaDTO) {
        Area area = toEntity(areaDTO);
        Area newArea = areaRepository.save(area);
        return toDTO(newArea);
    }    

    @Override
    public AreaDTO update(Long id, AreaDTO areaDTO) {
        Area existingArea = areaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Área no encontrada con id " + id));

        if (areaDTO.getName() != null) {
            existingArea.setName(areaDTO.getName());
        }
        Area savedArea = areaRepository.save(existingArea);

        return toDTO(savedArea);
    } 

    @Override
    public Boolean delete(Long id) {
        if (!areaRepository.existsById(id)) {
            return false;
        }
        areaRepository.deleteById(id);
        return true;
    }

    private AreaDTO toDTO(Area area) {
        return new AreaDTO(area.getId(), area.getName());
    }

    private Area toEntity(AreaDTO areaDTO) {
        Area area = new Area();
        area.setId(areaDTO.getId()); 
        area.setName(areaDTO.getName());
        return area;
    }
}


