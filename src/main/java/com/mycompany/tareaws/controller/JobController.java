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

    @EJB
    JobService jobService;

    @WebMethod(operationName = "getJob")
    public JobDto getJob(@WebParam(name = "id") Long id) {
        Respuesta res = jobService.getJob(id);
        return (JobDto) res.getResultado("Job");
    }

    @WebMethod(operationName = "saveJob")
    public boolean saveJob(JobDto job) {
        Respuesta res = jobService.saveJob(job);
        return res.getEstado();
    }

    @WebMethod(operationName = "deleteJob")
    public boolean deleteJob(@WebParam(name = "id") Long id) {
        Respuesta res = jobService.deleteJob(id);
        return res.getEstado();
    }
}
