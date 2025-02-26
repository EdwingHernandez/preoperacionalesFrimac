package com.frimac.preoperational.domain.services.SurveyAssignment;

import java.util.List;

import com.frimac.preoperational.domain.dto.SurveyAssignmentDTO;


public interface SurveyAssignmentService {
    SurveyAssignmentDTO createSurveyAssignment(SurveyAssignmentDTO surveyAssignmentDTO);
    SurveyAssignmentDTO getSurveyAssignmentById(Long id);
    List<SurveyAssignmentDTO> getAllSurveyAssignments();
    SurveyAssignmentDTO updateSurveyAssignment(Long id, SurveyAssignmentDTO surveyAssignmentDTO);
    void deleteSurveyAssignment(Long id);
    List<SurveyAssignmentDTO> getAssignmentsByUser(String userId);

}
