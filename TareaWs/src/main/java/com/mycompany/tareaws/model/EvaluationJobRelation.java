/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
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
@Table(name = "EVALUATION_JOB_RELATION")
@NamedQueries({
    @NamedQuery(name = "EvaluationJobRelation.findAll", query = "SELECT e FROM EvaluationJobRelation e"),
    @NamedQuery(name = "EvaluationJobRelation.findByEjrId", query = "SELECT e FROM EvaluationJobRelation e WHERE e.ejrId = :ejrId")})
public class EvaluationJobRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EJR_ID")
    private Long ejrId;
    @JoinColumn(name = "EVA_ID", referencedColumnName = "EVA_ID")
    @ManyToOne(optional = false)
    private Evaluation evaId;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne(optional = false)
    private Job jobId;
    @OneToMany(mappedBy = "eerEjrId")
    private List<EmployeeEvaluationRelation> employeeEvaluationRelationList;

    public EvaluationJobRelation() {
    }

    public EvaluationJobRelation(Long ejrId) {
        this.ejrId = ejrId;
    }

    public Long getEjrId() {
        return ejrId;
    }

    public void setEjrId(Long ejrId) {
        this.ejrId = ejrId;
    }

    public Evaluation getEvaId() {
        return evaId;
    }

    public void setEvaId(Evaluation evaId) {
        this.evaId = evaId;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public List<EmployeeEvaluationRelation> getEmployeeEvaluationRelationList() {
        return employeeEvaluationRelationList;
    }

    public void setEmployeeEvaluationRelationList(List<EmployeeEvaluationRelation> employeeEvaluationRelationList) {
        this.employeeEvaluationRelationList = employeeEvaluationRelationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejrId != null ? ejrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationJobRelation)) {
            return false;
        }
        EvaluationJobRelation other = (EvaluationJobRelation) object;
        if ((this.ejrId == null && other.ejrId != null) || (this.ejrId != null && !this.ejrId.equals(other.ejrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EvaluationJobRelation[ ejrId=" + ejrId + " ]";
    }
    
}
