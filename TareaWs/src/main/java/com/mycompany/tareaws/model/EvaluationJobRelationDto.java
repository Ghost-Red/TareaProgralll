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

    private Long id;
    private EvaluationDto evaluation;
    private JobDto job;

    private boolean modificate;

    public EvaluationJobRelationDto() {
        modificate = false;
    }

    public EvaluationJobRelationDto(EvaluationJobRelation evaluationJobRelation) {
        this();
        this.id = evaluationJobRelation.getEjrId();
        this.evaluation = new EvaluationDto(evaluationJobRelation.getEjrEvaId());
        this.job = new JobDto(evaluationJobRelation.getEjrJobId());
    }

    public void updateEvaluationJobRelationDto(EvaluationJobRelation evaluationJobRelation) {
        this.id = evaluationJobRelation.getEjrId();
        this.evaluation.updateEvaluationDto(evaluationJobRelation.getEjrEvaId());
        this.job.updateJobDto(evaluationJobRelation.getEjrJobId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EvaluationDto getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationDto evaluation) {
        this.evaluation = evaluation;
    }

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "EvaluationJobRelationDto{" + "ejrId=" + id + ", ejrEvaId=" + evaluation + ", ejrJobId=" + job + ", modificate=" + modificate + '}';
    }

}
