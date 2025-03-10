package com.frimac.preoperational.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frimac.preoperational.persistence.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
    List<Question> findBySurveyId(Long surveyId);
}
