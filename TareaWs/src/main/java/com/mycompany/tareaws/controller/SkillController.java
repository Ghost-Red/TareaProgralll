/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;


import com.mycompany.tareaws.model.SkillDto;
import com.mycompany.tareaws.service.SkillService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author james
 */
@WebService(serviceName = "SkillController")
public class SkillController {
    @WebMethod(operationName = "getMensaje")
    public String getMensaje(@WebParam(name = "code") String code){
        String a = "Este webservice funciona" + code;
        return a;
    }
    @EJB
    SkillService skillService;
    
    @WebMethod(operationName = "getSkill")
    public SkillDto getSkill(@WebParam(name = "skillId") Long skillId) {
        Respuesta res = skillService.getSkill(skillId);
        SkillDto abc = (SkillDto) res.getResultado("Skill");
        return abc;
    }
}
