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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EMPLOYEE_EVALUATOR_RELATION")
@NamedQueries({
    @NamedQuery(name = "EmployeeEvaluatorRelation.findAll", query = "SELECT e FROM EmployeeEvaluatorRelation e"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findById", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.id = :id"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findByEmployeeEvaluatorRelationType", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.employeeEvaluatorRelationType = :employeeEvaluatorRelationType"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findByFeedback", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.feedback = :feedback"),
    @NamedQuery(name = "EmployeeEvaluatorRelation.findByVersion", query = "SELECT e FROM EmployeeEvaluatorRelation e WHERE e.version = :version")})
public class EmployeeEvaluatorRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "EMPLOYEE_EVALUATOR_RELATION_EE_ID_GENERATOR", sequenceName = "tarea.EMPLOYEE_EVALUATOR_RELATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_EVALUATOR_RELATION_EE_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "EE_ID")
    private Long id;
    @Column(name = "EE_RELATION_TYPE")
    private String employeeEvaluatorRelationType;
    @Column(name = "EE_FEEDBACK")
    private String feedback;
    @Version
    @Column(name = "EE_VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEvaluatorRelation")
    private List<EESkillRelation> skillsEvaluatedList;
    @JoinColumn(name = "EE_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false)
    private Employee employeeEvaluator;
    @JoinColumn(name = "EVA_EMPLOYEE_ID", referencedColumnName = "EER_ID")
    @ManyToOne(optional = false)
    private EmployeeEvaluationRelation employeeEvaluated;

    public EmployeeEvaluatorRelation() {
    }

    public EmployeeEvaluatorRelation(Long id) {
        this.id = id;
    }

    public EmployeeEvaluatorRelation(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public EmployeeEvaluatorRelation(Long id, String employeeEvaluatorRelationType, String feedback, Long version, List<EESkillRelation> skillsEvaluatedList, Employee employeeEvaluator, EmployeeEvaluationRelation employeeEvaluated) {
        this.id = id;
        this.employeeEvaluatorRelationType = employeeEvaluatorRelationType;
        this.feedback = feedback;
        this.version = version;
        this.skillsEvaluatedList = skillsEvaluatedList;
        this.employeeEvaluator = employeeEvaluator;
        this.employeeEvaluated = employeeEvaluated;
    }

    public EmployeeEvaluatorRelation(EmployeeEvaluatorRelationDto employeeEvaluatorRelationDto) {
        this.id = employeeEvaluatorRelationDto.getId();
        updateEmployeeEvaluatorRelation(employeeEvaluatorRelationDto);
    }

    public void updateEmployeeEvaluatorRelation(EmployeeEvaluatorRelationDto employeeEvaluatorRelationDto) {
        this.employeeEvaluatorRelationType = employeeEvaluatorRelationDto.getEmployeeEvaluatorRelationType();
        this.feedback = employeeEvaluatorRelationDto.getFeedback();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeEvaluatorRelationType() {
        return employeeEvaluatorRelationType;
    }

    public void setEmployeeEvaluatorRelationType(String employeeEvaluatorRelationType) {
        this.employeeEvaluatorRelationType = employeeEvaluatorRelationType;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<EESkillRelation> getSkillsEvaluatedList() {
        return skillsEvaluatedList;
    }

    public void setSkillsEvaluatedList(List<EESkillRelation> skillsEvaluatedList) {
        this.skillsEvaluatedList = skillsEvaluatedList;
    }

    public Employee getEmployeeEvaluator() {
        return employeeEvaluator;
    }

    public void setEmployeeEvaluator(Employee employeeEvaluator) {
        this.employeeEvaluator = employeeEvaluator;
    }

    public EmployeeEvaluationRelation getEmployeeEvaluated() {
        return employeeEvaluated;
    }

    public void setEmployeeEvaluated(EmployeeEvaluationRelation employeeEvaluated) {
        this.employeeEvaluated = employeeEvaluated;
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
        if (!(object instanceof EmployeeEvaluatorRelation)) {
            return false;
        }
        EmployeeEvaluatorRelation other = (EmployeeEvaluatorRelation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EmployeeEvaluatorRelation[ id=" + id + " ]";
    }

}
