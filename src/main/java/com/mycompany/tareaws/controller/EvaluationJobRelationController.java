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
import java.util.List;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EvaluationJobRelationController")
public class EvaluationJobRelationController {

    @EJB
    EvaluationJobRelationService evaluationJobRelationService;

    @WebMethod(operationName = "getEvaluationJobRelation")
    public EvaluationJobRelationDto getEvaluationJobRelation(@WebParam(name = "id") Long id) {
        Respuesta res = evaluationJobRelationService.getEvaluationJobRelation(id);
        return (EvaluationJobRelationDto) res.getResultado("EvaluationJobRelation");
    }

    @WebMethod(operationName = "saveEvaluationJobRelation")
    public EvaluationJobRelationDto saveEvaluationJobRelation(EvaluationJobRelationDto evaluationJobRelation) {
        Respuesta res = evaluationJobRelationService.saveEvaluationJobRelation(evaluationJobRelation);
        return (EvaluationJobRelationDto) res.getResultado("EvaluationJobRelation");
    }

    @WebMethod(operationName = "deleteEvaluationJobRelation")
    public boolean deleteEvaluationJobRelation(@WebParam(name = "id") Long id) {
        Respuesta res = evaluationJobRelationService.deleteEvaluationJobRelation(id);
        return res.getEstado();
    }
    
    @WebMethod(operationName = "getEvaluationsJobRelationByEvalaution")
    public List<EvaluationJobRelationDto> getEvaluationsJobRelationByEvalaution(@WebParam(name = "idEvaluation") Long idEvaluation) {
        Respuesta res = evaluationJobRelationService.getEvaluationsJobRelationByEvalaution(idEvaluation);
        return (List<EvaluationJobRelationDto>) res.getResultado("EvaluationJobRelationList");
    }
}
