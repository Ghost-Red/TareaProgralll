/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EvaluationJobRelationDto;
import com.mycompany.tareaws.service.EvaluationJobRelationService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EvaluationJobRelationJobRelationController")
public class EvaluationJobRelationController {

    @EJB
    EvaluationJobRelationService evaluationJobRelationService;

    @WebMethod(operationName = "getEvaluationJobRelation")
    public EvaluationJobRelationDto getEvaluationJobRelation(@WebParam(name = "id") Long id) {
        Respuesta res = evaluationJobRelationService.getEvaluationJobRelation(id);
        return (EvaluationJobRelationDto) res.getResultado("EvaluationJobRelation");
    }
}
