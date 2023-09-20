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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "JOB")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findById", query = "SELECT j FROM Job j WHERE j.id = :id"),
    @NamedQuery(name = "Job.findByName", query = "SELECT j FROM Job j WHERE j.name = :name"),
    @NamedQuery(name = "Job.findByState", query = "SELECT j FROM Job j WHERE j.state = :state"),
    @NamedQuery(name = "Job.findByVersion", query = "SELECT j FROM Job j WHERE j.version = :version")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "JOB_JOB_ID_GENERATOR", sequenceName = "tarea.JOB_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_JOB_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "JOB_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "JOB_NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "JOB_STATE")
    private String state;
    @Version
    @Column(name = "JOB_VERSION")
    private Long version;
    @JoinTable(name = "JOB_SKILL_RELATION", joinColumns = {
        @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SKILL_ID", referencedColumnName = "SKILL_ID")})
    @ManyToMany
    private List<Skill> skillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<EvaluationJobRelation> evaluationJobRelationList;
    @OneToMany(mappedBy = "job")
    private List<Employee> employeeList;
    @JoinColumn(name = "JOB_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne
    private Company company;

    public Job() {
    }

    public Job(Long id) {
        this.id = id;
    }

    public Job(Long id, String name, String state, Long version) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.version = version;
    }

    public Job(JobDto jobDto) {
        this.id = jobDto.getId();
        updateJob(jobDto);
    }

    public void updateJob(JobDto jobDto) {
        this.id = jobDto.getId();
        this.name = jobDto.getName();
        this.state = jobDto.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<EvaluationJobRelation> getEvaluationJobRelationList() {
        return evaluationJobRelationList;
    }

    public void setEvaluationJobRelationList(List<EvaluationJobRelation> evaluationJobRelationList) {
        this.evaluationJobRelationList = evaluationJobRelationList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Job[ id=" + id + " ]";
    }

}
