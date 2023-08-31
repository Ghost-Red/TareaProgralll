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

    private Long id;
    private String name;
    private String state;
    private CompanyDto company;
    private boolean modificate;

    public JobDto() {
        modificate = false;
    }

    public JobDto(Job job) {
        this();
        this.id = job.getJobId();
        this.name = job.getJobName();
        this.state = job.getJobState();
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

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "JobDto{" + "jobId=" + id + ", jobName=" + name + ", jobState=" + state + ", jobComId=" + company + ", modificate=" + modificate + '}';
    }

}
