/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EMPLOYEE_AVERAGE_SKILL")
@NamedQueries({
    @NamedQuery(name = "EmployeeAverageSkill.findAll", query = "SELECT e FROM EmployeeAverageSkill e"),
    @NamedQuery(name = "EmployeeAverageSkill.findByEasId", query = "SELECT e FROM EmployeeAverageSkill e WHERE e.easId = :easId"),
    @NamedQuery(name = "EmployeeAverageSkill.findByEasEmployeeSkillLvl", query = "SELECT e FROM EmployeeAverageSkill e WHERE e.easEmployeeSkillLvl = :easEmployeeSkillLvl"),
    @NamedQuery(name = "EmployeeAverageSkill.findByEasVersion", query = "SELECT e FROM EmployeeAverageSkill e WHERE e.easVersion = :easVersion")})
public class EmployeeAverageSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EAS_ID")
    private Long easId;
    @Column(name = "EAS_EMPLOYEE_SKILL_LVL")
    private Long easEmployeeSkillLvl;
    @Version
    @Column(name = "EAS_VERSION")
    private Long easVersion;
    @JoinColumn(name = "EAS_EER_ID", referencedColumnName = "EER_ID")
    @ManyToOne(optional = false)
    private EmployeeEvaluationRelation easEerId;
    @JoinColumn(name = "EAS_SKILL_ID", referencedColumnName = "SKILL_ID")
    @ManyToOne(optional = false)
    private Skill easSkillId;

    public EmployeeAverageSkill() {
    }

    public EmployeeAverageSkill(Long easId) {
        this.easId = easId;
    }

    public EmployeeAverageSkill(Long easId, Long easVersion) {
        this.easId = easId;
        this.easVersion = easVersion;
    }

    public EmployeeAverageSkill(EmployeeAverageSkillDto employeeAverageSkillDto) {
        updateEmployeeAverageSkill(employeeAverageSkillDto);
    }

    public void updateEmployeeAverageSkill(EmployeeAverageSkillDto employeeAverageSkillDto) {
        this.easId = employeeAverageSkillDto.getEasId();
        this.easEmployeeSkillLvl = employeeAverageSkillDto.getEasEmployeeSkillLvl();
        this.easEerId.updateEmployeeEvaluationRelation(employeeAverageSkillDto.getEasEerId());
        this.easSkillId.updateSkill(employeeAverageSkillDto.getEasSkillId());
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

    public Long getEasVersion() {
        return easVersion;
    }

    public void setEasVersion(Long easVersion) {
        this.easVersion = easVersion;
    }

    public EmployeeEvaluationRelation getEasEerId() {
        return easEerId;
    }

    public void setEasEerId(EmployeeEvaluationRelation easEerId) {
        this.easEerId = easEerId;
    }

    public Skill getEasSkillId() {
        return easSkillId;
    }

    public void setEasSkillId(Skill easSkillId) {
        this.easSkillId = easSkillId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (easId != null ? easId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeAverageSkill)) {
            return false;
        }
        EmployeeAverageSkill other = (EmployeeAverageSkill) object;
        if ((this.easId == null && other.easId != null) || (this.easId != null && !this.easId.equals(other.easId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EmployeeAverageSkill[ easId=" + easId + " ]";
    }

}
