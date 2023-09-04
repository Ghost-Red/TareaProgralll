/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EmployeeAverageSkillDto;
import com.mycompany.tareaws.service.EmployeeAverageSkillService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EmployeeAverageSkillController")
public class EmployeeAverageSkillController {

    @EJB
    EmployeeAverageSkillService employeeAverageSkillService;

    @WebMethod(operationName = "getEmployeeAverageSkill")
    public EmployeeAverageSkillDto getEmployeeAverageSkill(@WebParam(name = "id") Long id) {
        Respuesta res = employeeAverageSkillService.getEmployeeAverageSkill(id);
        return (EmployeeAverageSkillDto) res.getResultado("EmployeeAverageSkill");
    }
    @WebMethod(operationName = "saveEmployeeAverageSkill")
    public EmployeeAverageSkillDto saveEmployeeAverageSkill(EmployeeAverageSkillDto employeeAverageSkill){
        Respuesta res = employeeAverageSkillService.saveEmployeeAverageSkill(employeeAverageSkill);
        return (EmployeeAverageSkillDto) res.getResultado("company");
    }
    
    @WebMethod(operationName = "deleteEmployeeAverageSkill")
    public EmployeeAverageSkillDto deleteEmployeeAverageSkill(@WebParam(name = "id") Long id){
        Respuesta res = employeeAverageSkillService.deleteEmployeeAverageSkill(id);
        return (EmployeeAverageSkillDto) res.getResultado("company");
    }
}
