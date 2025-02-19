package com.frimac.preoperational.persistence.entities;

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
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long id;


    @NotBlank
    @Column(name = "question_text")
    private String question;

    @ManyToOne
    @JoinColumn(name = "idf_survey", referencedColumnName = "id_survey")
    private Survey survey;


    @ManyToOne
    @JoinColumn(name = "idf_qtype", referencedColumnName = "id_qtype")
    private QuestionType questionType;


    public Question() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public Survey getSurvey() {
        return survey;
    }


    public void setSurvey(Survey survey) {
        this.survey = survey;
    }


    public QuestionType getQuestionType() {
        return questionType;
    }


    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }


    

}
