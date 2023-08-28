/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
public class EvaluationJobRelationDto {

    private Long ejrId;
    private EvaluationDto ejrEvaId;
    private JobDto ejrJobId;

    private boolean modificate;

    public EvaluationJobRelationDto() {
        modificate = false;
    }

    public EvaluationJobRelationDto(EvaluationJobRelation evaluationJobRelation) {
        this();
        this.ejrId = evaluationJobRelation.getEjrId();
        this.ejrEvaId = new EvaluationDto(evaluationJobRelation.getEjrEvaId());
        this.ejrJobId = new JobDto(evaluationJobRelation.getEjrJobId());
    }

    public void updateEvaluationJobRelationDto(EvaluationJobRelation evaluationJobRelation) {
        this.ejrId = evaluationJobRelation.getEjrId();
        this.ejrEvaId.updateEvaluationDto(evaluationJobRelation.getEjrEvaId());
        this.ejrJobId.updateJobDto(evaluationJobRelation.getEjrJobId());
    }

    public Long getEjrId() {
        return ejrId;
    }

    public void setEjrId(Long ejrId) {
        this.ejrId = ejrId;
    }

    public EvaluationDto getEjrEvaId() {
        return ejrEvaId;
    }

    public void setEjrEvaId(EvaluationDto ejrEvaId) {
        this.ejrEvaId = ejrEvaId;
    }

    public JobDto getEjrJobId() {
        return ejrJobId;
    }

    public void setEjrJobId(JobDto ejrJobId) {
        this.ejrJobId = ejrJobId;
    }

    @Override
    public String toString() {
        return "EvaluationJobRelationDto{" + "ejrId=" + ejrId + ", ejrEvaId=" + ejrEvaId + ", ejrJobId=" + ejrJobId + ", modificate=" + modificate + '}';
    }

}
