package com.frimac.preoperational.domain.dto;

import java.util.Date;

public class SurveyCompletionDTO {

    private Long id;
    private Date date;
    private Boolean iscompleted;
    private String idUser;
    private Long idSurvey;

    public SurveyCompletionDTO(Long id, Date date, Boolean iscompleted, String idUser, Long idSurvey) {
        this.id = id;
        this.date = date;
        this.iscompleted = iscompleted;
        this.idUser = idUser;
        this.idSurvey = idSurvey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(Boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Long getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(Long idSurvey) {
        this.idSurvey = idSurvey;
    }

    
    
}
