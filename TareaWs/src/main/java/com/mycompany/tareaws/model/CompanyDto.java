/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.List;

/**
 *
 * @author Progralll
 */
public class CompanyDto {
    private Long comId;
    private String comName;
    private String comEmail;
    private Byte[] comLogo;
    private Byte[] comEmailTemplatePassword;
    private String comTokenEmail;
    private Long comVersion;
    private Byte[] comEmailTemplateActivateUser;
    private boolean modificate;

    public CompanyDto() {
        modificate = false;
    }

    public CompanyDto(Company company) {
        this();
        this.comId = company.getComId();
        this.comName = company.getComName();
        this.comEmail = company.getComEmail();
        this.comLogo = company.getComLogo();
        this.comEmailTemplatePassword = company.getComEmailTemplatePassword();
        this.comTokenEmail = company.getComTokenEmail();
        this.comVersion = company.getComVersion();
        this.comEmailTemplateActivateUser = company.getComEmailTemplateActivateUser();
    }
    
    public void updateCompanyDto(Company company) {
        this.comId = company.getComId();
        this.comName = company.getComName();
        this.comEmail = company.getComEmail();
        this.comLogo = company.getComLogo();
        this.comEmailTemplatePassword = company.getComEmailTemplatePassword();
        this.comTokenEmail = company.getComTokenEmail();
        this.comVersion = company.getComVersion();
        this.comEmailTemplateActivateUser = company.getComEmailTemplateActivateUser();
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

    public boolean isModificate() {
        return modificate;
    }

    public void setModificate(boolean modificate) {
        this.modificate = modificate;
    }

    @Override
    public String toString() {
        return "CompanyDto{" + "comId=" + comId + ", comName=" + comName + ", comEmail=" + comEmail + ", comLogo=" + comLogo + ", comEmailTemplatePassword=" + comEmailTemplatePassword + ", comTokenEmail=" + comTokenEmail + ", comVersion=" + comVersion + ", comEmailTemplateActivateUser=" + comEmailTemplateActivateUser + ", modificate=" + modificate + '}';
    }

}
