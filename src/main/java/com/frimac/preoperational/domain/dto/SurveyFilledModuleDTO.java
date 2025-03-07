package com.frimac.preoperational.domain.dto;

import java.util.List;

public class SurveyFilledModuleDTO {
    private Long idSurvey;
    private String nameSurvey;
    private String descriptionSurvey;
    private boolean stateSurvey;
    private List<QuestionDTO> questions;

    // Constructor vacío (necesario para frameworks como Jackson)
    public SurveyFilledModuleDTO() {
    }

    // Constructor con parámetros
    public SurveyFilledModuleDTO(Long idSurvey, String nameSurvey, String descriptionSurvey, 
                                 boolean stateSurvey, List<QuestionDTO> questions) {
        this.idSurvey = idSurvey;
        this.nameSurvey = nameSurvey;
        this.descriptionSurvey = descriptionSurvey;
        this.stateSurvey = stateSurvey;
        this.questions = questions;
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

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "SurveyFilledModuleDTO{" +
                "idSurvey=" + idSurvey +
                ", nameSurvey='" + nameSurvey + '\'' +
                ", descriptionSurvey='" + descriptionSurvey + '\'' +
                ", stateSurvey=" + stateSurvey +
                ", questions=" + questions +
                '}';
    }
}

