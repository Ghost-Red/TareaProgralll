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
    public EESkillRelationDto (EESkillRelation EESkillRelation){
        this();
        this.eesId=EESkillRelation.getEesId();
        this.eesSkillClasification=EESkillRelation.getEesSkillClasification();
        this.eesEeId=new EmployeeEvaluatorRelationDto(EESkillRelation.getEesEeId());
        this.eesSkillId=new SkillDto(EESkillRelation.getEesSkillId());
    }
    public void updateEESkillRelationDto(EESkillRelation EESkillRelation){
        this.eesId=EESkillRelation.getEesId();
        this.eesSkillClasification=EESkillRelation.getEesSkillClasification();
        this.eesEeId.updateEmployeeEvaluatorRelationDto(EESkillRelation.getEesEeId());
        this.eesSkillId.updateSkillDto(EESkillRelation.getEesSkillId());
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
