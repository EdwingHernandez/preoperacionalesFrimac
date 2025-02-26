package com.frimac.preoperational.domain.services.Question;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.QuestionDTO;



public interface QuestionService {

    List<QuestionDTO> findAll();
    Optional<QuestionDTO> findById(Long id);
    QuestionDTO save(QuestionDTO questionDTO);
    QuestionDTO update(Long id, QuestionDTO questionDTO);
    Boolean delete(Long id); 
}
