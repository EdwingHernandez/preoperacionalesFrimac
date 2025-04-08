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
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_option")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "option_text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "idf_question", referencedColumnName = "id_question", nullable = false)
    private Question question;

    private boolean isCritical;
    private boolean reason;

    public Option() {
    }

    public Option(Long id, String text, Question question, boolean isCritical) {
        this.id = id;
        this.text = text;
        this.question = question;
        this.isCritical = isCritical;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }

    public boolean isReason() {
        return reason;
    }

    public void setReason(boolean reason) {
        this.reason = reason;
    }

    
}
