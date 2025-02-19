package com.frimac.preoperational.domain.services.SurveyCompletion;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.SurveyCompletion;


public interface SurveyCompletionService {

    List<SurveyCompletion> findAll();
    Optional<SurveyCompletion> findById(Long id);
    SurveyCompletion save(SurveyCompletion surveyCompletion);
    SurveyCompletion update(Long id, SurveyCompletion surveyCompletion);
    Optional<SurveyCompletion> delete(Long id); 

}
