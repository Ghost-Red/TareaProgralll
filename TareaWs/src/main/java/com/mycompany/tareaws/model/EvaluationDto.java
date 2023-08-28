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

    private Long evaId;
    private String evaTitle;
    private Date evaStartDate;
    private Date evaFinalDate;
    private String evaState;
    private CompanyDto evaComId;
    private boolean modificate;

    public EvaluationDto() {
        modificate = false;
    }

    public EvaluationDto(Evaluation evaluation) {
        this();
        this.evaId = evaluation.getEvaId();
        this.evaTitle = evaluation.getEvaTitle();
        this.evaStartDate = evaluation.getEvaStartDate();
        this.evaFinalDate = evaluation.getEvaFinalDate();
        this.evaState = evaluation.getEvaState();
        this.evaComId = new CompanyDto(evaluation.getEvaComId());
    }

    public void updateEvaluationDto(Evaluation evaluation) {
        this.evaId = evaluation.getEvaId();
        this.evaTitle = evaluation.getEvaTitle();
        this.evaStartDate = evaluation.getEvaStartDate();
        this.evaFinalDate = evaluation.getEvaFinalDate();
        this.evaState = evaluation.getEvaState();
        this.evaComId.updateCompanyDto(evaluation.getEvaComId());
    }

    public Long getEvaId() {
        return evaId;
    }

    public void setEvaId(Long evaId) {
        this.evaId = evaId;
    }

    public String getEvaTitle() {
        return evaTitle;
    }

    public void setEvaTitle(String evaTitle) {
        this.evaTitle = evaTitle;
    }

    public Date getEvaStartDate() {
        return evaStartDate;
    }

    public void setEvaStartDate(Date evaStartDate) {
        this.evaStartDate = evaStartDate;
    }

    public Date getEvaFinalDate() {
        return evaFinalDate;
    }

    public void setEvaFinalDate(Date evaFinalDate) {
        this.evaFinalDate = evaFinalDate;
    }

    public String getEvaState() {
        return evaState;
    }

    public void setEvaState(String evaState) {
        this.evaState = evaState;
    }

    public CompanyDto getEvaComId() {
        return evaComId;
    }

    public void setEvaComId(CompanyDto evaComId) {
        this.evaComId = evaComId;
    }

    @Override
    public String toString() {
        return "EvaluationDto{" + "evaId=" + evaId + ", evaTitle=" + evaTitle + ", evaStartDate=" + evaStartDate + ", evaFinalDate=" + evaFinalDate + ", evaState=" + evaState + ", evaComId=" + evaComId + ", modificate=" + modificate + '}';
    }

}
