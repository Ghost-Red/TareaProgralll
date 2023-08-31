/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

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

    public SkillDto() {
        modificate = false;
    }

    public SkillDto(Skill skill) {
        this();
        this.id = skill.getId();
        this.name = skill.getName();
        this.description = skill.getDescription();
        this.state = skill.getState();
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
