package com.frimac.preoperational.domain.dto;

import java.util.List;

public class QuestionWithOptionsDTO extends QuestionDTO {
    private List<OptionDTO> optionsDTO;

    public QuestionWithOptionsDTO() {}

    public QuestionWithOptionsDTO(Long id, String question, Long idSurvey, Long idQuestiontype, List<OptionDTO> optionsDTO) {
        super(id, question, idSurvey, idQuestiontype);
        this.optionsDTO = optionsDTO;
    }

    public List<OptionDTO> getOptionsDTO() { return optionsDTO; }
    public void setOptionsDTO(List<OptionDTO> optionsDTO) { this.optionsDTO = optionsDTO; }
}
