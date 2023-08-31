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
@Table(name = "EMPLOYEE")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByid", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByidentification", query = "SELECT e FROM Employee e WHERE e.identification = :identification"),
    @NamedQuery(name = "Employee.findByname", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByfirstLastname", query = "SELECT e FROM Employee e WHERE e.firstLastname = :firstLastname"),
    @NamedQuery(name = "Employee.findBysecondLastname", query = "SELECT e FROM Employee e WHERE e.secondLastname = :secondLastname"),
    @NamedQuery(name = "Employee.findByemail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findBypassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByphoneNumber", query = "SELECT e FROM Employee e WHERE e.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Employee.findBycellphoneNumber", query = "SELECT e FROM Employee e WHERE e.cellphoneNumber = :cellphoneNumber"),
    @NamedQuery(name = "Employee.findByadminState", query = "SELECT e FROM Employee e WHERE e.adminState = :adminState"),
    @NamedQuery(name = "Employee.findByactivatedState", query = "SELECT e FROM Employee e WHERE e.activatedState = :activatedState"),
    @NamedQuery(name = "Employee.findByforgotPasswordState", query = "SELECT e FROM Employee e WHERE e.forgotPasswordState = :forgotPasswordState"),
    @NamedQuery(name = "Employee.findByversion", query = "SELECT e FROM Employee e WHERE e.version = :version"),
    @NamedQuery(name = "Employee.findByCedulaNameFirstLastName", query = "SELECT e FROM Employee e WHERE UPPER(e.name) like :name and UPPER(e.identification) like :identification and UPPER(e.firstLastname) like :firstLastname"),
    @NamedQuery(name = "Employee.findByemailPassword", query = "SELECT e FROM Employee e WHERE e.email = :email and e.password = :password")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EMP_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "EMP_CEDULA")
    private String identification;
    @Basic(optional = false)
    @Column(name = "EMP_NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "EMP_FIRST_LASTNAME")
    private String firstLastname;
    @Basic(optional = false)
    @Column(name = "EMP_SECOND_LASTNAME")
    private String secondLastname;
    @Basic(optional = false)
    @Column(name = "EMP_EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "EMP_PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "EMP_PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "EMP_CELLPHONE_NUMBER")
    private String cellphoneNumber;
    @Basic(optional = false)
    @Column(name = "EMP_ADMIN_STATE")
    private String adminState;
    @Basic(optional = false)
    @Column(name = "EMP_ACTIVATED_STATE")
    private String activatedState;
    @Basic(optional = false)
    @Column(name = "EMP_FORGOT_PASSWORD_STATE")
    private String forgotPasswordState;
    @Version
    @Column(name = "EMP_VERSION")
    private Long version;
    @JoinColumn(name = "EMP_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne
    private Company company;
    @JoinColumn(name = "EMP_JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne
    private Job job;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eerid")
    private List<EmployeeEvaluationRelation> employeeEvaluationRelationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eeid")
    private List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList;

    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(Long id, String identification, String name, String firstLastname, String secondLastname, String email, String password, String phoneNumber, String cellphoneNumber, String adminState, String activatedState, String forgotPasswordState, Long version) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.cellphoneNumber = cellphoneNumber;
        this.adminState = adminState;
        this.activatedState = activatedState;
        this.forgotPasswordState = forgotPasswordState;
        this.version = version;
    }

    public Employee(EmployeeDto employee) {
        this.id = employee.getId();
        updateEmployee(employee);
    }

    public void updateEmployee(EmployeeDto employee) {
        this.id = employee.getId();
        this.identification = employee.getCedula();
        this.name = employee.getName();
        this.firstLastname = employee.getFirstLastname();
        this.secondLastname = employee.getSecondLastname();
        this.email = employee.getEmail();
        this.password = employee.getPassword();
        this.phoneNumber = employee.getPhoneNumber();
        this.cellphoneNumber = employee.getCellphoneNumber();
        this.adminState = employee.getAdminState();
        this.activatedState = employee.getActivatedState();
        this.forgotPasswordState = employee.getForgotPasswordState();
        this.job.updateJob(employee.getJob());
        this.company.updateCompany(employee.getCompany());
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getidentification() {
        return identification;
    }

    public void setidentification(String identification) {
        this.identification = identification;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getfirstLastname() {
        return firstLastname;
    }

    public void setfirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getsecondLastname() {
        return secondLastname;
    }

    public void setsecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getcellphoneNumber() {
        return cellphoneNumber;
    }

    public void setcellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getadminState() {
        return adminState;
    }

    public void setadminState(String adminState) {
        this.adminState = adminState;
    }

    public String getactivatedState() {
        return activatedState;
    }

    public void setactivatedState(String activatedState) {
        this.activatedState = activatedState;
    }

    public String getforgotPasswordState() {
        return forgotPasswordState;
    }

    public void setforgotPasswordState(String forgotPasswordState) {
        this.forgotPasswordState = forgotPasswordState;
    }

    public Long getversion() {
        return version;
    }

    public void setversion(Long version) {
        this.version = version;
    }

    public Company getcompany() {
        return company;
    }

    public void setcompany(Company company) {
        this.company = company;
    }

    public Job getjob() {
        return job;
    }

    public void setjob(Job job) {
        this.job = job;
    }

    public List<EmployeeEvaluationRelation> getEmployeeEvaluationRelationList() {
        return employeeEvaluationRelationList;
    }

    public void setEmployeeEvaluationRelationList(List<EmployeeEvaluationRelation> employeeEvaluationRelationList) {
        this.employeeEvaluationRelationList = employeeEvaluationRelationList;
    }

    public List<EmployeeEvaluatorRelation> getEmployeeEvaluatorRelationList() {
        return employeeEvaluatorRelationList;
    }

    public void setEmployeeEvaluatorRelationList(List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList) {
        this.employeeEvaluatorRelationList = employeeEvaluatorRelationList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.Employee[ id=" + id + " ]";
    }

}
