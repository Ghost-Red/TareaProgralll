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
    @NamedQuery(name = "Skill.findBySkillId", query = "SELECT s FROM Skill s WHERE s.skillId = :skillId"),
    @NamedQuery(name = "Skill.findBySkillVersion", query = "SELECT s FROM Skill s WHERE s.skillVersion = :skillVersion"),
    @NamedQuery(name = "Skill.findBySkillName", query = "SELECT s FROM Skill s WHERE s.skillName = :skillName"),
    @NamedQuery(name = "Skill.findBySkillDescription", query = "SELECT s FROM Skill s WHERE s.skillDescription = :skillDescription"),
    @NamedQuery(name = "Skill.findBySkillState", query = "SELECT s FROM Skill s WHERE s.skillState = :skillState")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SKILL_ID")
    private Long skillId;
    @Version
    @Column(name = "SKILL_VERSION")
    private Long skillVersion;
    @Column(name = "SKILL_NAME")
    private String skillName;
    @Column(name = "SKILL_DESCRIPTION")
    private String skillDescription;
    @Column(name = "SKILL_STATE")
    private String skillState;
    @ManyToMany(mappedBy = "skillList")
    private List<Job> jobList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eesSkillId")
    private List<EESkillRelation> eESkillRelationList;
    @JoinColumn(name = "SKILL_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne(optional = false)
    private Company skillComId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "easSkillId")
    private List<EmployeeAverageSkill> employeeAverageSkillList;

    public Skill() {
    }

    public Skill(Long skillId) {
        this.skillId = skillId;
    }

    public Skill(Long skillId, Long skillVersion, String skillName,String skillDescription,String skillState) {
        this.skillId = skillId;
        this.skillVersion = skillVersion;
        this.skillName=skillName;
        this.skillDescription=skillDescription;
        this.skillState=skillState;
    }
    
    public Skill(SkillDto skill){
        this.skillId=skill.getSkillId();
        updateSkill(skill);
    }
    
    public void updateSkill(SkillDto skill){
        this.skillId=skill.getSkillId();
        this.skillName=skill.getSkillName();
        this.skillDescription=skill.getSkillDescription();
        this.skillState=skill.getSkillState();
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public Long getSkillVersion() {
        return skillVersion;
    }

    public void setSkillVersion(Long skillVersion) {
        this.skillVersion = skillVersion;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillState() {
        return skillState;
    }

    public void setSkillState(String skillState) {
        this.skillState = skillState;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<EESkillRelation> getEESkillRelationList() {
        return eESkillRelationList;
    }

    public void setEESkillRelationList(List<EESkillRelation> eESkillRelationList) {
        this.eESkillRelationList = eESkillRelationList;
    }

    public Company getSkillComId() {
        return skillComId;
    }

    public void setSkillComId(Company skillComId) {
        this.skillComId = skillComId;
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
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Skill[ skillId=" + skillId + " ]";
    }
    
}
