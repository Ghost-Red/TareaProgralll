/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.JobDto;
import com.mycompany.tareaws.service.JobService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author james
 */
@WebService(serviceName = "JobController")
public class JobController {
    @WebMethod(operationName = "getMensaje")
    public String getMensaje(@WebParam(name = "code") String code){
        String a = "Este webservice funciona" + code;
        return a;
    }
    @EJB
    JobService jobService;
    
    @WebMethod(operationName = "getJob")
    public JobDto getJob(@WebParam(name = "jobId") Long jobId) {
        Respuesta res = jobService.getJob(jobId);
        JobDto abc = (JobDto) res.getResultado("Job");
        return abc;
    }
}
