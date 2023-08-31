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
    @NamedQuery(name = "EmployeeAverageSkill.findById", query = "SELECT e FROM EmployeeAverageSkill e WHERE e.id = :id"),
    @NamedQuery(name = "EmployeeAverageSkill.findBySkillAverageLvl", query = "SELECT e FROM EmployeeAverageSkill e WHERE e.skillAverageLvl = :skillAverageLvl"),
    @NamedQuery(name = "EmployeeAverageSkill.findByVersion", query = "SELECT e FROM EmployeeAverageSkill e WHERE e.version = :version")})
public class EmployeeAverageSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EAS_ID")
    private Long id;
    @Column(name = "EAS_EMPLOYEE_SKILL_LVL")
    private Long skillAverageLvl;
    @Version
    @Column(name = "EAS_VERSION")
    private Long version;
    @JoinColumn(name = "EAS_EER_ID", referencedColumnName = "EER_ID")
    @ManyToOne(optional = false)
    private EmployeeEvaluationRelation employeeEvaluationRelation;
    @JoinColumn(name = "EAS_SKILL_ID", referencedColumnName = "SKILL_ID")
    @ManyToOne(optional = false)
    private Skill skill;

    public EmployeeAverageSkill() {
    }

    public EmployeeAverageSkill(Long id) {
        this.id = id;
    }

    public EmployeeAverageSkill(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public EmployeeAverageSkill(EmployeeAverageSkillDto employeeAverageSkillDto) {
        updateEmployeeAverageSkill(employeeAverageSkillDto);
    }

    public void updateEmployeeAverageSkill(EmployeeAverageSkillDto employeeAverageSkillDto) {
        this.id = employeeAverageSkillDto.getId();
        this.skillAverageLvl = employeeAverageSkillDto.getEmployeeSkillLvl();
        this.employeeEvaluationRelation.updateEmployeeEvaluationRelation(employeeAverageSkillDto.getEmployeeEvaluationRelation());
        this.skill.updateSkill(employeeAverageSkillDto.getSkill());
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public Long getskillAverageLvl() {
        return skillAverageLvl;
    }

    public void setskillAverageLvl(Long skillAverageLvl) {
        this.skillAverageLvl = skillAverageLvl;
    }

    public Long getversion() {
        return version;
    }

    public void setversion(Long version) {
        this.version = version;
    }

    public EmployeeEvaluationRelation getemployeeEvaluationRelation() {
        return employeeEvaluationRelation;
    }

    public void setemployeeEvaluationRelation(EmployeeEvaluationRelation employeeEvaluationRelation) {
        this.employeeEvaluationRelation = employeeEvaluationRelation;
    }

    public Skill getskill() {
        return skill;
    }

    public void setskill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeAverageSkill)) {
            return false;
        }
        EmployeeAverageSkill other = (EmployeeAverageSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EmployeeAverageSkill[ id=" + id + " ]";
    }

}
