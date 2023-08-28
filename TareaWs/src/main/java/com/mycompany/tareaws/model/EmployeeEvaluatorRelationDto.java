/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
public class EmployeeEvaluatorRelationDto {

    private Long eeId;
    private String eeRelationType;
    private String eeFeedback;
    private EmployeeDto eeEmpId;
    private EmployeeEvaluationRelationDto evaEmployeeId;
    private boolean modificate;

    public EmployeeEvaluatorRelationDto() {
        modificate = false;
    }

    public EmployeeEvaluatorRelationDto(EmployeeEvaluatorRelation EmployeeEvaluatorRelation) {
        this();
        this.eeId = EmployeeEvaluatorRelation.getEeId();
        this.eeRelationType = EmployeeEvaluatorRelation.getEeRelationType();
        this.eeFeedback = EmployeeEvaluatorRelation.getEeFeedback();
        this.eeEmpId = new EmployeeDto(EmployeeEvaluatorRelation.getEeEmpId());
        this.evaEmployeeId = new EmployeeEvaluationRelationDto(EmployeeEvaluatorRelation.getEvaEmployeeId());
    }

    public void updateEmployeeEvaluatorRelationDto(EmployeeEvaluatorRelation EmployeeEvaluatorRelation) {
        this.eeId = EmployeeEvaluatorRelation.getEeId();
        this.eeRelationType = EmployeeEvaluatorRelation.getEeRelationType();
        this.eeFeedback = EmployeeEvaluatorRelation.getEeFeedback();
        this.eeEmpId.updateEmployeeDto(EmployeeEvaluatorRelation.getEeEmpId());
        this.evaEmployeeId.updateEmployeeEvaluationRelationDto(EmployeeEvaluatorRelation.getEvaEmployeeId());
    }

    public Long getEeId() {
        return eeId;
    }

    public void setEeId(Long eeId) {
        this.eeId = eeId;
    }

    public String getEeRelationType() {
        return eeRelationType;
    }

    public void setEeRelationType(String eeRelationType) {
        this.eeRelationType = eeRelationType;
    }

    public String getEeFeedback() {
        return eeFeedback;
    }

    public void setEeFeedback(String eeFeedback) {
        this.eeFeedback = eeFeedback;
    }

    public EmployeeDto getEeEmpId() {
        return eeEmpId;
    }

    public void setEeEmpId(EmployeeDto eeEmpId) {
        this.eeEmpId = eeEmpId;
    }

    public EmployeeEvaluationRelationDto getEvaEmployeeId() {
        return evaEmployeeId;
    }

    public void setEvaEmployeeId(EmployeeEvaluationRelationDto evaEmployeeId) {
        this.evaEmployeeId = evaEmployeeId;
    }

    @Override
    public String toString() {
        return "EmployeeEvaluatorRelationDto{" + "eeId=" + eeId + ", eeRelationType=" + eeRelationType + ", eeFeedback=" + eeFeedback + ", eeEmpId=" + eeEmpId + ", evaEmployeeId=" + evaEmployeeId + ", modificate=" + modificate + '}';
    }

}
