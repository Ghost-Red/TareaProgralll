/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.ArrayList;
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
    private List<SkillDto> skillList;
    private List<EvaluationJobRelationDto> evaluationJobRelationList;
    private List<EmployeeDto> employeeList;
    public JobDto() {
        modificate = false;
        skillList= new ArrayList<>();
        evaluationJobRelationList= new ArrayList<>();
        employeeList= new ArrayList<>();
    }

    public JobDto(Job job) {
        this();
        this.id = job.getId();
        this.name = job.getName();
        this.state = job.getState();
    }
    public void setForeignAtributes(Job job){
        setSkillList(job.getSkillList());
        setEvaluationJobRelationList(job.getEvaluationJobRelationList());
        setEmployeeList(job.getEmployeeList());
    }

    public List<SkillDto> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        for (Skill skill : skillList){
            this.skillList.add(new SkillDto(skill));
        }
    }

    public List<EvaluationJobRelationDto> getEvaluationJobRelationList() {
        return evaluationJobRelationList;
    }

    public void setEvaluationJobRelationList(List<EvaluationJobRelation> evaluationJobRelationList) {
        for (EvaluationJobRelation evaluationJobRelation : evaluationJobRelationList){
            this.evaluationJobRelationList.add(new EvaluationJobRelationDto(evaluationJobRelation));
        }
    }

    public List<EmployeeDto> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList){
            this.employeeList.add(new EmployeeDto(employee));
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
        return "JobDto{" + "id=" + id + ", name=" + name + ", state=" + state + ", company=" + company + ", modificate=" + modificate + '}';
    }

}
