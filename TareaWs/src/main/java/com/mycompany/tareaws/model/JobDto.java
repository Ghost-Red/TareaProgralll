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
    private CompanyDto jobComId;
    private boolean modificate;

    public JobDto() {
        modificate = false;
    }
    
    public JobDto (Job job){
        this();
        this.jobId = job.getJobId();
        this.jobName = job.getJobName();
        this.jobState = job.getJobState();
        this.jobComId = new CompanyDto(job.getJobComId());
    }
    
    public void updateJobDto(Job job){
        this.jobId = job.getJobId();
        this.jobName = job.getJobName();
        this.jobState = job.getJobState();
        this.jobComId.updateCompanyDto(job.getJobComId());
        
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

    public CompanyDto getJobComId() {
        return jobComId;
    }

    public void setJobComId(CompanyDto jobComId) {
        this.jobComId = jobComId;
    }

    @Override
    public String toString() {
        return "JobDto{" + "jobId=" + jobId + ", jobName=" + jobName + ", jobState=" + jobState + ", jobComId=" + jobComId + ", modificate=" + modificate + '}';
    }
    
}
