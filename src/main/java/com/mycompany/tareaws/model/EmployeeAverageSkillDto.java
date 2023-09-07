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
        employeeEvaluationRelation = new EmployeeEvaluationRelationDto();
        skill = new SkillDto();
    }

    public EmployeeAverageSkillDto(EmployeeAverageSkill employeeAverageSkill) {
        this();
        this.id = employeeAverageSkill.getid();
        this.employeeSkillLvl = employeeAverageSkill.getskillAverageLvl();
    }
    
    public void setForeignAtributes(EmployeeAverageSkill employeeAverageSkill){
        employeeEvaluationRelation = new EmployeeEvaluationRelationDto(employeeAverageSkill.getemployeeEvaluationRelation());
        skill = new SkillDto(employeeAverageSkill.getskill());
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
        return "EmployeeAverageSkillDto{" + "id=" + id + ", skillAverageLvl=" + employeeSkillLvl + ", employeeEvaluationRelation=" + employeeEvaluationRelation + ", skill=" + skill + ", modificate=" + modificate + '}';
    }

}
