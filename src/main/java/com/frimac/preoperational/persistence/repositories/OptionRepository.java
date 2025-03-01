package com.frimac.preoperational.persistence.repositories;

import com.frimac.preoperational.persistence.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestion_Id(Long questionId);
}

