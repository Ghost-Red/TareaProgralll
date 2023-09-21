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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
    @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findByEmail", query = "SELECT c FROM Company c WHERE c.email = :email"),
    @NamedQuery(name = "Company.findByTokenEmail", query = "SELECT c FROM Company c WHERE c.tokenEmail = :tokenEmail"),
    @NamedQuery(name = "Company.findByVersion", query = "SELECT c FROM Company c WHERE c.version = :version")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "COMPANY_COM_ID_GENERATOR", sequenceName = "tarea.COMPANY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_COM_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "COM_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "COM_NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "COM_EMAIL")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "COM_LOGO")
    private byte[] logo;
    @Basic(optional = false)
    @Lob
    @Column(name = "COM_EMAIL_TEMPLATE_PASSWORD")
    private byte[] emailTemplatePassword;
    @Basic(optional = false)
    @Column(name = "COM_TOKEN_EMAIL")
    private String tokenEmail;
    @Version
    @Column(name = "COM_VERSION")
    private Long version;
    @Basic(optional = false)
    @Lob
    @Column(name = "COM_EMAIL_TEMPLATE_ACTIVATE_USER")
    private byte[] emailTemplateActivateUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Skill> skillList;
    @OneToMany(mappedBy = "company")
    private List<Employee> employeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Evaluation> evaluationList;
    @OneToMany(mappedBy = "company")
    private List<Job> jobList;

    public Company() {
    }

    public Company(Long id) {
        this.id = id;
    }

    public Company(Long id, String name, String email, byte[] logo, byte[] emailTemplatePassword, String tokenEmail, Long version, byte[] emailTemplateActivateUser) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.logo = logo;
        this.emailTemplatePassword = emailTemplatePassword;
        this.tokenEmail = tokenEmail;
        this.version = version;
        this.emailTemplateActivateUser = emailTemplateActivateUser;
    }

    public Company(CompanyDto company) {
        this.id = company.getId();
        updateCompany(company);
    }

    public void updateCompany(CompanyDto companyDto) {
        this.id = companyDto.getId();
        this.name = companyDto.getName();
        this.email = companyDto.getEmail();
        this.logo = companyDto.getLogo();
        this.emailTemplatePassword = companyDto.getEmailTemplatePassword();
        this.tokenEmail = companyDto.getTokenEmail();
        this.emailTemplateActivateUser = companyDto.getEmailTemplateActivateUser();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getEmailTemplatePassword() {
        return emailTemplatePassword;
    }

    public void setEmailTemplatePassword(byte[] emailTemplatePassword) {
        this.emailTemplatePassword = emailTemplatePassword;
    }

    public String getTokenEmail() {
        return tokenEmail;
    }

    public void setTokenEmail(String tokenEmail) {
        this.tokenEmail = tokenEmail;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public byte[] getEmailTemplateActivateUser() {
        return emailTemplateActivateUser;
    }

    public void setEmailTemplateActivateUser(byte[] emailTemplateActivateUser) {
        this.emailTemplateActivateUser = emailTemplateActivateUser;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Company[ id=" + id + " ]";
    }

}
