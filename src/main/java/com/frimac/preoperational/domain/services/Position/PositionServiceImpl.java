package com.frimac.preoperational.domain.services.Position;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.PositionDTO;
import com.frimac.preoperational.persistence.entities.Position;
import com.frimac.preoperational.persistence.repositories.PositionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionDTO> findAll() {
        return positionRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PositionDTO> findById(Long id) {
        return positionRepository.findById(id).map(this::toDTO);
    }  

    @Override
    public PositionDTO save(PositionDTO positionDTO) {
        Position position = toEntity(positionDTO);
        Position newPosition = positionRepository.save(position);
        return toDTO(newPosition);
    }    

    @Override
    public PositionDTO update(Long id, PositionDTO positionDTO) {
        Position existingPosition = positionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Position no encontrada con id " + id));

        if (positionDTO.getName() != null) {
            existingPosition.setName(positionDTO.getName());
        }
        Position savedPosition = positionRepository.save(existingPosition);

        return toDTO(savedPosition);
    } 

    @Override
    public Boolean delete(Long id) {
        if (!positionRepository.existsById(id)) {
            return false;
        }
        positionRepository.deleteById(id);
        return true;
    }

    private PositionDTO toDTO(Position position) {
        return new PositionDTO(position.getId(), position.getName());
    }

    private Position toEntity(PositionDTO positionDTO) {
        Position position = new Position(positionDTO.getName());
        position.setId(positionDTO.getId());
        return position;
    }
}
