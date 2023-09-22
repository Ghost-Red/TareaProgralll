/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.CompanyDto;
import com.mycompany.tareaws.service.CompanyService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author grana
 */
@WebService(serviceName = "CompanyController")
public class CompanyController {

    @EJB
    CompanyService companyService;

    @WebMethod(operationName = "getCompany")
    public CompanyDto getCompany(@WebParam(name = "id") Long id) {
        Respuesta res = companyService.getCompany(id);
        return (CompanyDto) res.getResultado("Company");
    }

    @WebMethod(operationName = "getCompanyByName")
    public CompanyDto getCompanyByName(@WebParam(name = "name") String name) {
        Respuesta res = companyService.getCompanyByName(name);
        return (CompanyDto) res.getResultado("Company");
    }

    @WebMethod(operationName = "saveCompany")
    public CompanyDto saveCompany(CompanyDto company) {
        Respuesta res = companyService.saveCompany(company);
        return (CompanyDto) res.getResultado("Company");
    }

    @WebMethod(operationName = "deleteCompany")
    public boolean deleteCompany(@WebParam(name = "id") Long id) {
        Respuesta res = companyService.deleteCompany(id);
        return res.getEstado();
    }
}
