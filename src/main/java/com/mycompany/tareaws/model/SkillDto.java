/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class SkillDto {

    private Long id;
    private String name;
    private String description;
    private String state;
    private CompanyDto company;
    private List<JobDto> jobList;  
    private List<EESkillRelationDto> skillsEvaluatedList;
    private List<EmployeeAverageSkillDto> employeeAverageSkillList;
    private boolean modificate;
    
    public SkillDto() {
        modificate = false;
        company = new CompanyDto();
        jobList= new ArrayList<>();
        skillsEvaluatedList= new ArrayList<>();
        employeeAverageSkillList= new ArrayList<>();
    }

    public SkillDto(Skill skill) {
        this();
        this.id = skill.getId();
        this.name = skill.getName();
        this.description = skill.getDescription();
        this.state = skill.getState();
    }
    public void setForeignAtributes(Skill skill){
        company = new CompanyDto(skill.getCompany());
        setJobList(skill.getJobList());
        setSkillsEvaluatedList(skill.getSkillsEvaluatedList());
        setEmployeeAverageSkillList(skill.getEmployeeAverageSkillList());
    }

    public List<JobDto> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        for (Job job : jobList){
            this.jobList.add(new JobDto(job));
        }
    }

    public List<EESkillRelationDto> getSkillsEvaluatedList() {
        return skillsEvaluatedList;
    }

    public void setSkillsEvaluatedList(List<EESkillRelation> skillsEvaluatedList) {
        for (EESkillRelation eeSkillRelation : skillsEvaluatedList){
            this.skillsEvaluatedList.add(new EESkillRelationDto(eeSkillRelation));
        }
    }

    public List<EmployeeAverageSkillDto> getEmployeeAverageSkillList() {
        return employeeAverageSkillList;
    }

    public void setEmployeeAverageSkillList(List<EmployeeAverageSkill> employeeAverageSkillList) {
        for (EmployeeAverageSkill employeeAverageSkill : employeeAverageSkillList){
            this.employeeAverageSkillList.add(new EmployeeAverageSkillDto(employeeAverageSkill));
        }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "SkillDto{" + "id=" + id + ", name=" + name + ", description=" + description + ", state=" + state + ", company=" + company + ", modificate=" + modificate + '}';
    }

}
