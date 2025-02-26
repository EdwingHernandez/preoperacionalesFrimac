package com.frimac.preoperational.domain.services.QuestionType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.frimac.preoperational.domain.dto.QuestionTypeDTO;
import com.frimac.preoperational.persistence.entities.QuestionType;
import com.frimac.preoperational.persistence.repositories.QuestionTypeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

    private final QuestionTypeRepository questionTypeRepository;

    public QuestionTypeServiceImpl(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public List<QuestionTypeDTO> findAll() {
        return questionTypeRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionTypeDTO> findById(Long id) {
        return questionTypeRepository.findById(id).map(this::toDTO);
    }

    @Override
    public QuestionTypeDTO save(QuestionTypeDTO questionTypeDTO) {
        QuestionType questionType = toEntity(questionTypeDTO);
        QuestionType newQuestionType = questionTypeRepository.save(questionType);
        return toDTO(newQuestionType);
    }

    @Override
    public QuestionTypeDTO update(Long id, QuestionTypeDTO questionTypeDTO) {
        QuestionType existingQuestionType = questionTypeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tipo de pregunta no encontrado con id " + id));

        if (questionTypeDTO.getName() != null) {
            existingQuestionType.setName(questionTypeDTO.getName());
        }

        QuestionType updatedQuestionType = questionTypeRepository.save(existingQuestionType);
        return toDTO(updatedQuestionType);
    }

    @Override
    public Boolean delete(Long id) {
        if (!questionTypeRepository.existsById(id)) {
            return false;
        }
        questionTypeRepository.deleteById(id);
        return true;
    }

    private QuestionTypeDTO toDTO(QuestionType questionType) {
        return new QuestionTypeDTO(questionType.getId(), questionType.getName());
    }

    private QuestionType toEntity(QuestionTypeDTO questionTypeDTO) {
        QuestionType questionType = new QuestionType(questionTypeDTO.getName());
        questionType.setId(questionTypeDTO.getId());
        return questionType;
    }
}

