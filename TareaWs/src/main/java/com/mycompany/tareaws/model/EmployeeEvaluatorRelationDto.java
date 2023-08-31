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

    private Long id;
    private String employeeEvaluatorRelationType;
    private String feedback;
    private EmployeeDto employeeEvaluator;
    private EmployeeEvaluationRelationDto employeeEvaluated;
    private boolean modificate;

    public EmployeeEvaluatorRelationDto() {
        modificate = false;
    }

    public EmployeeEvaluatorRelationDto(EmployeeEvaluatorRelation employeeEvaluatorRelation) {
        this();
        this.id = employeeEvaluatorRelation.getId();
        this.employeeEvaluatorRelationType = employeeEvaluatorRelation.getEmployeeEvaluatorRelationType();
        this.feedback = employeeEvaluatorRelation.getFeedback();
        this.employeeEvaluator = new EmployeeDto(employeeEvaluatorRelation.getEmployeeEvaluator());
        this.employeeEvaluated = new EmployeeEvaluationRelationDto(employeeEvaluatorRelation.getEmployeeEvaluated());
    }

    public void updateEmployeeEvaluatorRelationDto(EmployeeEvaluatorRelation employeeEvaluatorRelation) {
        this.id = employeeEvaluatorRelation.getId();
        this.employeeEvaluatorRelationType = employeeEvaluatorRelation.getEmployeeEvaluatorRelationType();
        this.feedback = employeeEvaluatorRelation.getFeedback();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeEvaluatorRelationType() {
        return employeeEvaluatorRelationType;
    }

    public void setEmployeeEvaluatorRelationType(String employeeEvaluatorRelationType) {
        this.employeeEvaluatorRelationType = employeeEvaluatorRelationType;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public EmployeeDto getEmployeeEvaluator() {
        return employeeEvaluator;
    }

    public void setEmployeeEvaluator(EmployeeDto employeeEvaluator) {
        this.employeeEvaluator = employeeEvaluator;
    }

    public EmployeeEvaluationRelationDto getEmployeeEvaluated() {
        return employeeEvaluated;
    }

    public void setEmployeeEvaluated(EmployeeEvaluationRelationDto employeeEvaluated) {
        this.employeeEvaluated = employeeEvaluated;
    }

    @Override
    public String toString() {
        return "EmployeeEvaluatorRelationDto{" + "id=" + id + ", employeeEvaluatorRelationType=" + employeeEvaluatorRelationType + ", feedback=" + feedback + ", id=" + employeeEvaluator + ", employeeEvaluated=" + employeeEvaluated + ", modificate=" + modificate + '}';
    }

}
