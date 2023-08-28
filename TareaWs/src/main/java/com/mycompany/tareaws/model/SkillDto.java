/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
public class SkillDto {

    private Long skillId;
    private String skillName;
    private String skillDescription;
    private String skillState;
    private CompanyDto skillComId;
    private boolean modificate;

    public SkillDto() {
        modificate = false;
    }

    public SkillDto(Skill skill) {
        this();
        this.skillId = skill.getSkillId();
        this.skillName = skill.getSkillName();
        this.skillDescription = skill.getSkillDescription();
        this.skillState = skill.getSkillState();
        this.skillComId = new CompanyDto(skill.getSkillComId());
    }

    public void updateSkillDto(Skill skill) {
        this.skillId = skill.getSkillId();
        this.skillName = skill.getSkillName();
        this.skillDescription = skill.getSkillDescription();
        this.skillState = skill.getSkillState();
        this.skillComId.updateCompanyDto(skill.getSkillComId());
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillState() {
        return skillState;
    }

    public void setSkillState(String skillState) {
        this.skillState = skillState;
    }

    public CompanyDto getSkillComId() {
        return skillComId;
    }

    public void setSkillComId(CompanyDto skillComId) {
        this.skillComId = skillComId;
    }

    @Override
    public String toString() {
        return "SkillDto{" + "skillId=" + skillId + ", skillName=" + skillName + ", skillDescription=" + skillDescription + ", skillState=" + skillState + ", skillComId=" + skillComId + ", modificate=" + modificate + '}';
    }

}
