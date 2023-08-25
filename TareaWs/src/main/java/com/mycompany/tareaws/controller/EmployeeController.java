/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.service.EmployeeService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EmployeeController")
public class EmployeeController {

    @EJB
    EmployeeService employeeService;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getEmpleado")
    public Response getEmpleado(@WebParam(name = "empId") Long empId) {
        Respuesta res = employeeService.getEmployee(empId);
        return Response.ok(res.getResultado("Employee")).build();
    }
}
