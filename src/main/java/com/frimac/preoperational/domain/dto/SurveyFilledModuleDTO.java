package com.frimac.preoperational.domain.dto;

import java.util.List;

public class SurveyFilledModuleDTO {
    private Long idSurvey;
    private String nameSurvey;
    private String descriptionSurvey;
    private boolean stateSurvey;
    private List<QuestionWithOptionsDTO> questionsDTO;


    public SurveyFilledModuleDTO() {
    }

    public SurveyFilledModuleDTO(Long idSurvey, String nameSurvey, String descriptionSurvey, 
        boolean stateSurvey, List<QuestionWithOptionsDTO> questionsDTO) {
        this.idSurvey = idSurvey;
        this.nameSurvey = nameSurvey;
        this.descriptionSurvey = descriptionSurvey;
        this.stateSurvey = stateSurvey;
        this.questionsDTO = questionsDTO;
    }

    // Getters y Setters
    public Long getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(Long idSurvey) {
        this.idSurvey = idSurvey;
    }

    public String getNameSurvey() {
        return nameSurvey;
    }

    public void setNameSurvey(String nameSurvey) {
        this.nameSurvey = nameSurvey;
    }

    public String getDescriptionSurvey() {
        return descriptionSurvey;
    }

    public void setDescriptionSurvey(String descriptionSurvey) {
        this.descriptionSurvey = descriptionSurvey;
    }

    public boolean isStateSurvey() {
        return stateSurvey;
    }

    public void setStateSurvey(boolean stateSurvey) {
        this.stateSurvey = stateSurvey;
    }

    public List<QuestionWithOptionsDTO> getQuestionsDTO() {
        return questionsDTO;
    }

    public void setQuestionsDTO(List<QuestionWithOptionsDTO> questionsDTO) {
        this.questionsDTO = questionsDTO;
    }

    @Override
    public String toString() {
        return "SurveyFilledModuleDTO{" +
                "idSurvey=" + idSurvey +
                ", nameSurvey='" + nameSurvey + '\'' +
                ", descriptionSurvey='" + descriptionSurvey + '\'' +
                ", stateSurvey=" + stateSurvey +
                ", questions=" + questionsDTO +
                '}';
    }
}

