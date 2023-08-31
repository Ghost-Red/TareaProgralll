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
import jakarta.persistence.Version;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EVALUATION_JOB_RELATION")
@NamedQueries({
    @NamedQuery(name = "EvaluationJobRelation.findAll", query = "SELECT e FROM EvaluationJobRelation e"),
    @NamedQuery(name = "EvaluationJobRelation.findByid", query = "SELECT e FROM EvaluationJobRelation e WHERE e.id = :id"),
    @NamedQuery(name = "EvaluationJobRelation.findByversion", query = "SELECT e FROM EvaluationJobRelation e WHERE e.version = :version")})
public class EvaluationJobRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EJR_ID")
    private Long id;
    @Version
    @Column(name = "EJR_VERSION")
    private Long version;
    @JoinColumn(name = "EJR_EVA_ID", referencedColumnName = "EVA_ID")
    @ManyToOne(optional = false)
    private Evaluation evaluation;
    @JoinColumn(name = "EJR_JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne(optional = false)
    private Job job;
    @OneToMany(mappedBy = "evaluationJobRelation")
    private List<EmployeeEvaluationRelation> employeeEvaluationRelationList;

    public EvaluationJobRelation() {
    }

    public EvaluationJobRelation(Long id) {
        this.id = id;
    }

    public EvaluationJobRelation(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public EvaluationJobRelation(EvaluationJobRelationDto evaluationJobRelationDto) {
        updateEvaluationJobRelation(evaluationJobRelationDto);
    }

    public void updateEvaluationJobRelation(EvaluationJobRelationDto evaluationJobRelationDto) {
        this.id = evaluationJobRelationDto.getId();
        this.evaluation.updateEvaluation(evaluationJobRelationDto.getEvaluation());
        this.job.updateJob(evaluationJobRelationDto.getJob());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationJobRelation)) {
            return false;
        }
        EvaluationJobRelation other = (EvaluationJobRelation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EvaluationJobRelation[ id=" + id + " ]";
    }

}
