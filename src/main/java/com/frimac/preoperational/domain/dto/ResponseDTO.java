package com.frimac.preoperational.domain.dto;

import java.util.Date;

public class ResponseDTO {

    private Long id;
    private String response;
    private Date date;
    private String idUser;
    private Long idQuestion;

    public ResponseDTO(Long id, String response, Date date, String idUser, Long idQuestion) {
        this.id = id;
        this.response = response;
        this.date = date;
        this.idUser = idUser;
        this.idQuestion = idQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    
    
    
}
