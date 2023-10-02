/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EE_SKILL_RELATION")
@NamedQueries({
    @NamedQuery(name = "EESkillRelation.findAll", query = "SELECT e FROM EESkillRelation e"),
    @NamedQuery(name = "EESkillRelation.findById", query = "SELECT e FROM EESkillRelation e WHERE e.id = :id"),
    @NamedQuery(name = "EESkillRelation.findBySkillClasification", query = "SELECT e FROM EESkillRelation e WHERE e.skillClasification = :skillClasification"),
    @NamedQuery(name = "EESkillRelation.findByVersion", query = "SELECT e FROM EESkillRelation e WHERE e.version = :version")})
public class EESkillRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "EE_SKILL_RELATION_EES_ID_GENERATOR", sequenceName = "tarea.EE_SKILL_RELATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EE_SKILL_RELATION_EES_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "EES_ID")
    private Long id;
    @Column(name = "EES_SKILL_CLASIFICATION")
    private Long skillClasification;
    @Version
    @Column(name = "EES_VERSION")
    private Long version;
    @JoinColumn(name = "EES_EE_ID", referencedColumnName = "EE_ID")
    @ManyToOne(optional = false)
    private EmployeeEvaluatorRelation employeeEvaluatorRelation;
    @JoinColumn(name = "EES_SKILL_ID", referencedColumnName = "SKILL_ID")
    @ManyToOne(optional = false)
    private Skill evaluatedSkill;

    public EESkillRelation() {
    }

    public EESkillRelation(Long id) {
        this.id = id;
    }

    public EESkillRelation(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public EESkillRelation(EESkillRelationDto eESkillRelationDto) {
        updateEESkillRelation(eESkillRelationDto);
    }

    public void updateEESkillRelation(EESkillRelationDto eESkillRelationDto) {
        this.id = eESkillRelationDto.getId();
        this.skillClasification = eESkillRelationDto.getSkillClasification();
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public EmployeeEvaluatorRelation getEmployeeEvaluatorRelation() {
        return employeeEvaluatorRelation;
    }

    public void setEmployeeEvaluatorRelation(EmployeeEvaluatorRelation employeeEvaluatorRelation) {
        this.employeeEvaluatorRelation = employeeEvaluatorRelation;
    }

    public Skill getEvaluatedSkill() {
        return evaluatedSkill;
    }

    public void setEvaluatedSkill(Skill evaluatedSkill) {
        this.evaluatedSkill = evaluatedSkill;
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
        if (!(object instanceof EESkillRelation)) {
            return false;
        }
        EESkillRelation other = (EESkillRelation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EESkillRelation[ id=" + id + " ]";
    }

}
