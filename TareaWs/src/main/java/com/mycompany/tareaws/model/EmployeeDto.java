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

    private Long id;
    private String cedula;
    private String name;
    private String firstLastname;
    private String secondLastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String cellphoneNumber;
    private String adminState;
    private String activatedState;
    private String forgotPasswordState;
    private CompanyDto company;
    private JobDto job;
    private boolean modificate;

    public EmployeeDto() {
        modificate = false;
    }

    public EmployeeDto(Employee employee) {
        this();
        this.id = employee.getEmpId();
        this.cedula = employee.getEmpCedula();
        this.name = employee.getEmpName();
        this.firstLastname = employee.getEmpFirstLastname();
        this.secondLastname = employee.getEmpSecondLastname();
        this.email = employee.getEmpEmail();
        this.password = employee.getEmpPassword();
        this.phoneNumber = employee.getEmpPhoneNumber();
        this.cellphoneNumber = employee.getEmpCellphoneNumber();
        this.adminState = employee.getEmpAdminState();
        this.activatedState = employee.getEmpActivatedState();
        this.forgotPasswordState = employee.getEmpForgotPasswordState();
        this.company = new CompanyDto(employee.getEmpComId());
        this.job = new JobDto(employee.getEmpJobId());
    }

    public void updateEmployeeDto(Employee employee) {
        this.id = employee.getEmpId();
        this.cedula = employee.getEmpCedula();
        this.name = employee.getEmpName();
        this.firstLastname = employee.getEmpFirstLastname();
        this.secondLastname = employee.getEmpSecondLastname();
        this.email = employee.getEmpEmail();
        this.password = employee.getEmpPassword();
        this.phoneNumber = employee.getEmpPhoneNumber();
        this.cellphoneNumber = employee.getEmpCellphoneNumber();
        this.adminState = employee.getEmpAdminState();
        this.activatedState = employee.getEmpActivatedState();
        this.forgotPasswordState = employee.getEmpForgotPasswordState();
        this.company.updateCompanyDto(employee.getEmpComId());
        this.job.updateJobDto(employee.getEmpJobId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getAdminState() {
        return adminState;
    }

    public void setAdminState(String adminState) {
        this.adminState = adminState;
    }

    public String getActivatedState() {
        return activatedState;
    }

    public void setActivatedState(String activatedState) {
        this.activatedState = activatedState;
    }

    public String getForgotPasswordState() {
        return forgotPasswordState;
    }

    public void setForgotPasswordState(String forgotPasswordState) {
        this.forgotPasswordState = forgotPasswordState;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    public boolean isModificate() {
        return modificate;
    }

    public void setModificate(boolean modificate) {
        this.modificate = modificate;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" + "empId=" + id + ", empCedula=" + cedula + ", empName=" + name + ", empFirstLastname=" + firstLastname + ", empSecondLastname=" + secondLastname + ", empEmail=" + email + ", empPassword=" + password + ", empPhoneNumber=" + phoneNumber + ", empCellphoneNumber=" + cellphoneNumber + ", empAdminState=" + adminState + ", empActivatedState=" + activatedState + ", empForgotPasswordState=" + forgotPasswordState/*+ ", company=" + company + ", job=" + job + ", modificate="*/ + modificate + '}';
    }

}
