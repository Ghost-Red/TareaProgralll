/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.Date;

/**
 *
 * @author james
 */
public class EvaluationDto {

    private Long id;
    private String title;
    private Date startDate;
    private Date finalDate;
    private String state;
    private CompanyDto company;
    private boolean modificate;

    public EvaluationDto() {
        modificate = false;
    }

    public EvaluationDto(Evaluation evaluation) {
        this();
        this.id = evaluation.getEvaId();
        this.title = evaluation.getEvaTitle();
        this.startDate = evaluation.getEvaStartDate();
        this.finalDate = evaluation.getEvaFinalDate();
        this.state = evaluation.getEvaState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "EvaluationDto{" + "evaId=" + id + ", evaTitle=" + title + ", evaStartDate=" + startDate + ", evaFinalDate=" + finalDate + ", evaState=" + state + ", evaComId=" + company + ", modificate=" + modificate + '}';
    }

}
