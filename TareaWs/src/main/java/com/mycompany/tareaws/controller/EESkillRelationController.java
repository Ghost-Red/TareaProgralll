/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EESkillRelationDto;
import com.mycompany.tareaws.service.EESkillRelationService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EESkillRelationController")
public class EESkillRelationController {

    @EJB
    EESkillRelationService eESkillRelationService;

    @WebMethod(operationName = "getEESkillRelation")
    public EESkillRelationDto getEESkillRelation(@WebParam(name = "eesId") Long eESkillRelation) {
        Respuesta res = eESkillRelationService.getEESkillRelation(eESkillRelation);
        return (EESkillRelationDto) res.getResultado("EESkillRelation");
    }
}
