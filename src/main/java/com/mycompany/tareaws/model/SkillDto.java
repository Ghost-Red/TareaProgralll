/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import jakarta.xml.bind.annotation.XmlElement;
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
    private boolean modificate;

    private List<JobDto> jobList;
    private List<EESkillRelationDto> skillsEvaluatedList;
    private List<EmployeeAverageSkillDto> employeeAverageSkillList;

    public SkillDto() {
        modificate = false;
        company = new CompanyDto();
        jobList = new ArrayList<>();
        skillsEvaluatedList = new ArrayList<>();
        employeeAverageSkillList = new ArrayList<>();
    }

    public SkillDto(Skill skill) {
        this();
        if (skill != null) {
            this.id = skill.getId();
            this.name = skill.getName();
            this.description = skill.getDescription();
            this.state = skill.getState();
        } else {
            company = null;
        }
    }

    public void setForeignAtributes(Skill skill) {
        company = new CompanyDto(skill.getCompany());
        setJobList(skill.getJobList());
        setSkillsEvaluatedList(skill.getSkillsEvaluatedList());
        setEmployeeAverageSkillList(skill.getEmployeeAverageSkillList());
    }

    @XmlElement(name = "jobList")
    public List<JobDto> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        for (Job job : jobList) {
            this.jobList.add(new JobDto(job));
        }
    }

    @XmlElement(name = "skillsEvaluatedList")
    public List<EESkillRelationDto> getSkillsEvaluatedList() {
        return skillsEvaluatedList;
    }

    public void setSkillsEvaluatedList(List<EESkillRelation> skillsEvaluatedList) {
        for (EESkillRelation eeSkillRelation : skillsEvaluatedList) {
            this.skillsEvaluatedList.add(new EESkillRelationDto(eeSkillRelation));
        }
    }

    @XmlElement(name = "employeeAverageSkillList")
    public List<EmployeeAverageSkillDto> getEmployeeAverageSkillList() {
        return employeeAverageSkillList;
    }

    public void setEmployeeAverageSkillList(List<EmployeeAverageSkill> employeeAverageSkillList) {
        for (EmployeeAverageSkill employeeAverageSkill : employeeAverageSkillList) {
            this.employeeAverageSkillList.add(new EmployeeAverageSkillDto(employeeAverageSkill));
        }
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlElement(name = "company")
    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    @XmlElement(name = "modificate")
    public boolean isModificate() {
        return modificate;
    }

    public void setModificate(boolean modificate) {
        this.modificate = modificate;
    }

    @Override
    public String toString() {
        return "SkillDto{" + "id=" + id + ", name=" + name + ", description=" + description + ", state=" + state + ", company=" + company + ", modificate=" + modificate + '}';
    }
}
