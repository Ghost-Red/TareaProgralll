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
    
    public void setForeignAtributes(EESkillRelation eESkillRelation) {
        employeeEvaluatorRelation = new EmployeeEvaluatorRelationDto(eESkillRelation.getEmployeeEvaluatorRelation());
        evaluatedSkill = new SkillDto(eESkillRelation.getEvaluatedSkill());
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "skillClasification")
    public Long getSkillClasification() {
        return skillClasification;
    }

    public void setSkillClasification(Long skillClasification) {
        this.skillClasification = skillClasification;
    }

    @XmlElement(name = "employeeEvaluatorRelation")
    public EmployeeEvaluatorRelationDto getEmployeeEvaluatorRelation() {
        return employeeEvaluatorRelation;
    }

    public void setEmployeeEvaluatorRelation(EmployeeEvaluatorRelationDto employeeEvaluatorRelation) {
        this.employeeEvaluatorRelation = employeeEvaluatorRelation;
    }

    @XmlElement(name = "evaluatedSkill")
    public SkillDto getEvaluatedSkill() {
        return evaluatedSkill;
    }

    public void setEvaluatedSkill(SkillDto evaluatedSkill) {
        this.evaluatedSkill = evaluatedSkill;
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
        return "EESkillRelationDto{" + "id=" + id + ", skillClasification=" + skillClasification + ", employeeEvaluatorRelation=" + employeeEvaluatorRelation + ", evaluatedSkill=" + evaluatedSkill + ", modificate=" + modificate + '}';
    }
}

