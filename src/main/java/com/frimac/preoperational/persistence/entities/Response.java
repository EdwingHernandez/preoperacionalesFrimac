package com.frimac.preoperational.persistence.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "question_response")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_response")
    private Long id;

    @NotBlank
    private String response;

    @Column(name = "response_date", nullable = false)
    private Date date;

    
    @ManyToOne
    @JoinColumn(name = "idf_user", referencedColumnName = "id_user", nullable = false)
    private User user; 


    @ManyToOne
    @JoinColumn(name = "idf_question", referencedColumnName = "id_question", nullable = false)
    private Question question;

    private String reasonText;

    public Response() {
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


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Question getQuestion() {
        return question;
    }


    public void setQuestion(Question question) {
        this.question = question;
    }


    public String getReasonText() {
        return reasonText;
    }


    public void setReasonText(String reasonText) {
        this.reasonText = reasonText;
    }

    
}
