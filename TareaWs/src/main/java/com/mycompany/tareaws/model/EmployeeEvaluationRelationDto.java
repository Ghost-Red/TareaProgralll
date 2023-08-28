/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
public class EmployeeEvaluationRelationDto {

    private Long eerId;
    private Long eerEmployeeClasification;
    private EmployeeDto eerEmpId;
    private EvaluationJobRelationDto eerEjrId;
    private boolean modificate;

    public EmployeeEvaluationRelationDto() {
        modificate = false;
    }

    public EmployeeEvaluationRelationDto(EmployeeEvaluationRelation EmployeeEvaluationRelation) {
        this();
        this.eerId = EmployeeEvaluationRelation.getEerId();
        this.eerEmployeeClasification = EmployeeEvaluationRelation.getEerEmployeeClasification();
        this.eerEmpId = new EmployeeDto(EmployeeEvaluationRelation.getEerEmpId());
        this.eerEjrId = new EvaluationJobRelationDto(EmployeeEvaluationRelation.getEerEjrId());
    }

    public void updateEmployeeEvaluationRelationDto(EmployeeEvaluationRelation EmployeeEvaluationRelation) {
        this.eerId = EmployeeEvaluationRelation.getEerId();
        this.eerEmployeeClasification = EmployeeEvaluationRelation.getEerEmployeeClasification();
        this.eerEmpId.updateEmployeeDto(EmployeeEvaluationRelation.getEerEmpId());
        this.eerEjrId.updateEvaluationJobRelationDto(EmployeeEvaluationRelation.getEerEjrId());
    }

    public Long getEerId() {
        return eerId;
    }

    public void setEerId(Long eerId) {
        this.eerId = eerId;
    }

    public Long getEerEmployeeClasification() {
        return eerEmployeeClasification;
    }

    public void setEerEmployeeClasification(Long eerEmployeeClasification) {
        this.eerEmployeeClasification = eerEmployeeClasification;
    }

    public EmployeeDto getEerEmpId() {
        return eerEmpId;
    }

    public void setEerEmpId(EmployeeDto eerEmpId) {
        this.eerEmpId = eerEmpId;
    }

    public EvaluationJobRelationDto getEerEjrId() {
        return eerEjrId;
    }

    public void setEerEjrId(EvaluationJobRelationDto eerEjrId) {
        this.eerEjrId = eerEjrId;
    }

    @Override
    public String toString() {
        return "EmployeeEvaluationRelationDto{" + "eerId=" + eerId + ", eerEmployeeClasification=" + eerEmployeeClasification + ", eerEmpId=" + eerEmpId + ", eerEjrId=" + eerEjrId + ", modificate=" + modificate + '}';
    }

}
