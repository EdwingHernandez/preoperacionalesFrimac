package com.frimac.preoperational.domain.services.Option;

import com.frimac.preoperational.domain.dto.OptionDTO;

import java.util.List;


public interface OptionService {
    List<OptionDTO> getOptionsByQuestion(Long questionId);
    OptionDTO createOption(OptionDTO optionDTO);
    void deleteOption(Long id);
}
