/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EmployeeEvaluatorRelationDto;
import com.mycompany.tareaws.service.EmployeeEvaluatorRelationService;
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
@WebService(serviceName = "EmployeeEvaluatorRelationController")
public class EmployeeEvaluatorRelationController {

    @EJB
    EmployeeEvaluatorRelationService employeeEvaluatorRelationService;

    @WebMethod(operationName = "getEmployeeEvaluatorRelation")
    public EmployeeEvaluatorRelationDto getEmployeeEvaluatorRelation(@WebParam(name = "id") Long id) {
        Respuesta res = employeeEvaluatorRelationService.getEmployeeEvaluatorRelation(id);
        return (EmployeeEvaluatorRelationDto) res.getResultado("EmployeeEvaluatorRelation");
    }
    
    @WebMethod(operationName = "getEmployeeEvaluatorRelationByEmployeeEvaluationRelation")
    public List<EmployeeEvaluatorRelationDto> getEmployeeEvaluatorRelationByEmployeeEvaluationRelation(@WebParam(name = "idEmployeeEvaluationRelation") Long idEmployeeEvaluationRelation) {
        Respuesta res = employeeEvaluatorRelationService.getEmployeeEvaluatorRelationByEmployeeEvaluationRelation(idEmployeeEvaluationRelation);
        return (List<EmployeeEvaluatorRelationDto>) res.getResultado("EmployeeEvaluatorRelationList");
    }
    
    @WebMethod(operationName = "saveEmployeeEvaluatorRelation")
    public EmployeeEvaluatorRelationDto saveEmployeeEvaluatorRelation(EmployeeEvaluatorRelationDto employeeEvaluatorRelation) {
        Respuesta res = employeeEvaluatorRelationService.saveEmployeeEvaluatorRelation(employeeEvaluatorRelation);
        return (EmployeeEvaluatorRelationDto) res.getResultado("EmployeeEvaluatorRelation");
    }

    @WebMethod(operationName = "deleteEmployeeEvaluatorRelation")
    public boolean deleteEmployeeEvaluatorRelation(@WebParam(name = "id") Long id) {
        Respuesta res = employeeEvaluatorRelationService.deleteEmployeeEvaluatorRelation(id);
        return res.getEstado();
    }
}
