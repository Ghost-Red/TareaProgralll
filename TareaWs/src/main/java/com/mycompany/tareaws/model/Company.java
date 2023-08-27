/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.io.Serializable;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "COMPANY")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByComId", query = "SELECT c FROM Company c WHERE c.comId = :comId"),
    @NamedQuery(name = "Company.findByComName", query = "SELECT c FROM Company c WHERE c.comName = :comName"),
    @NamedQuery(name = "Company.findByComEmail", query = "SELECT c FROM Company c WHERE c.comEmail = :comEmail"),
    @NamedQuery(name = "Company.findByComTokenEmail", query = "SELECT c FROM Company c WHERE c.comTokenEmail = :comTokenEmail"),
    @NamedQuery(name = "Company.findByComVersion", query = "SELECT c FROM Company c WHERE c.comVersion = :comVersion")})
public class Company implements Serializable{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COM_ID")
    private Long comId;
    @Basic(optional = false)
    @Column(name = "COM_NAME")
    private String comName;
    @Basic(optional = false)
    @Column(name = "COM_EMAIL")
    private String comEmail;
    @Basic(optional = false)
    @Lob
    @Column(name = "COM_LOGO")
    private Byte[] comLogo;
    @Basic(optional = false)
    @Lob
    @Column(name = "COM_EMAIL_TEMPLATE_PASSWORD")
    private Byte[] comEmailTemplatePassword;
    @Basic(optional = false)
    @Column(name = "COM_TOKEN_EMAIL")
    private String comTokenEmail;
    @Version
    @Column(name = "COM_VERSION")
    private Long comVersion;
    @Basic(optional = false)
    @Lob
    @Column(name = "COM_EMAIL_TEMPLATE_ACTIVATE_USER")
    private Byte[] comEmailTemplateActivateUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillComId")
    private List<Skill> skillList;
    @OneToMany(mappedBy = "empComId")
    private List<Employee> employeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaComId")
    private List<Evaluation> evaluationList;
    @OneToMany(mappedBy = "jobComId")
    private List<Job> jobList;

    public Company() {
    }

    public Company(Long comId) {
        this.comId = comId;
    }

    public Company(Long comId, String comName, String comEmail, Byte[] comLogo, Byte[] comEmailTemplatePassword, String comTokenEmail, Long comVersion, Byte[] comEmailTemplateActivateUser) {
        this.comId = comId;
        this.comName = comName;
        this.comEmail = comEmail;
        this.comLogo = comLogo;
        this.comEmailTemplatePassword = comEmailTemplatePassword;
        this.comTokenEmail = comTokenEmail;
        this.comVersion = comVersion;
        this.comEmailTemplateActivateUser = comEmailTemplateActivateUser;
    }
    
    public Company(CompanyDto company) {
        this.comId = company.getComId();
        updateCompany(company);
    }
    
    public void updateCompany(CompanyDto companyDto) {
        this.comId = companyDto.getComId();
        this.comName = companyDto.getComName();
        this.comEmail = companyDto.getComEmail();
        this.comLogo = companyDto.getComLogo();
        this.comEmailTemplatePassword = companyDto.getComEmailTemplatePassword();
        this.comTokenEmail = companyDto.getComTokenEmail();
        this.comVersion = companyDto.getComVersion();
        this.comEmailTemplateActivateUser = companyDto.getComEmailTemplateActivateUser();
    }
    
    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public Byte[] getComLogo() {
        return comLogo;
    }

    public void setComLogo(Byte[] comLogo) {
        this.comLogo = comLogo;
    }

    public Byte[] getComEmailTemplatePassword() {
        return comEmailTemplatePassword;
    }

    public void setComEmailTemplatePassword(Byte[] comEmailTemplatePassword) {
        this.comEmailTemplatePassword = comEmailTemplatePassword;
    }

    public String getComTokenEmail() {
        return comTokenEmail;
    }

    public void setComTokenEmail(String comTokenEmail) {
        this.comTokenEmail = comTokenEmail;
    }

    public Long getComVersion() {
        return comVersion;
    }

    public void setComVersion(Long comVersion) {
        this.comVersion = comVersion;
    }

    public Byte[] getComEmailTemplateActivateUser() {
        return comEmailTemplateActivateUser;
    }

    public void setComEmailTemplateActivateUser(Byte[] comEmailTemplateActivateUser) {
        this.comEmailTemplateActivateUser = comEmailTemplateActivateUser;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Company[ comId=" + comId + " ]";
    }
    
}
