package com.frimac.preoperational.domain.services.QuestionType;

import java.util.List;
import java.util.Optional;

import com.frimac.preoperational.persistence.entities.QuestionType;


public interface QuestionTypeService {

    List<QuestionType> findAll();
    Optional<QuestionType> findById(Long id);
    QuestionType save(QuestionType questionType);
    QuestionType update(Long id, QuestionType questionType);
    Optional<QuestionType> delete(Long id);     

}
