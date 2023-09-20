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
@Table(name = "EMPLOYEE_EVALUATION_RELATION")
@NamedQueries({
    @NamedQuery(name = "EmployeeEvaluationRelation.findAll", query = "SELECT e FROM EmployeeEvaluationRelation e"),
    @NamedQuery(name = "EmployeeEvaluationRelation.findById", query = "SELECT e FROM EmployeeEvaluationRelation e WHERE e.id = :id"),
    @NamedQuery(name = "EmployeeEvaluationRelation.findByEmployeeClasification", query = "SELECT e FROM EmployeeEvaluationRelation e WHERE e.employeeClasification = :employeeClasification"),
    @NamedQuery(name = "EmployeeEvaluationRelation.findByVersion", query = "SELECT e FROM EmployeeEvaluationRelation e WHERE e.version = :version")})
public class EmployeeEvaluationRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "EMPLOYEE_EVALUATION_RELATION_EER_ID_GENERATOR", sequenceName = "tarea.EMPLOYEE_EVALUATION_RELATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_EVALUATION_RELATION_EER_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "EER_ID")
    private Long id;
    @Column(name = "EER_EMPLOYEE_CLASIFICATION")
    private Long employeeClasification;
    @Version
    @Column(name = "EER_VERSION")
    private Long version;
    @JoinColumn(name = "EER_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false)
    private Employee employeeEvaluated;
    @JoinColumn(name = "EER_EJR_ID", referencedColumnName = "EJR_ID")
    @ManyToOne
    private EvaluationJobRelation evaluationJobRelation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEvaluationRelation")
    private List<EmployeeAverageSkill> employeeAverageSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEvaluated")
    private List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList;

    public EmployeeEvaluationRelation() {
    }

    public EmployeeEvaluationRelation(Long id) {
        this.id = id;
    }

    public EmployeeEvaluationRelation(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public EmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelationDto) {
        updateEmployeeEvaluationRelation(employeeEvaluationRelationDto);
    }

    public void updateEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelationDto) {
        this.id = employeeEvaluationRelationDto.getId();
        this.employeeClasification = employeeEvaluationRelationDto.getEmployeeClasification();
        this.employeeEvaluated.updateEmployee(employeeEvaluationRelationDto.getEmployeeEvaluated());
        this.evaluationJobRelation.updateEvaluationJobRelation(employeeEvaluationRelationDto.getEvaluationJobRelation());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeClasification() {
        return employeeClasification;
    }

    public void setEmployeeClasification(Long employeeClasification) {
        this.employeeClasification = employeeClasification;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Employee getEmployeeEvaluated() {
        return employeeEvaluated;
    }

    public void setEmployeeEvaluated(Employee employeeEvaluated) {
        this.employeeEvaluated = employeeEvaluated;
    }

    public EvaluationJobRelation getEvaluationJobRelation() {
        return evaluationJobRelation;
    }

    public void setEvaluationJobRelation(EvaluationJobRelation evaluationJobRelation) {
        this.evaluationJobRelation = evaluationJobRelation;
    }

    public List<EmployeeAverageSkill> getEmployeeAverageSkillList() {
        return employeeAverageSkillList;
    }

    public void setEmployeeAverageSkillList(List<EmployeeAverageSkill> employeeAverageSkillList) {
        this.employeeAverageSkillList = employeeAverageSkillList;
    }

    public List<EmployeeEvaluatorRelation> getEmployeeEvaluatorRelationList() {
        return employeeEvaluatorRelationList;
    }

    public void setEmployeeEvaluatorRelationList(List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList) {
        this.employeeEvaluatorRelationList = employeeEvaluatorRelationList;
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
        if (!(object instanceof EmployeeEvaluationRelation)) {
            return false;
        }
        EmployeeEvaluationRelation other = (EmployeeEvaluationRelation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EmployeeEvaluationRelation[ id=" + id + " ]";
    }

}
