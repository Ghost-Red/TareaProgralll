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
import jakarta.persistence.Version;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EMPLOYEE_EVALUATION_RELATION")
@NamedQueries({
    @NamedQuery(name = "EmployeeEvaluationRelation.findAll", query = "SELECT e FROM EmployeeEvaluationRelation e"),
    @NamedQuery(name = "EmployeeEvaluationRelation.findByEerId", query = "SELECT e FROM EmployeeEvaluationRelation e WHERE e.eerId = :eerId"),
    @NamedQuery(name = "EmployeeEvaluationRelation.findByEerEmployeeClasification", query = "SELECT e FROM EmployeeEvaluationRelation e WHERE e.eerEmployeeClasification = :eerEmployeeClasification"),
    @NamedQuery(name = "EmployeeEvaluationRelation.findByEerVersion", query = "SELECT e FROM EmployeeEvaluationRelation e WHERE e.eerVersion = :eerVersion")})
public class EmployeeEvaluationRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EER_ID")
    private Long eerId;
    @Column(name = "EER_EMPLOYEE_CLASIFICATION")
    private Long eerEmployeeClasification;
    @Version
    @Column(name = "EER_VERSION")
    private Long eerVersion;
    @JoinColumn(name = "EER_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false)
    private Employee eerEmpId;
    @JoinColumn(name = "EER_EJR_ID", referencedColumnName = "EJR_ID")
    @ManyToOne
    private EvaluationJobRelation eerEjrId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "easEerId")
    private List<EmployeeAverageSkill> employeeAverageSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEmployeeId")
    private List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList;

    public EmployeeEvaluationRelation() {
    }

    public EmployeeEvaluationRelation(Long eerId) {
        this.eerId = eerId;
    }

    public EmployeeEvaluationRelation(Long eerId, Long eerVersion) {
        this.eerId = eerId;
        this.eerVersion = eerVersion;
    }

    public EmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelationDto) {
        updateEmployeeEvaluationRelation(employeeEvaluationRelationDto);
    }

    public void updateEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelationDto) {
        this.eerId = employeeEvaluationRelationDto.getId();
        this.eerEmployeeClasification = employeeEvaluationRelationDto.getEmployeeClasification();
        this.eerEmpId.updateEmployee(employeeEvaluationRelationDto.getEmployee());
        this.eerEjrId.updateEvaluationJobRelation(employeeEvaluationRelationDto.getEvaluationJobRelation());
    }

    public Long getEerId() {
        return eerId;
    }

    public void setEerId(Long eerId) {
        this.eerId = eerId;
    }

    public Long getEerEmployeeClasification() {
        return eerEmployeeClasification;
    }

    public void setEerEmployeeClasification(Long eerEmployeeClasification) {
        this.eerEmployeeClasification = eerEmployeeClasification;
    }

    public Long getEerVersion() {
        return eerVersion;
    }

    public void setEerVersion(Long eerVersion) {
        this.eerVersion = eerVersion;
    }

    public Employee getEerEmpId() {
        return eerEmpId;
    }

    public void setEerEmpId(Employee eerEmpId) {
        this.eerEmpId = eerEmpId;
    }

    public EvaluationJobRelation getEerEjrId() {
        return eerEjrId;
    }

    public void setEerEjrId(EvaluationJobRelation eerEjrId) {
        this.eerEjrId = eerEjrId;
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
        hash += (eerId != null ? eerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeEvaluationRelation)) {
            return false;
        }
        EmployeeEvaluationRelation other = (EmployeeEvaluationRelation) object;
        if ((this.eerId == null && other.eerId != null) || (this.eerId != null && !this.eerId.equals(other.eerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EmployeeEvaluationRelation[ eerId=" + eerId + " ]";
    }

}
