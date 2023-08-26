/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.List;

/**
 *
 * @author Progralll
 */
public class JobDto {
    private Long jobId;
    private String jobName;
    private String jobState;
    private Long jobVersion;
    private List<Skill> skillList;
    private List<EvaluationJobRelation> evaluationJobRelationList;
    private List<Employee> employeeList;
    private Company jobComId;
    private boolean modificate;

    public JobDto() {
        modificate = false;
    }
    
    public JobDto (Job job){
        this();
        this.jobId = job.getJobId();
        this.jobName = job.getJobName();
        this.jobState = job.getJobState();
        this.jobVersion = job.getJobVersion();
    }
    public void updateJobDto(Job job){
        this.jobId = job.getJobId();
        this.jobName = job.getJobName();
        this.jobState = job.getJobState();
        this.jobVersion = job.getJobVersion();
        
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
    public String toString() {
        return "JobDto{" + "jobId=" + jobId + ", jobName=" + jobName + ", jobState=" + jobState + ", jobVersion=" + jobVersion + ", skillList=" + skillList + ", evaluationJobRelationList=" + evaluationJobRelationList + ", employeeList=" + employeeList + ", jobComId=" + jobComId + ", modificate=" + modificate + '}';
    }
}
