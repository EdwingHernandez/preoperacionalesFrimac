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
@Table(name = "surveyCompletion")
public class SurveyCompletion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_completion")
    private Long id;
    
    @Column(name = "completion_date", nullable = false)
    private Date date;    

    @NotBlank
    private Boolean iscompleted;


    @ManyToOne
    @JoinColumn(name = "idf_user", referencedColumnName = "id_user", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "idf_survey", referencedColumnName = "id_survey", nullable = false)
    private Survey survey;


    public SurveyCompletion() {
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


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Survey getSurvey() {
        return survey;
    }


    public void setSurvey(Survey survey) {
        this.survey = survey;
    }    

}
