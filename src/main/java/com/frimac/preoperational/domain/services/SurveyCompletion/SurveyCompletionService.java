package com.frimac.preoperational.domain.services.SurveyCompletion;

import java.util.List;

import com.frimac.preoperational.domain.dto.SurveyCompletionDTO;


public interface SurveyCompletionService {
    SurveyCompletionDTO createSurveyCompletion(SurveyCompletionDTO surveyCompletionDTO);
    SurveyCompletionDTO getSurveyCompletionById(Long id);
    List<SurveyCompletionDTO> getAllSurveyCompletions();
    SurveyCompletionDTO updateSurveyCompletion(Long id, SurveyCompletionDTO surveyCompletionDTO);
    void deleteSurveyCompletion(Long id);
    List<SurveyCompletionDTO> getSurveyCompletionsByUser(String userId);

}



