package com.frimac.preoperational.persistence.entities;

import java.sql.Date;

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
@Table(name = "surveyAssignment")
public class SurveyAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assignment")
    private Long id;

    @NotBlank
    @Column(name = "assignment_date")
    private Date date;


    @ManyToOne
    @JoinColumn(name = "idf_user", referencedColumnName = "id_user", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "idf_survey", referencedColumnName = "id_survey", nullable = false)
    private Survey survey;


    public SurveyAssignment() {
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
