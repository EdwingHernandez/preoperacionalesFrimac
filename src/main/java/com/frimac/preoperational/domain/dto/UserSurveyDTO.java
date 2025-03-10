package com.frimac.preoperational.domain.dto;

import java.util.List;

import com.frimac.preoperational.persistence.entities.Survey;

public class UserSurveyDTO {
    private String idUser;
    private String name;
    private String position;
    private String area;
    private List<Survey> enabledSurveys;

    public UserSurveyDTO() {
    }

    public UserSurveyDTO(String idUser, String name, String position, String area, List<Survey> enabledSurveys) {
        this.idUser = idUser;
        this.name = name;
        this.position = position;
        this.area = area;
        this.enabledSurveys = enabledSurveys;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<Survey> getEnabledSurveys() {
        return enabledSurveys;
    }

    public void setEnabledSurveys(List<Survey> enabledSurveys) {
        this.enabledSurveys = enabledSurveys;
    }

    
   
}
