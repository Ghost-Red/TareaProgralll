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

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EE_SKILL_RELATION")
@NamedQueries({
    @NamedQuery(name = "EESkillRelation.findAll", query = "SELECT e FROM EESkillRelation e"),
    @NamedQuery(name = "EESkillRelation.findByEesId", query = "SELECT e FROM EESkillRelation e WHERE e.eesId = :eesId"),
    @NamedQuery(name = "EESkillRelation.findByEesSkillClasification", query = "SELECT e FROM EESkillRelation e WHERE e.eesSkillClasification = :eesSkillClasification"),
    @NamedQuery(name = "EESkillRelation.findByEesVersion", query = "SELECT e FROM EESkillRelation e WHERE e.eesVersion = :eesVersion")})
public class EESkillRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EES_ID")
    private Long eesId;
    @Column(name = "EES_SKILL_CLASIFICATION")
    private Long eesSkillClasification;
    @Basic(optional = false)
    @Column(name = "EES_VERSION")
    private Long eesVersion;
    @JoinColumn(name = "EES_EE_ID", referencedColumnName = "EE_ID")
    @ManyToOne(optional = false)
    private EmployeeEvaluatorRelation eesEeId;
    @JoinColumn(name = "EES_SKILL_ID", referencedColumnName = "SKILL_ID")
    @ManyToOne(optional = false)
    private Skill eesSkillId;

    public EESkillRelation() {
    }

    public EESkillRelation(Long eesId) {
        this.eesId = eesId;
    }

    public EESkillRelation(Long eesId, Long eesVersion) {
        this.eesId = eesId;
        this.eesVersion = eesVersion;
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

    public Long getEesVersion() {
        return eesVersion;
    }

    public void setEesVersion(Long eesVersion) {
        this.eesVersion = eesVersion;
    }

    public EmployeeEvaluatorRelation getEesEeId() {
        return eesEeId;
    }

    public void setEesEeId(EmployeeEvaluatorRelation eesEeId) {
        this.eesEeId = eesEeId;
    }

    public Skill getEesSkillId() {
        return eesSkillId;
    }

    public void setEesSkillId(Skill eesSkillId) {
        this.eesSkillId = eesSkillId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eesId != null ? eesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EESkillRelation)) {
            return false;
        }
        EESkillRelation other = (EESkillRelation) object;
        if ((this.eesId == null && other.eesId != null) || (this.eesId != null && !this.eesId.equals(other.eesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EESkillRelation[ eesId=" + eesId + " ]";
    }
    
}
