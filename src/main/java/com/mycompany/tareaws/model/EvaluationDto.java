/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<EvaluationJobRelationDto> evaluationJobRelationList;
    private boolean modificate;
    
    public EvaluationDto() {
        modificate = false;
        company = new CompanyDto();
        evaluationJobRelationList= new ArrayList<>();
    }

    public EvaluationDto(Evaluation evaluation) {
        this();
        this.id = evaluation.getId();
        this.title = evaluation.getTitle();
        this.startDate = evaluation.getStartDate();
        this.finalDate = evaluation.getFinalDate();
        this.state = evaluation.getState();
    }
    public void setForeignAtributes(Evaluation evaluation){
        company = new CompanyDto(evaluation.getCompany());
        company.setForeignAtributes(evaluation.getCompany());
        setEvaluationJobRelationList(evaluation.getEvaluationJobRelationList());
    }
    public List<EvaluationJobRelationDto> getEvaluationJobRelationList() {
        return evaluationJobRelationList;
    }
    public void setEvaluationJobRelationList(List<EvaluationJobRelation> evaluationJobRelationList) {
        for(EvaluationJobRelation evaluationJobRelation : evaluationJobRelationList){
            this.evaluationJobRelationList.add(new EvaluationJobRelationDto(evaluationJobRelation));
        }
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
        return "EvaluationDto{" + "id=" + id + ", title=" + title + ", startDate=" + startDate + ", finalDate=" + finalDate + ", state=" + state + ", company=" + company + ", modificate=" + modificate + '}';
    }

}
