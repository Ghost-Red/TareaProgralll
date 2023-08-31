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
    private SkillDto skill;
    private boolean modificate;

    public EESkillRelationDto() {
        modificate = false;
    }

    public EESkillRelationDto(EESkillRelation eESkillRelation) {
        this();
<<<<<<< HEAD
        this.id = eESkillRelation.getid();
        this.skillClasification = eESkillRelation.getskillClasification();
=======
        this.id = eESkillRelation.getEesId();
        this.skillClasification = eESkillRelation.getEesSkillClasification();
        this.employeeEvaluatorRelation = new EmployeeEvaluatorRelationDto(eESkillRelation.getEesEeId());
        this.skill = new SkillDto(eESkillRelation.getEesSkillId());
    }

    public void updateEESkillRelationDto(EESkillRelation eESkillRelation) {
        this.id = eESkillRelation.getEesId();
        this.skillClasification = eESkillRelation.getEesSkillClasification();
        this.employeeEvaluatorRelation.updateEmployeeEvaluatorRelationDto(eESkillRelation.getEesEeId());
        this.skill.updateSkillDto(eESkillRelation.getEesSkillId());
>>>>>>> parent of 41fcac5 (Se re-estructuraron los Dto y service)
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

    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "EESkillRelationDto{" + "id=" + id + ", skillClasification=" + skillClasification + ", employeeEvaluatorRelation=" + employeeEvaluatorRelation + ", evaluatedSkill=" + skill + ", modificate=" + modificate + '}';
    }

}
