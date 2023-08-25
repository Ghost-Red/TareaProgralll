/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
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

/**
 *
 * @author grana
 */
@Entity
@Table(name = "Company")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByComId", query = "SELECT c FROM Company c WHERE c.comId = :comId"),
    @NamedQuery(name = "Company.findByComName", query = "SELECT c FROM Company c WHERE c.comName = :comName"),
    @NamedQuery(name = "Company.findByComEmail", query = "SELECT c FROM Company c WHERE c.comEmail = :comEmail"),
    @NamedQuery(name = "Company.findByComEmailTemplatePassword", query = "SELECT c FROM Company c WHERE c.comEmailTemplatePassword = :comEmailTemplatePassword"),
    @NamedQuery(name = "Company.findByComTokenEmail", query = "SELECT c FROM Company c WHERE c.comTokenEmail = :comTokenEmail"),
    @NamedQuery(name = "Company.findByComVersion", query = "SELECT c FROM Company c WHERE c.comVersion = :comVersion"),
    @NamedQuery(name = "Company.findByComEmailTemplateActivateUser", query = "SELECT c FROM Company c WHERE c.comEmailTemplateActivateUser = :comEmailTemplateActivateUser")})
public class Company implements Serializable {

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
    private Serializable comLogo;
    @Basic(optional = false)
    @Column(name = "COM_EMAIL_TEMPLATE_PASSWORD")
    private String comEmailTemplatePassword;
    @Basic(optional = false)
    @Column(name = "COM_TOKEN_EMAIL")
    private String comTokenEmail;
    @Basic(optional = false)
    @Column(name = "COM_VERSION")
    private Long comVersion;
    @Basic(optional = false)
    @Column(name = "COM_EMAIL_TEMPLATE_ACTIVATE_USER")
    private String comEmailTemplateActivateUser;
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

    public Company(Long comId, String comName, String comEmail, Serializable comLogo, String comEmailTemplatePassword, String comTokenEmail, Long comVersion, String comEmailTemplateActivateUser) {
        this.comId = comId;
        this.comName = comName;
        this.comEmail = comEmail;
        this.comLogo = comLogo;
        this.comEmailTemplatePassword = comEmailTemplatePassword;
        this.comTokenEmail = comTokenEmail;
        this.comVersion = comVersion;
        this.comEmailTemplateActivateUser = comEmailTemplateActivateUser;
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

    public Serializable getComLogo() {
        return comLogo;
    }

    public void setComLogo(Serializable comLogo) {
        this.comLogo = comLogo;
    }

    public String getComEmailTemplatePassword() {
        return comEmailTemplatePassword;
    }

    public void setComEmailTemplatePassword(String comEmailTemplatePassword) {
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

    public String getComEmailTemplateActivateUser() {
        return comEmailTemplateActivateUser;
    }

    public void setComEmailTemplateActivateUser(String comEmailTemplateActivateUser) {
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
        return "model.Company[ comId=" + comId + " ]";
    }
    
}
