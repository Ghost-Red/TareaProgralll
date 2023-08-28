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

    private Long eesId;
    private Long eesSkillClasification;
    private EmployeeEvaluatorRelationDto eesEeId;
    private SkillDto eesSkillId;
    private boolean modificate;

    public EESkillRelationDto() {
        modificate = false;
    }

    public EESkillRelationDto(EESkillRelation eESkillRelation) {
        this();
        this.eesId = eESkillRelation.getEesId();
        this.eesSkillClasification = eESkillRelation.getEesSkillClasification();
        this.eesEeId = new EmployeeEvaluatorRelationDto(eESkillRelation.getEesEeId());
        this.eesSkillId = new SkillDto(eESkillRelation.getEesSkillId());
    }

    public void updateEESkillRelationDto(EESkillRelation eESkillRelation) {
        this.eesId = eESkillRelation.getEesId();
        this.eesSkillClasification = eESkillRelation.getEesSkillClasification();
        this.eesEeId.updateEmployeeEvaluatorRelationDto(eESkillRelation.getEesEeId());
        this.eesSkillId.updateSkillDto(eESkillRelation.getEesSkillId());
    }

    public Long getEesId() {
        return eesId;
    }

    public void setEesId(Long eesId) {
        this.eesId = eesId;
    }

    public Long getEesSkillClasification() {
        return eesSkillClasification;
    }

    public void setEesSkillClasification(Long eesSkillClasification) {
        this.eesSkillClasification = eesSkillClasification;
    }

    public EmployeeEvaluatorRelationDto getEesEeId() {
        return eesEeId;
    }

    public void setEesEeId(EmployeeEvaluatorRelationDto eesEeId) {
        this.eesEeId = eesEeId;
    }

    public SkillDto getEesSkillId() {
        return eesSkillId;
    }

    public void setEesSkillId(SkillDto eesSkillId) {
        this.eesSkillId = eesSkillId;
    }

    @Override
    public String toString() {
        return "EESkillRelationDto{" + "eesId=" + eesId + ", eesSkillClasification=" + eesSkillClasification + ", eesEeId=" + eesEeId + ", eesSkillId=" + eesSkillId + ", modificate=" + modificate + '}';
    }

}
