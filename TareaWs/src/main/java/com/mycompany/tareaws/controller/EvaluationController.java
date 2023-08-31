/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EvaluationDto;
import com.mycompany.tareaws.service.EvaluationService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EvaluationController")
public class EvaluationController {

    @EJB
    EvaluationService evaluationService;

    @WebMethod(operationName = "getEvaluation")
    public EvaluationDto getEvaluation(@WebParam(name = "id") Long id) {
        Respuesta res = evaluationService.getEvaluation(id);
        return (EvaluationDto) res.getResultado("Evaluation");
    }
}
