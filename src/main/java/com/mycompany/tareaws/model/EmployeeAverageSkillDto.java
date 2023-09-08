/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
        this.id = employeeAverageSkill.getId();
        this.employeeSkillLvl = employeeAverageSkill.getSkillAverageLvl();
    }

    public void setForeignAtributes(EmployeeAverageSkill employeeAverageSkill) {
        employeeEvaluationRelation = new EmployeeEvaluationRelationDto(employeeAverageSkill.getEmployeeEvaluationRelation());
        employeeEvaluationRelation.setForeignAtributes(employeeAverageSkill.getEmployeeEvaluationRelation());
        skill = new SkillDto(employeeAverageSkill.getSkill());
        skill.setForeignAtributes(employeeAverageSkill.getSkill());
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "employeeSkillLvl")
    public Long getEmployeeSkillLvl() {
        return employeeSkillLvl;
    }

    public void setEmployeeSkillLvl(Long employeeSkillLvl) {
        this.employeeSkillLvl = employeeSkillLvl;
    }

    @XmlElement(name = "employeeEvaluationRelation")
    public EmployeeEvaluationRelationDto getEmployeeEvaluationRelation() {
        return employeeEvaluationRelation;
    }

    public void setEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelation) {
        this.employeeEvaluationRelation = employeeEvaluationRelation;
    }

    @XmlElement(name = "skill")
    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    @XmlElement(name = "modificate")
    public boolean isModificate() {
        return modificate;
    }

    public void setModificate(boolean modificate) {
        this.modificate = modificate;
    }

    @Override
    public String toString() {
        return "EmployeeAverageSkillDto{" + "id=" + id + ", employeeSkillLvl=" + employeeSkillLvl + ", employeeEvaluationRelation=" + employeeEvaluationRelation + ", skill=" + skill + ", modificate=" + modificate + '}';
    }
}