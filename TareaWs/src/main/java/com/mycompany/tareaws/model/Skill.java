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
@Table(name = "SKILL")
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s"),
    @NamedQuery(name = "Skill.findByid", query = "SELECT s FROM Skill s WHERE s.id = :id"),
    @NamedQuery(name = "Skill.findByversion", query = "SELECT s FROM Skill s WHERE s.version = :version"),
    @NamedQuery(name = "Skill.findByname", query = "SELECT s FROM Skill s WHERE s.name = :name"),
    @NamedQuery(name = "Skill.findBydescription", query = "SELECT s FROM Skill s WHERE s.description = :description"),
    @NamedQuery(name = "Skill.findBystate", query = "SELECT s FROM Skill s WHERE s.state = :state")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SKILL_ID")
    private Long id;
    @Version
    @Column(name = "SKILL_VERSION")
    private Long version;
    @Column(name = "SKILL_NAME")
    private String name;
    @Column(name = "SKILL_DESCRIPTION")
    private String description;
    @Column(name = "SKILL_STATE")
    private String state;
    @ManyToMany(mappedBy = "skillList")
    private List<Job> jobList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluatedSkill")
    private List<EESkillRelation> skillsEvaluatedList;
    @JoinColumn(name = "SKILL_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne(optional = false)
    private Company company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    private List<EmployeeAverageSkill> employeeAverageSkillList;

    public Skill() {
    }

    public Skill(Long id) {
        this.id = id;
    }

    public Skill(Long id, Long version, String name, String description, String state) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public Skill(SkillDto skill) {
        this.id = skill.getId();
        updateSkill(skill);
    }

    public void updateSkill(SkillDto skill) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<EESkillRelation> getSkillsEvaluatedList() {
        return skillsEvaluatedList;
    }

    public void setSkillsEvaluatedList(List<EESkillRelation> skillsEvaluatedList) {
        this.skillsEvaluatedList = skillsEvaluatedList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<EmployeeAverageSkill> getEmployeeAverageSkillList() {
        return employeeAverageSkillList;
    }

    public void setEmployeeAverageSkillList(List<EmployeeAverageSkill> employeeAverageSkillList) {
        this.employeeAverageSkillList = employeeAverageSkillList;
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
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Skill[ id=" + id + " ]";
    }

}
