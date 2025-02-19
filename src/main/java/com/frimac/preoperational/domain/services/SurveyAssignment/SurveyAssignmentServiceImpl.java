package com.frimac.preoperational.domain.services.SurveyAssignment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.persistence.entities.SurveyAssignment;
import com.frimac.preoperational.persistence.repositories.SurveyAssignmentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SurveyAssignmentServiceImpl implements SurveyAssignmentService {

    @Autowired
    private SurveyAssignmentRepository surveyAssignmentRepository;

    public SurveyAssignmentServiceImpl(SurveyAssignmentRepository surveyAssignmentRepository) {
        this.surveyAssignmentRepository = surveyAssignmentRepository;
    }

    @Override
    public List<SurveyAssignment> findAll() {
        return surveyAssignmentRepository.findAll();
    }

    @Override
    public Optional<SurveyAssignment> findById(Long id) {
        return surveyAssignmentRepository.findById(id);
    }  
    
    @Override
    public SurveyAssignment save(SurveyAssignment surveyAssignment) {
        return surveyAssignmentRepository.save(surveyAssignment);
    }    

    @Override
    public SurveyAssignment update(Long id, SurveyAssignment surveyAssignment) {
        if (!surveyAssignmentRepository.existsById(id)) {
            throw new EntityNotFoundException("SurveyAssignment no encontrada con id " + id);
        }
        surveyAssignment.setId(id); 
        return surveyAssignmentRepository.save(surveyAssignment);
    }    

    @Override
    @Transactional
    public Optional<SurveyAssignment> delete(Long id) {
        Optional<SurveyAssignment> surveyAssignment = surveyAssignmentRepository.findById(id);
        if (surveyAssignment.isPresent()) {
            surveyAssignmentRepository.deleteById(id);
        }
        return surveyAssignment;
    }


}
