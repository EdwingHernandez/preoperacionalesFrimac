package com.frimac.preoperational.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frimac.preoperational.persistence.entities.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long>{
    boolean existsByName(String name);
}
