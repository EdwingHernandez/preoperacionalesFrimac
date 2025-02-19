package com.frimac.preoperational.domain.services.SurveyAssignment;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.SurveyAssignment;


public interface SurveyAssignmentService {

    List<SurveyAssignment> findAll();
    Optional<SurveyAssignment> findById(Long id);
    SurveyAssignment save(SurveyAssignment surveyAssignment);
    SurveyAssignment update(Long id, SurveyAssignment surveyAssignment);
    Optional<SurveyAssignment> delete(Long id); 


}
