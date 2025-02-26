package com.frimac.preoperational.domain.services.Survey;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.SurveyDTO;


public interface SurveyService {

    List<SurveyDTO> findAll();
    Optional<SurveyDTO> findById(Long id);
    SurveyDTO save(SurveyDTO surveyDTO);
    SurveyDTO update(Long id, SurveyDTO surveyDTO);
    Boolean delete(Long id); 

}
