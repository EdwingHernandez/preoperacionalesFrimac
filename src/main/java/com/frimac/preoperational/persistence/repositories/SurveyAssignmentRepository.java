package com.frimac.preoperational.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frimac.preoperational.persistence.entities.SurveyAssignment;
import com.frimac.preoperational.persistence.entities.User;

@Repository
public interface SurveyAssignmentRepository extends JpaRepository<SurveyAssignment, Long>{

    List<SurveyAssignment> findByUser(User user);

}
