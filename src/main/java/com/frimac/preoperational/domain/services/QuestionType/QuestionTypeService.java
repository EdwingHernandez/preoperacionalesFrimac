package com.frimac.preoperational.domain.services.QuestionType;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.domain.dto.QuestionTypeDTO;


public interface QuestionTypeService {

    List<QuestionTypeDTO> findAll();
    Optional<QuestionTypeDTO> findById(Long id);
    QuestionTypeDTO save(QuestionTypeDTO questionTypeDTO);
    QuestionTypeDTO update(Long id, QuestionTypeDTO questionTypeDTO);
    Boolean delete(Long id);     

}
