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
import java.util.List;

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
    
    @WebMethod(operationName = "getEmployeeEvaluationRelationByEvaluationJobRelation")
    public List<EmployeeEvaluationRelationDto> getEmployeeEvaluationRelationByEvaluationJobRelation(@WebParam(name = "idEvaluationJobRelation") Long idEvaluationJobRelation) {
        Respuesta res = employeeEvaluationRelationService.getEmployeeEvaluationRelationByEvaluationJobRelation(idEvaluationJobRelation);
        return (List<EmployeeEvaluationRelationDto>) res.getResultado("EmployeeEvaluationRelationList");
    }
    
    @WebMethod(operationName = "saveEmployeeEvaluationRelation")
    public EmployeeEvaluationRelationDto saveEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelation) {
        Respuesta res = employeeEvaluationRelationService.saveEmployeeEvaluationRelation(employeeEvaluationRelation);
        return (EmployeeEvaluationRelationDto) res.getResultado("EmployeeEvaluationRelation");
    }

    @WebMethod(operationName = "deleteEmployeeEvaluationRelation")
    public boolean deleteEmployeeEvaluationRelation(@WebParam(name = "id") Long id) {
        Respuesta res = employeeEvaluationRelationService.deleteEmployeeEvaluationRelation(id);
        return res.getEstado();
    }
}
