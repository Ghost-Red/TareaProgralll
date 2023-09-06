/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grana
 */
public class EmployeeDto {

    private Long id;
    private String identification;
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
    
    private List<EmployeeEvaluationRelationDto> employeeEvaluationRelationList;
    private List<EmployeeEvaluatorRelationDto> employeeEvaluatorRelationList;
    
    public EmployeeDto() {
        modificate = false;
        employeeEvaluatorRelationList=new ArrayList<>();
        employeeEvaluatorRelationList=new ArrayList<>();
    }
    
    public void setForeignAtributes(Employee employee){
        setEmployeeEvaluationRelationList(employee.getEmployeeEvaluationRelationList());
        setEmployeeEvaluatorRelationList(employee.getEmployeeEvaluatorRelationList());
    }

    public List<EmployeeEvaluationRelationDto> getEmployeeEvaluationRelationList() {
        return employeeEvaluationRelationList;
    }

    public void setEmployeeEvaluationRelationList(List<EmployeeEvaluationRelation> employeeEvaluationRelationList) {
        for (EmployeeEvaluationRelation employeeEvaluationRelation : employeeEvaluationRelationList){
            this.employeeEvaluationRelationList.add(new EmployeeEvaluationRelationDto(employeeEvaluationRelation));
        }
    }

    public List<EmployeeEvaluatorRelationDto> getEmployeeEvaluatorRelationList() {
        return employeeEvaluatorRelationList;
    }

    public void setEmployeeEvaluatorRelationList(List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList) {
        for (EmployeeEvaluatorRelation employeeEvaluatorRelation : employeeEvaluatorRelationList){
        this.employeeEvaluatorRelationList.add(new EmployeeEvaluatorRelationDto(employeeEvaluatorRelation));
        }
    }
    
    public EmployeeDto(Employee employee) {
        this();
        this.id = employee.getId();
        this.identification = employee.getIdentification();
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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
        return "EmployeeDto{" + "id=" + id + ", identification=" + identification + ", name=" + name + ", firstLastname=" + firstLastname + ", secondLastname=" + secondLastname + ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", cellphoneNumber=" + cellphoneNumber + ", adminState=" + adminState + ", activatedState=" + activatedState + ", forgotPasswordState=" + forgotPasswordState/*+ ", company=" + company + ", job=" + job + ", modificate="*/ + modificate + '}';
    }

}
