/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author grana
 */
public class EmployeeDto {
    
    private Long empId;
    private String empCedula;
    private String empName;
    private String empFirstLastname;
    private String empSecondLastname;
    private String empEmail;
    private String empPassword;
    private String empPhoneNumber;
    private String empCellphoneNumber;
    private String empAdminState;
    private String empActivatedState;
    private String empForgotPasswordState;
    private Company empComId;
    private Job empJobId;
    private boolean modificate;

    public EmployeeDto() {
        modificate = false;
    }
    
    public EmployeeDto(Employee employee){
        this();
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

    public boolean isModificate() {
        return modificate;
    }

    public void setModificate(boolean modificate) {
        this.modificate = modificate;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" + "empId=" + empId + ", empCedula=" + empCedula + ", empName=" + empName + ", empFirstLastname=" + empFirstLastname + ", empSecondLastname=" + empSecondLastname + ", empEmail=" + empEmail + ", empPassword=" + empPassword + ", empPhoneNumber=" + empPhoneNumber + ", empCellphoneNumber=" + empCellphoneNumber + ", empAdminState=" + empAdminState + ", empActivatedState=" + empActivatedState + ", empForgotPasswordState=" + empForgotPasswordState /*+ ", empComId=" + empComId + ", empJobId=" + empJobId + ", modificate="*/ + modificate + '}';
    }
    
    
}
