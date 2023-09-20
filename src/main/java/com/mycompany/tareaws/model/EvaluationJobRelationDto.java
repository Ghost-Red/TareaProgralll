/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
@XmlRootElement
public class EvaluationJobRelationDto {

    private Long id;
    private EvaluationDto evaluation;
    private JobDto job;
    private boolean modificate;

    private List<EmployeeEvaluationRelationDto> employeeEvaluationRelationList;

    public EvaluationJobRelationDto() {
        modificate = false;
        evaluation = new EvaluationDto();
        job = new JobDto();
        employeeEvaluationRelationList = new ArrayList<>();
    }

    public EvaluationJobRelationDto(EvaluationJobRelation evaluationJobRelation) {
        this();
        if (evaluationJobRelation != null) {
            this.id = evaluationJobRelation.getId();
        } else {
            evaluation = null;
            job = null;
        }
    }

    public void setForeignAtributes(EvaluationJobRelation evaluationJobRelation) {
        evaluation = new EvaluationDto(evaluationJobRelation.getEvaluation());
        job = new JobDto(evaluationJobRelation.getJob());
        setEmployeeEvaluationRelationList(evaluationJobRelation.getEmployeeEvaluationRelationList());
    }

    @XmlElement(name = "employeeEvaluationRelationList")
    public List<EmployeeEvaluationRelationDto> getEmployeeEvaluationRelationList() {
        return employeeEvaluationRelationList;
    }

    public void setEmployeeEvaluationRelationList(List<EmployeeEvaluationRelation> employeeEvaluationRelationList) {
        for (EmployeeEvaluationRelation employeeEvaluationRelation : employeeEvaluationRelationList) {
            this.employeeEvaluationRelationList.add(new EmployeeEvaluationRelationDto(employeeEvaluationRelation));
        }
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "evaluation")
    public EvaluationDto getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationDto evaluation) {
        this.evaluation = evaluation;
    }

    @XmlElement(name = "job")
    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "EvaluationJobRelationDto{" + "id=" + id + ", evaluation=" + evaluation + ", job=" + job + ", modificate=" + modificate + '}';
    }
}
