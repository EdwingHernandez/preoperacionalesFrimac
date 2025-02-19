package com.frimac.preoperational.domain.services.SurveyCompletion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frimac.preoperational.persistence.entities.SurveyCompletion;
import com.frimac.preoperational.persistence.repositories.SurveyCompletionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SurveyCompletionServiceImpl implements SurveyCompletionService {

    @Autowired
    private SurveyCompletionRepository surveyCompletionRepository;

    public SurveyCompletionServiceImpl(SurveyCompletionRepository surveyCompletionRepository) {
        this.surveyCompletionRepository = surveyCompletionRepository;
    }

    @Override
    public List<SurveyCompletion> findAll() {
        return surveyCompletionRepository.findAll();
    }

    @Override
    public Optional<SurveyCompletion> findById(Long id) {
        return surveyCompletionRepository.findById(id);
    }  
    
    @Override
    public SurveyCompletion save(SurveyCompletion surveyCompletion) {
        return surveyCompletionRepository.save(surveyCompletion);
    }    

    @Override
    public SurveyCompletion update(Long id, SurveyCompletion surveyCompletion) {
        if (!surveyCompletionRepository.existsById(id)) {
            throw new EntityNotFoundException("SurveyCompletion no encontrada con id " + id);
        }
        surveyCompletion.setId(id); 
        return surveyCompletionRepository.save(surveyCompletion);
    }    

    @Override
    @Transactional
    public Optional<SurveyCompletion> delete(Long id) {
        Optional<SurveyCompletion> surveyCompletion = surveyCompletionRepository.findById(id);
        if (surveyCompletion.isPresent()) {
            surveyCompletionRepository.deleteById(id);
        }
        return surveyCompletion;
    }


}
