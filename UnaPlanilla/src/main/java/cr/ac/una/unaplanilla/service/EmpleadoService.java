/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanilla.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.ws.rs.core.GenericType;
import cr.ac.una.unaplanilla.model.EmpleadoDto;
import cr.ac.una.unaplanilla.util.Request;
import cr.ac.una.unaplanilla.util.Respuesta;
import jakarta.ws.rs.core.GenericType;

/**
 *
 * @author Carlos
 */
public class EmpleadoService {
    
    public Respuesta getUsuario(String usuario, String clave) {
        try {
            Map<String,Object>parametros=new HashMap<>();
            parametros.put("usuario", usuario);
            parametros.put("clave", clave);
            Request request =new Request("EmpleadoController/validarEmpleado","/{usuario}/{clave}",parametros);
            request.get();
            if(request.isError()){
                return new Respuesta(false,request.getError(),"");
            }
            EmpleadoDto empleadoDto =(EmpleadoDto)request.readEntity(EmpleadoDto.class);
            return new Respuesta(true, "", "", "Empleado", empleadoDto);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }
    
    public Respuesta getEmpleado(Long id) {
        try {
            //TODO
            Map<String,Object>parametros=new HashMap<>();
            parametros.put("id", id);
            
            Request request =new Request("EmpleadoController/empleado","/{id}",parametros);
            request.get();
            if(request.isError()){
                return new Respuesta(false,request.getError(),"");
            }
            EmpleadoDto empleadoDto =(EmpleadoDto)request.readEntity(EmpleadoDto.class);
            return new Respuesta(true, "", "", "Empleado", empleadoDto);
            //return null;//new Respuesta(true, "", "", "Empleado", empleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo el empleado [" + id + "]", ex);
            return null;//new Respuesta(false, "Error obteniendo el empleado.", "getEmpleado " + ex.getMessage());
        }
    }
    
    public Respuesta getEmpleados(String cedula, String nombre, String pApellido) {
        try {
            // TODO
            return null;// new Respuesta(true, "", "", "Empleados", empleados);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo empleados.", ex);
            return null;//new Respuesta(false, "Error obteniendo empleados.", "getEmpleados " + ex.getMessage());
        }
    }
    
    public Respuesta guardarEmpleado(EmpleadoDto empleado) {
        try {
            Request request = new Request("EmpleadoController/saveEmpleado");
            request.post(empleado);
            if (request.isError()) {
                return new Respuesta(false, request.getError(), "");
            }
            EmpleadoDto empleadoDto = (EmpleadoDto) request.readEntity(EmpleadoDto.class);
            return new Respuesta(true, "", "", "Empleado", empleadoDto);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo el empleado", ex);
            return null;
        }
    }
    
    public Respuesta eliminarEmpleado(Long id) {
        try {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("id", id);
            Request request = new Request("EmpleadoController/eliminarEmpleado", "/{id}", parametros);
            request.get();
            if (request.isError()) {
                return new Respuesta(false, request.getError(), "");
            }
            EmpleadoDto empleadoDto = (EmpleadoDto) request.readEntity(EmpleadoDto.class);
            return new Respuesta(true, "", "", "Empleado", empleadoDto);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo el empleado [" + id + "]", ex);
            return null;
        }
    }
}
