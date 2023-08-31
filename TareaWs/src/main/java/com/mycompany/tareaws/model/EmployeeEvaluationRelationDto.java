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

    private Long id;
    private Long employeeClasification;
    private EmployeeDto employee;
    private EvaluationJobRelationDto evaluationJobRelation;
    private boolean modificate;

    public EmployeeEvaluationRelationDto() {
        modificate = false;
    }

    public EmployeeEvaluationRelationDto(EmployeeEvaluationRelation employeeEvaluationRelation) {
        this();
        this.id = employeeEvaluationRelation.getId();
        this.employeeClasification = employeeEvaluationRelation.getEmployeeClasification();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeClasification() {
        return employeeClasification;
    }

    public void setEmployeeClasification(Long employeeClasification) {
        this.employeeClasification = employeeClasification;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public EvaluationJobRelationDto getEvaluationJobRelation() {
        return evaluationJobRelation;
    }

    public void setEvaluationJobRelation(EvaluationJobRelationDto evaluationJobRelation) {
        this.evaluationJobRelation = evaluationJobRelation;
    }

    @Override
    public String toString() {
        return "EmployeeEvaluationRelationDto{" + "id=" + id + ", employeeClasification=" + employeeClasification + ", id=" + employee + ", evaluationJobRelation=" + evaluationJobRelation + ", modificate=" + modificate + '}';
    }

}
