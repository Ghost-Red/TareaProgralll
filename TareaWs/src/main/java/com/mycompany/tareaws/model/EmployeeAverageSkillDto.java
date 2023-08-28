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

    private Long easId;
    private Long easEmployeeSkillLvl;
    private EmployeeEvaluationRelationDto easEerId;
    private SkillDto easSkillId;
    private boolean modificate;

    public EmployeeAverageSkillDto() {
        modificate = false;
    }

    public EmployeeAverageSkillDto(EmployeeAverageSkill employeeAverageSkill) {
        this();
        this.easId = employeeAverageSkill.getEasId();
        this.easEmployeeSkillLvl = employeeAverageSkill.getEasEmployeeSkillLvl();
        this.easEerId = new EmployeeEvaluationRelationDto(employeeAverageSkill.getEasEerId());
        this.easSkillId = new SkillDto(employeeAverageSkill.getEasSkillId());
    }

    public void updateEmployeeAverageSkillDto(EmployeeAverageSkill employeeAverageSkill) {
        this.easId = employeeAverageSkill.getEasId();
        this.easEmployeeSkillLvl = employeeAverageSkill.getEasEmployeeSkillLvl();
        this.easEerId.updateEmployeeEvaluationRelationDto(employeeAverageSkill.getEasEerId());
        this.easSkillId.updateSkillDto(employeeAverageSkill.getEasSkillId());
    }

    public Long getEasId() {
        return easId;
    }

    public void setEasId(Long easId) {
        this.easId = easId;
    }

    public Long getEasEmployeeSkillLvl() {
        return easEmployeeSkillLvl;
    }

    public void setEasEmployeeSkillLvl(Long easEmployeeSkillLvl) {
        this.easEmployeeSkillLvl = easEmployeeSkillLvl;
    }

    public EmployeeEvaluationRelationDto getEasEerId() {
        return easEerId;
    }

    public void setEasEerId(EmployeeEvaluationRelationDto easEerId) {
        this.easEerId = easEerId;
    }

    public SkillDto getEasSkillId() {
        return easSkillId;
    }

    public void setEasSkillId(SkillDto easSkillId) {
        this.easSkillId = easSkillId;
    }

    @Override
    public String toString() {
        return "EmployeeAverageSkillDto{" + "easId=" + easId + ", easEmployeeSkillLvl=" + easEmployeeSkillLvl + ", easEerId=" + easEerId + ", easSkillId=" + easSkillId + ", modificate=" + modificate + '}';
    }

}
