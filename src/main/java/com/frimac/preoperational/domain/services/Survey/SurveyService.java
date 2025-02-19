package com.frimac.preoperational.domain.services.Survey;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.Survey;


public interface SurveyService {

    List<Survey> findAll();
    Optional<Survey> findById(Long id);
    Survey save(Survey survey);
    Survey update(Long id, Survey survey);
    Optional<Survey> delete(Long id); 

}
