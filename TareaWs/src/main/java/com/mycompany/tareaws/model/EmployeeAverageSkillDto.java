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

    public EmployeeAverageSkillDto(EmployeeAverageSkill EmployeeAverageSkill) {
        this();
        this.easId = EmployeeAverageSkill.getEasId();
        this.easEmployeeSkillLvl = EmployeeAverageSkill.getEasEmployeeSkillLvl();
        this.easEerId = new EmployeeEvaluationRelationDto(EmployeeAverageSkill.getEasEerId());
        this.easSkillId = new SkillDto(EmployeeAverageSkill.getEasSkillId());
    }

    public void updateEmployeeAverageSkillDto(EmployeeAverageSkill EmployeeAverageSkill) {
        this.easId = EmployeeAverageSkill.getEasId();
        this.easEmployeeSkillLvl = EmployeeAverageSkill.getEasEmployeeSkillLvl();
        this.easEerId.updateEmployeeEvaluationRelationDto(EmployeeAverageSkill.getEasEerId());
        this.easSkillId.updateSkillDto(EmployeeAverageSkill.getEasSkillId());
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
