/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
public class EmployeeAverageSkillDto {

    private Long id;
    private Long employeeSkillLvl;
    private EmployeeEvaluationRelationDto employeeEvaluationRelation;
    private SkillDto skill;
    private boolean modificate;

    public EmployeeAverageSkillDto() {
        modificate = false;
    }

    public EmployeeAverageSkillDto(EmployeeAverageSkill employeeAverageSkill) {
        this();
        this.id = employeeAverageSkill.getEasId();
        this.employeeSkillLvl = employeeAverageSkill.getEasEmployeeSkillLvl();
        this.employeeEvaluationRelation = new EmployeeEvaluationRelationDto(employeeAverageSkill.getEasEerId());
        this.skill = new SkillDto(employeeAverageSkill.getEasSkillId());
    }

    public void updateEmployeeAverageSkillDto(EmployeeAverageSkill employeeAverageSkill) {
        this.id = employeeAverageSkill.getEasId();
        this.employeeSkillLvl = employeeAverageSkill.getEasEmployeeSkillLvl();
        this.employeeEvaluationRelation.updateEmployeeEvaluationRelationDto(employeeAverageSkill.getEasEerId());
        this.skill.updateSkillDto(employeeAverageSkill.getEasSkillId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeSkillLvl() {
        return employeeSkillLvl;
    }

    public void setEmployeeSkillLvl(Long employeeSkillLvl) {
        this.employeeSkillLvl = employeeSkillLvl;
    }

    public EmployeeEvaluationRelationDto getEmployeeEvaluationRelation() {
        return employeeEvaluationRelation;
    }

    public void setEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelation) {
        this.employeeEvaluationRelation = employeeEvaluationRelation;
    }

    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "EmployeeAverageSkillDto{" + "easId=" + id + ", easEmployeeSkillLvl=" + employeeSkillLvl + ", easEerId=" + employeeEvaluationRelation + ", easSkillId=" + skill + ", modificate=" + modificate + '}';
    }

}
