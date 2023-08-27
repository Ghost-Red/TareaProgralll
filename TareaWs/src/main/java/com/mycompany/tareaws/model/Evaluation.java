/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EVALUATION")
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByEvaId", query = "SELECT e FROM Evaluation e WHERE e.evaId = :evaId"),
    @NamedQuery(name = "Evaluation.findByEvaTitle", query = "SELECT e FROM Evaluation e WHERE e.evaTitle = :evaTitle"),
    @NamedQuery(name = "Evaluation.findByEvaStartDate", query = "SELECT e FROM Evaluation e WHERE e.evaStartDate = :evaStartDate"),
    @NamedQuery(name = "Evaluation.findByEvaFinalDate", query = "SELECT e FROM Evaluation e WHERE e.evaFinalDate = :evaFinalDate"),
    @NamedQuery(name = "Evaluation.findByEvaState", query = "SELECT e FROM Evaluation e WHERE e.evaState = :evaState"),
    @NamedQuery(name = "Evaluation.findByEvaVersion", query = "SELECT e FROM Evaluation e WHERE e.evaVersion = :evaVersion")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EVA_ID")
    private Long evaId;
    @Basic(optional = false)
    @Column(name = "EVA_TITLE")
    private String evaTitle;
    @Column(name = "EVA_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evaStartDate;
    @Column(name = "EVA_FINAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evaFinalDate;
    @Basic(optional = false)
    @Column(name = "EVA_STATE")
    private String evaState;
    @Version
    @Column(name = "EVA_VERSION")
    private Long evaVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejrEvaId")
    private List<EvaluationJobRelation> evaluationJobRelationList;
    @JoinColumn(name = "EVA_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne(optional = false)
    private Company evaComId;

    public Evaluation() {
    }

    public Evaluation(Long evaId) {
        this.evaId = evaId;
    }

    public Evaluation(Long evaId, String evaTitle, String evaState, Long evaVersion) {
        this.evaId = evaId;
        this.evaTitle = evaTitle;
        this.evaState = evaState;
        this.evaVersion = evaVersion;
    }

    public Long getEvaId() {
        return evaId;
    }

    public void setEvaId(Long evaId) {
        this.evaId = evaId;
    }

    public String getEvaTitle() {
        return evaTitle;
    }

    public void setEvaTitle(String evaTitle) {
        this.evaTitle = evaTitle;
    }

    public Date getEvaStartDate() {
        return evaStartDate;
    }

    public void setEvaStartDate(Date evaStartDate) {
        this.evaStartDate = evaStartDate;
    }

    public Date getEvaFinalDate() {
        return evaFinalDate;
    }

    public void setEvaFinalDate(Date evaFinalDate) {
        this.evaFinalDate = evaFinalDate;
    }

    public String getEvaState() {
        return evaState;
    }

    public void setEvaState(String evaState) {
        this.evaState = evaState;
    }

    public Long getEvaVersion() {
        return evaVersion;
    }

    public void setEvaVersion(Long evaVersion) {
        this.evaVersion = evaVersion;
    }

    public List<EvaluationJobRelation> getEvaluationJobRelationList() {
        return evaluationJobRelationList;
    }

    public void setEvaluationJobRelationList(List<EvaluationJobRelation> evaluationJobRelationList) {
        this.evaluationJobRelationList = evaluationJobRelationList;
    }

    public Company getEvaComId() {
        return evaComId;
    }

    public void setEvaComId(Company evaComId) {
        this.evaComId = evaComId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaId != null ? evaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evaId == null && other.evaId != null) || (this.evaId != null && !this.evaId.equals(other.evaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Evaluation[ evaId=" + evaId + " ]";
    }
    
}
