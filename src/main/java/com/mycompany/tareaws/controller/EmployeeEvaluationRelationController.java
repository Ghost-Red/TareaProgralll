/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EmployeeEvaluationRelationDto;
import com.mycompany.tareaws.service.EmployeeEvaluationRelationService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EmployeeEvaluationRelationController")
public class EmployeeEvaluationRelationController {

    @EJB
    EmployeeEvaluationRelationService employeeEvaluationRelationService;

    @WebMethod(operationName = "getEmployeeEvaluationRelation")
    public EmployeeEvaluationRelationDto getEmployeeEvaluationRelation(@WebParam(name = "id") Long id) {
        Respuesta res = employeeEvaluationRelationService.getEmployeeEvaluationRelation(id);
        return (EmployeeEvaluationRelationDto) res.getResultado("EmployeeEvaluationRelation");
    }

    @WebMethod(operationName = "saveEmployeeEvaluationRelation")
    public boolean saveEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelation) {
        Respuesta res = employeeEvaluationRelationService.saveEmployeeEvaluationRelation(employeeEvaluationRelation);
        return res.getEstado();
    }

    @WebMethod(operationName = "deleteEmployeeEvaluationRelation")
    public boolean deleteEmployeeEvaluationRelation(@WebParam(name = "id") Long id) {
        Respuesta res = employeeEvaluationRelationService.deleteEmployeeEvaluationRelation(id);
        return res.getEstado();
    }
}
