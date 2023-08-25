/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EMPLOYEE_EVALUATOR_RELATION")
@NamedQueries({
    @NamedQuery(name = "EmployeeEvaluatorRelation.findAll", query = "SELECT e FROM EmployeeEvaluatorRelation e"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findByEeId", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.eeId = :eeId"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findByEeRelationType", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.eeRelationType = :eeRelationType"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findByEeFeedback", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.eeFeedback = :eeFeedback"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findByEeVersion", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.eeVersion = :eeVersion")})
public class EmployeeEvaluatorRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EE_ID")
    private Long eeId;
    @Column(name = "EE_RELATION_TYPE")
    private String eeRelationType;
    @Column(name = "EE_FEEDBACK")
    private String eeFeedback;
    @Basic(optional = false)
    @Column(name = "EE_VERSION")
    private Long eeVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eesEeId")
    private List<EESkillRelation> eESkillRelationList;
    @JoinColumn(name = "EE_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false)
    private Employee eeEmpId;
    @JoinColumn(name = "EVA_EMPLOYEE_ID", referencedColumnName = "EER_ID")
    @ManyToOne(optional = false)
    private EmployeeEvaluationRelation evaEmployeeId;

    public EmployeeEvaluatorRelation() {
    }

    public EmployeeEvaluatorRelation(Long eeId) {
        this.eeId = eeId;
    }

    public EmployeeEvaluatorRelation(Long eeId, Long eeVersion) {
        this.eeId = eeId;
        this.eeVersion = eeVersion;
    }

    public Long getEeId() {
        return eeId;
    }

    public void setEeId(Long eeId) {
        this.eeId = eeId;
    }

    public String getEeRelationType() {
        return eeRelationType;
    }

    public void setEeRelationType(String eeRelationType) {
        this.eeRelationType = eeRelationType;
    }

    public String getEeFeedback() {
        return eeFeedback;
    }

    public void setEeFeedback(String eeFeedback) {
        this.eeFeedback = eeFeedback;
    }

    public Long getEeVersion() {
        return eeVersion;
    }

    public void setEeVersion(Long eeVersion) {
        this.eeVersion = eeVersion;
    }

    public List<EESkillRelation> getEESkillRelationList() {
        return eESkillRelationList;
    }

    public void setEESkillRelationList(List<EESkillRelation> eESkillRelationList) {
        this.eESkillRelationList = eESkillRelationList;
    }

    public Employee getEeEmpId() {
        return eeEmpId;
    }

    public void setEeEmpId(Employee eeEmpId) {
        this.eeEmpId = eeEmpId;
    }

    public EmployeeEvaluationRelation getEvaEmployeeId() {
        return evaEmployeeId;
    }

    public void setEvaEmployeeId(EmployeeEvaluationRelation evaEmployeeId) {
        this.evaEmployeeId = evaEmployeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eeId != null ? eeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeEvaluatorRelation)) {
            return false;
        }
        EmployeeEvaluatorRelation other = (EmployeeEvaluatorRelation) object;
        if ((this.eeId == null && other.eeId != null) || (this.eeId != null && !this.eeId.equals(other.eeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EmployeeEvaluatorRelation[ eeId=" + eeId + " ]";
    }
    
}
