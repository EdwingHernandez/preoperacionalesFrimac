package com.frimac.preoperational.domain.services.Question;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.QuestionDTO;
import com.frimac.preoperational.domain.dto.QuestionWithOptionsDTO;



public interface QuestionService {

    List<QuestionDTO> findAll();
    Optional<QuestionDTO> findById(Long id);
    QuestionDTO save(QuestionDTO questionDTO);
    QuestionDTO update(Long id, QuestionDTO questionDTO);
    Boolean delete(Long id); 
    QuestionWithOptionsDTO toQuestionWithOptionsDTO(QuestionDTO questionDTO);
    List<QuestionDTO> findBySurveyId(Long surveyId);
}
