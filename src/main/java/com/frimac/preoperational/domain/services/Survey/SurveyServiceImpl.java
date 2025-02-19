package com.frimac.preoperational.domain.services.Survey;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frimac.preoperational.persistence.entities.Survey;
import com.frimac.preoperational.persistence.repositories.SurveyRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public Optional<Survey> findById(Long id) {
        return surveyRepository.findById(id);
    }  
    
    @Override
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }    

    @Override
    public Survey update(Long id, Survey survey) {
        if (!surveyRepository.existsById(id)) {
            throw new EntityNotFoundException("Survey no encontrada con id " + id);
        }
        survey.setId(id); 
        return surveyRepository.save(survey);
    }    

    @Override
    @Transactional
    public Optional<Survey> delete(Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        if (survey.isPresent()) {
            surveyRepository.deleteById(id);
        }
        return survey;
    }


}