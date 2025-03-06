package com.frimac.preoperational.domain.services.Option;


import com.frimac.preoperational.domain.dto.OptionDTO;
import com.frimac.preoperational.persistence.entities.Option;
import com.frimac.preoperational.persistence.entities.Question;
import com.frimac.preoperational.persistence.repositories.OptionRepository;
import com.frimac.preoperational.persistence.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;
    private final QuestionRepository questionRepository;

    public OptionServiceImpl(OptionRepository optionRepository, QuestionRepository questionRepository) {
        this.optionRepository = optionRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<OptionDTO> getOptionsByQuestion(Long questionId) {
        List<Option> options = optionRepository.findByQuestion_Id(questionId);
        return options.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public OptionDTO createOption(OptionDTO optionDTO) {
        Question question = questionRepository.findById(optionDTO.getIdQuestion())
            .orElseThrow(() -> new RuntimeException("Question not found"));

        Option option = new Option(null, optionDTO.getText(), question);
        option = optionRepository.save(option);
        return convertToDTO(option);
    }

    @Override
    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }

    private OptionDTO convertToDTO(Option option) {
        return new OptionDTO(option.getId(), option.getText(), option.getQuestion().getId());
    }
}

