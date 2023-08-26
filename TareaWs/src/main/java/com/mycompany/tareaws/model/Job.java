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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "JOB")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByJobId", query = "SELECT j FROM Job j WHERE j.jobId = :jobId"),
    @NamedQuery(name = "Job.findByJobName", query = "SELECT j FROM Job j WHERE j.jobName = :jobName"),
    @NamedQuery(name = "Job.findByJobState", query = "SELECT j FROM Job j WHERE j.jobState = :jobState"),
    @NamedQuery(name = "Job.findByJobVersion", query = "SELECT j FROM Job j WHERE j.jobVersion = :jobVersion")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "JOB_ID")
    private Long jobId;
    @Basic(optional = false)
    @Column(name = "JOB_NAME")
    private String jobName;
    @Basic(optional = false)
    @Column(name = "JOB_STATE")
    private String jobState;
    @Version
    @Column(name = "JOB_VERSION")
    private Long jobVersion;
    @JoinTable(name = "JOB_SKILL_RELATION", joinColumns = {
        @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SKILL_ID", referencedColumnName = "SKILL_ID")})
    @ManyToMany
    private List<Skill> skillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejrJobId")
    private List<EvaluationJobRelation> evaluationJobRelationList;
    @OneToMany(mappedBy = "empJobId")
    private List<Employee> employeeList;
    @JoinColumn(name = "JOB_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne
    private Company jobComId;

    public Job() {
    }

    public Job(Long jobId) {
        this.jobId = jobId;
    }

    public Job(Long jobId, String jobName, String jobState, Long jobVersion) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobState = jobState;
        this.jobVersion = jobVersion;
    }
    public Job(JobDto jobDto) {
        this.jobId = jobDto.getJobId();
        updateJob(jobDto);
    }
    public void updateJob(JobDto jobDto){
        this.jobId = jobDto.getJobId();
        this.jobName = jobDto.getJobName();
        this.jobState = jobDto.getJobState();
        this.jobVersion = jobDto.getJobVersion();
    }
    
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public Long getJobVersion() {
        return jobVersion;
    }

    public void setJobVersion(Long jobVersion) {
        this.jobVersion = jobVersion;
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

    public Company getJobComId() {
        return jobComId;
    }

    public void setJobComId(Company jobComId) {
        this.jobComId = jobComId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Job[ jobId=" + jobId + " ]";
    }
    
}
