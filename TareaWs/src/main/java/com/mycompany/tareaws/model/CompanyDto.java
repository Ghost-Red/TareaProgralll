/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author Progralll
 */
public class CompanyDto {

    private Long id;
    private String name;
    private String email;
    private Byte[] logo;
    private Byte[] emailTemplatePassword;
    private String tokenEmail;
    private Byte[] emailTemplateActivateUser;
    private boolean modificate;

    public CompanyDto() {
        modificate = false;
    }

    public CompanyDto(Company company) {
        this();
        this.id = company.getId();
        this.name = company.getName();
        this.email = company.getEmail();
        this.logo = company.getLogo();
        this.emailTemplatePassword = company.getEmailTemplatePassword();
        this.tokenEmail = company.getTokenEmail();
        this.emailTemplateActivateUser = company.getEmailTemplateActivateUser();
    }

    public void updateCompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.email = company.getEmail();
        this.logo = company.getLogo();
        this.emailTemplatePassword = company.getEmailTemplatePassword();
        this.tokenEmail = company.getTokenEmail();
        this.emailTemplateActivateUser = company.getEmailTemplateActivateUser();
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

    public Byte[] getLogo() {
        return logo;
    }

    public void setLogo(Byte[] logo) {
        this.logo = logo;
    }

    public Byte[] getEmailTemplatePassword() {
        return emailTemplatePassword;
    }

    public void setEmailTemplatePassword(Byte[] emailTemplatePassword) {
        this.emailTemplatePassword = emailTemplatePassword;
    }

    public String getTokenEmail() {
        return tokenEmail;
    }

    public void setTokenEmail(String tokenEmail) {
        this.tokenEmail = tokenEmail;
    }

    public Byte[] getEmailTemplateActivateUser() {
        return emailTemplateActivateUser;
    }

    public void setEmailTemplateActivateUser(Byte[] emailTemplateActivateUser) {
        this.emailTemplateActivateUser = emailTemplateActivateUser;
    }

    public boolean isModificate() {
        return modificate;
    }

    public void setModificate(boolean modificate) {
        this.modificate = modificate;
    }

    @Override
    public String toString() {
        return "CompanyDto{" + "id=" + id + ", name=" + name + ", email=" + email + ", logo=" + logo + ", emailTemplatePassword=" + emailTemplatePassword + ", tokenEmail=" + tokenEmail + ", emailTemplateActivateUser=" + emailTemplateActivateUser + ", modificate=" + modificate + '}';
    }

}
