/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
public class EESkillRelationDto {

    private Long id;
    private Long skillClasification;
    private EmployeeEvaluatorRelationDto employeeEvaluatorRelation;
    private SkillDto evaluatedSkill;
    private boolean modificate;

    public EESkillRelationDto() {
        modificate = false;
        employeeEvaluatorRelation = new EmployeeEvaluatorRelationDto();
        evaluatedSkill = new SkillDto();
    }

    public EESkillRelationDto(EESkillRelation eESkillRelation) {
        this();
        this.id = eESkillRelation.getId();
        this.skillClasification = eESkillRelation.getSkillClasification();
    }
    public void setForeignAtributes(EESkillRelation eESkillRelation){
        employeeEvaluatorRelation = new EmployeeEvaluatorRelationDto(eESkillRelation.getEmployeeEvaluatorRelation());
        evaluatedSkill = new SkillDto(eESkillRelation.getEvaluatedSkill());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkillClasification() {
        return skillClasification;
    }

    public void setSkillClasification(Long skillClasification) {
        this.skillClasification = skillClasification;
    }

    public EmployeeEvaluatorRelationDto getEmployeeEvaluatorRelation() {
        return employeeEvaluatorRelation;
    }

    public void setEmployeeEvaluatorRelation(EmployeeEvaluatorRelationDto employeeEvaluatorRelation) {
        this.employeeEvaluatorRelation = employeeEvaluatorRelation;
    }

    public SkillDto getEvaluatedSkill() {
        return evaluatedSkill;
    }

    public void setEvaluatedSkill(SkillDto evaluatedSkill) {
        this.evaluatedSkill = evaluatedSkill;
    }

    @Override
    public String toString() {
        return "EESkillRelationDto{" + "id=" + id + ", skillClasification=" + skillClasification + ", employeeEvaluatorRelation=" + employeeEvaluatorRelation + ", evaluatedSkill=" + evaluatedSkill + ", modificate=" + modificate + '}';
    }

}
