/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class EmployeeEvaluationRelationDto {

    private Long id;
    private Long employeeClasification;
    private EmployeeDto employeeEvaluated;
    private EvaluationJobRelationDto evaluationJobRelation;
    private boolean modificate;

    private List<EmployeeAverageSkillDto> employeeAverageSkillList;
    private List<EmployeeEvaluatorRelationDto> employeeEvaluatorRelationList;
    
    public EmployeeEvaluationRelationDto() {
        modificate = false;
        employeeEvaluated = new EmployeeDto();
        evaluationJobRelation = new EvaluationJobRelationDto();
        employeeAverageSkillList= new ArrayList<>();
        employeeEvaluatorRelationList= new ArrayList<>();
    }

    public EmployeeEvaluationRelationDto(EmployeeEvaluationRelation employeeEvaluationRelation) {
        this();
        this.id = employeeEvaluationRelation.getId();
        this.employeeClasification = employeeEvaluationRelation.getEmployeeClasification();

    }
     public void setForeignAtributes(EmployeeEvaluationRelation employeeEvaluationRelation){
         evaluationJobRelation = new EvaluationJobRelationDto(employeeEvaluationRelation.getEvaluationJobRelation());
         evaluationJobRelation.setForeignAtributes(employeeEvaluationRelation.getEvaluationJobRelation());
         employeeEvaluated = new EmployeeDto(employeeEvaluationRelation.getEmployeeEvaluated());
         employeeEvaluated.setForeignAtributes(employeeEvaluationRelation.getEmployeeEvaluated());
         setEmployeeAverageSkillList(employeeEvaluationRelation.getEmployeeAverageSkillList());
         setEmployeeEvaluatorRelationList(employeeEvaluationRelation.getEmployeeEvaluatorRelationList());
     }
     
    public List<EmployeeAverageSkillDto> getEmployeeAverageSkillList() {
        return employeeAverageSkillList;
    }

    public void setEmployeeAverageSkillList(List<EmployeeAverageSkill> employeeAverageSkillList) {
        for (EmployeeAverageSkill employeeAverageSkill : employeeAverageSkillList){
            this.employeeAverageSkillList.add(new EmployeeAverageSkillDto(employeeAverageSkill));
        }
    }

    public List<EmployeeEvaluatorRelationDto> getEmployeeEvaluatorRelationList() {
        return employeeEvaluatorRelationList;
    }

    public void setEmployeeEvaluatorRelationList(List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList) {
        for (EmployeeEvaluatorRelation employeeEvaluatorRelation : employeeEvaluatorRelationList){
            this.employeeEvaluatorRelationList.add(new EmployeeEvaluatorRelationDto(employeeEvaluatorRelation));
        }
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

    public EmployeeDto getEmployeeEvaluated() {
        return employeeEvaluated;
    }

    public void setEmployeeEvaluated(EmployeeDto employeeEvaluated) {
        this.employeeEvaluated = employeeEvaluated;
    }

    public EvaluationJobRelationDto getEvaluationJobRelation() {
        return evaluationJobRelation;
    }

    public void setEvaluationJobRelation(EvaluationJobRelationDto evaluationJobRelation) {
        this.evaluationJobRelation = evaluationJobRelation;
    }

    @Override
    public String toString() {
        return "EmployeeEvaluationRelationDto{" + "id=" + id + ", employeeClasification=" + employeeClasification + ", id=" + employeeEvaluated + ", evaluationJobRelation=" + evaluationJobRelation + ", modificate=" + modificate + '}';
    }

}
