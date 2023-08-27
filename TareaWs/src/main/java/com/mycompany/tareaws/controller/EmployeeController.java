/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EmployeeDto;
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
    
    @WebMethod(operationName = "getMensaje")
    public String getMensaje(@WebParam(name = "code") String code){
        String a = "Este webservice funciona" + code;
        return a;
    }
    @EJB
    EmployeeService employeeService;
    
    @WebMethod(operationName = "getEmpleado")
    public Response getEmpleado(@WebParam(name = "empId") Long empId) {
        Respuesta res = employeeService.getEmployee(empId);
        Response response = Response.ok(res.getResultado("Employee")).build();
        return response;
    }
    
}
