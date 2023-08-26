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

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EMPLOYEE")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmpId", query = "SELECT e FROM Employee e WHERE e.empId = :empId"),
    @NamedQuery(name = "Employee.findByEmpCedula", query = "SELECT e FROM Employee e WHERE e.empCedula = :empCedula"),
    @NamedQuery(name = "Employee.findByEmpName", query = "SELECT e FROM Employee e WHERE e.empName = :empName"),
    @NamedQuery(name = "Employee.findByEmpFirstLastname", query = "SELECT e FROM Employee e WHERE e.empFirstLastname = :empFirstLastname"),
    @NamedQuery(name = "Employee.findByEmpSecondLastname", query = "SELECT e FROM Employee e WHERE e.empSecondLastname = :empSecondLastname"),
    @NamedQuery(name = "Employee.findByEmpEmail", query = "SELECT e FROM Employee e WHERE e.empEmail = :empEmail"),
    @NamedQuery(name = "Employee.findByEmpPassword", query = "SELECT e FROM Employee e WHERE e.empPassword = :empPassword"),
    @NamedQuery(name = "Employee.findByEmpPhoneNumber", query = "SELECT e FROM Employee e WHERE e.empPhoneNumber = :empPhoneNumber"),
    @NamedQuery(name = "Employee.findByEmpCellphoneNumber", query = "SELECT e FROM Employee e WHERE e.empCellphoneNumber = :empCellphoneNumber"),
    @NamedQuery(name = "Employee.findByEmpAdminState", query = "SELECT e FROM Employee e WHERE e.empAdminState = :empAdminState"),
    @NamedQuery(name = "Employee.findByEmpActivatedState", query = "SELECT e FROM Employee e WHERE e.empActivatedState = :empActivatedState"),
    @NamedQuery(name = "Employee.findByEmpForgotPasswordState", query = "SELECT e FROM Employee e WHERE e.empForgotPasswordState = :empForgotPasswordState"),
    @NamedQuery(name = "Employee.findByEmpVersion", query = "SELECT e FROM Employee e WHERE e.empVersion = :empVersion"),
    @NamedQuery(name = "Empleado.findByCedulaNameFirstLastName", query = "SELECT e FROM Employee e WHERE UPPER(e.empName) like :empName and UPPER(e.empCedula) like :empCedula and UPPER(e.empFirstLastname) like :empFirstLastName"),
    @NamedQuery(name = "Employee.findByEmpEmailPassword", query = "SELECT e FROM Employee e WHERE e.empEmail = :empEmail and e.empPassword = :empPassword")})

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EMP_ID")
    private Long empId;
    @Basic(optional = false)
    @Column(name = "EMP_CEDULA")
    private String empCedula;
    @Basic(optional = false)
    @Column(name = "EMP_NAME")
    private String empName;
    @Basic(optional = false)
    @Column(name = "EMP_FIRST_LASTNAME")
    private String empFirstLastname;
    @Basic(optional = false)
    @Column(name = "EMP_SECOND_LASTNAME")
    private String empSecondLastname;
    @Basic(optional = false)
    @Column(name = "EMP_EMAIL")
    private String empEmail;
    @Basic(optional = false)
    @Column(name = "EMP_PASSWORD")
    private String empPassword;
    @Basic(optional = false)
    @Column(name = "EMP_PHONE_NUMBER")
    private String empPhoneNumber;
    @Basic(optional = false)
    @Column(name = "EMP_CELLPHONE_NUMBER")
    private String empCellphoneNumber;
    @Basic(optional = false)
    @Column(name = "EMP_ADMIN_STATE")
    private String empAdminState;
    @Basic(optional = false)
    @Column(name = "EMP_ACTIVATED_STATE")
    private String empActivatedState;
    @Basic(optional = false)
    @Column(name = "EMP_FORGOT_PASSWORD_STATE")
    private String empForgotPasswordState;
    @Basic(optional = false)
    @Column(name = "EMP_VERSION")
    private Long empVersion;
    @JoinColumn(name = "EMP_COM_ID", referencedColumnName = "COM_ID")
    @ManyToOne
    private Company empComId;
    @JoinColumn(name = "EMP_JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne
    private Job empJobId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eerEmpId")
    private List<EmployeeEvaluationRelation> employeeEvaluationRelationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eeEmpId")
    private List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList;

    public Employee() {
    }

    public Employee(Long empId) {
        this.empId = empId;
    }

    public Employee(Long empId, String empCedula, String empName, String empFirstLastname, String empSecondLastname, String empEmail, String empPassword, String empPhoneNumber, String empCellphoneNumber, String empAdminState, String empActivatedState, String empForgotPasswordState, Long empVersion) {
        this.empId = empId;
        this.empCedula = empCedula;
        this.empName = empName;
        this.empFirstLastname = empFirstLastname;
        this.empSecondLastname = empSecondLastname;
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.empPhoneNumber = empPhoneNumber;
        this.empCellphoneNumber = empCellphoneNumber;
        this.empAdminState = empAdminState;
        this.empActivatedState = empActivatedState;
        this.empForgotPasswordState = empForgotPasswordState;
        this.empVersion = empVersion;
    }

    public Employee(EmployeeDto employee) {
        this.empId = employee.getEmpId();
        updateEmployee(employee);
    }
   
        public void updateEmployee(EmployeeDto employee){
        this.empId = employee.getEmpId();
        this.empCedula = employee.getEmpCedula();
        this.empName = employee.getEmpName();
        this.empFirstLastname = employee.getEmpFirstLastname();
        this.empSecondLastname = employee.getEmpSecondLastname();
        this.empEmail = employee.getEmpEmail();
        this.empPassword = employee.getEmpPassword();
        this.empPhoneNumber = employee.getEmpPhoneNumber();
        this.empCellphoneNumber = employee.getEmpCellphoneNumber();
        this.empAdminState = employee.getEmpAdminState();
        this.empActivatedState = employee.getEmpActivatedState();
        this.empForgotPasswordState = employee.getEmpForgotPasswordState();
        this.empComId = employee.getEmpComId();
        this.empJobId = employee.getEmpJobId();
    }
        
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(String empCedula) {
        this.empCedula = empCedula;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpFirstLastname() {
        return empFirstLastname;
    }

    public void setEmpFirstLastname(String empFirstLastname) {
        this.empFirstLastname = empFirstLastname;
    }

    public String getEmpSecondLastname() {
        return empSecondLastname;
    }

    public void setEmpSecondLastname(String empSecondLastname) {
        this.empSecondLastname = empSecondLastname;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpPhoneNumber() {
        return empPhoneNumber;
    }

    public void setEmpPhoneNumber(String empPhoneNumber) {
        this.empPhoneNumber = empPhoneNumber;
    }

    public String getEmpCellphoneNumber() {
        return empCellphoneNumber;
    }

    public void setEmpCellphoneNumber(String empCellphoneNumber) {
        this.empCellphoneNumber = empCellphoneNumber;
    }

    public String getEmpAdminState() {
        return empAdminState;
    }

    public void setEmpAdminState(String empAdminState) {
        this.empAdminState = empAdminState;
    }

    public String getEmpActivatedState() {
        return empActivatedState;
    }

    public void setEmpActivatedState(String empActivatedState) {
        this.empActivatedState = empActivatedState;
    }

    public String getEmpForgotPasswordState() {
        return empForgotPasswordState;
    }

    public void setEmpForgotPasswordState(String empForgotPasswordState) {
        this.empForgotPasswordState = empForgotPasswordState;
    }

    public Long getEmpVersion() {
        return empVersion;
    }

    public void setEmpVersion(Long empVersion) {
        this.empVersion = empVersion;
    }

    public Company getEmpComId() {
        return empComId;
    }

    public void setEmpComId(Company empComId) {
        this.empComId = empComId;
    }

    public Job getEmpJobId() {
        return empJobId;
    }

    public void setEmpJobId(Job empJobId) {
        this.empJobId = empJobId;
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
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Employee[ empId=" + empId + " ]";
    }
    
}
