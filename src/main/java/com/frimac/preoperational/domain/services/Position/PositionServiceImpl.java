package com.frimac.preoperational.domain.services.Position;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frimac.preoperational.persistence.entities.Position;
import com.frimac.preoperational.persistence.repositories.PositionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }  
    
    @Override
    public Position save(Position position) {
        return positionRepository.save(position);
    }    

    @Override
    public Position update(Long id, Position position) {
        if (!positionRepository.existsById(id)) {
            throw new EntityNotFoundException("Position no encontrada con id " + id);
        }
        position.setId(id); 
        return positionRepository.save(position);
    }    

    @Override
    @Transactional
    public Optional<Position> delete(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        if (position.isPresent()) {
            positionRepository.deleteById(id);
        }
        return position;
    }



}