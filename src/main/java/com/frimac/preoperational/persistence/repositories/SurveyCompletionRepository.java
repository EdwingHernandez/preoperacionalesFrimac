package com.frimac.preoperational.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frimac.preoperational.persistence.entities.SurveyCompletion;

@Repository
public interface SurveyCompletionRepository extends JpaRepository<SurveyCompletion, Long>{
    List<SurveyCompletion> findByUserId(String userId);
}
