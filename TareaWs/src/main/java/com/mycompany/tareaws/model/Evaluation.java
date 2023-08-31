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
    @NamedQuery(name = "Evaluation.findByid", query = "SELECT e FROM Evaluation e WHERE e.id = :id"),
    @NamedQuery(name = "Evaluation.findBytitle", query = "SELECT e FROM Evaluation e WHERE e.title = :title"),
    @NamedQuery(name = "Evaluation.findBystartDate", query = "SELECT e FROM Evaluation e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Evaluation.findByfinalDate", query = "SELECT e FROM Evaluation e WHERE e.finalDate = :finalDate"),
    @NamedQuery(name = "Evaluation.findBystate", query = "SELECT e FROM Evaluation e WHERE e.state = :state"),
    @NamedQuery(name = "Evaluation.findByversion", query = "SELECT e FROM Evaluation e WHERE e.version = :version")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EVA_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "EVA_TITLE")
    private String title;
    @Column(name = "EVA_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EVA_FINAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;
    @Basic(optional = false)
    @Column(name = "EVA_STATE")
    private String state;
    @Version
    @Column(name = "EVA_VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejrid")
    private List<EvaluationJobRelation> evaluationJobRelationList;
    @JoinColumn(name = "EVA_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne(optional = false)
    private Company company;

    public Evaluation() {
    }

    public Evaluation(Long id) {
        this.id = id;
    }

    public Evaluation(Long id, String title, String state, Long version) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.version = version;
    }

    public Evaluation(EvaluationDto evaluation) {
        this.id = evaluation.getId();
        updateEvaluation(evaluation);
    }

    public void updateEvaluation(EvaluationDto evaluation) {
        this.id = evaluation.getId();
        this.title = evaluation.getTitle();
        this.startDate = evaluation.getStartDate();
        this.finalDate = evaluation.getFinalDate();
        this.state = evaluation.getState();
        this.company.updateCompany(evaluation.getCompany());
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public Date getstartDate() {
        return startDate;
    }

    public void setstartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getfinalDate() {
        return finalDate;
    }

    public void setfinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public Long getversion() {
        return version;
    }

    public void setversion(Long version) {
        this.version = version;
    }

    public List<EvaluationJobRelation> getEvaluationJobRelationList() {
        return evaluationJobRelationList;
    }

    public void setEvaluationJobRelationList(List<EvaluationJobRelation> evaluationJobRelationList) {
        this.evaluationJobRelationList = evaluationJobRelationList;
    }

    public Company getcompany() {
        return company;
    }

    public void setcompany(Company company) {
        this.company = company;
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
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Evaluation[ id=" + id + " ]";
    }

}
