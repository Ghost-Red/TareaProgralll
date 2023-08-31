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
            return new Respuesta(false, "Error obteniendo el empleado.", "getEmpleado " + ex.getMessage());
        }
    }
    
    public Respuesta getEmpleados(String cedula, String nombre, String pApellido) {
        try {
            Map<String,Object>parametros=new HashMap<>();
            parametros.put("cedula", cedula);
            parametros.put("nombre", nombre);
            parametros.put("pApellido", pApellido);
            Request request =new Request("EmpleadoController/empleados","/{cedula}/{nombre}/{pApellido}",parametros);
            request.get();
            if(request.isError()){
                return new Respuesta(false,request.getError(),"");
            }
            EmpleadoDto empleadoDto =(EmpleadoDto)request.readEntity(EmpleadoDto.class);
            return new Respuesta(true, "", "", "Empleado", empleadoDto);
            //return null;// new Respuesta(true, "", "", "Empleados", empleados);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo los empleados.", ex);
            return new Respuesta(false, "Error obteniendo los empleados.", "getEmpleados " + ex.getMessage());
        }
    }
    
    public Respuesta guardarEmpleado(EmpleadoDto empleado) {
        try {
            // TODO
            return null;//new Respuesta(true, "", "", "Empleado", empleadoDto);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return null;//new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
    
    public Respuesta eliminarEmpleado(Long id) {
        try {
            //TODO
            return null;//new Respuesta(true, "", "");
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error eliminando el empleado.", ex);
            return null;//new Respuesta(false, "Error eliminando el empleado.", "eliminarEmpleado " + ex.getMessage());
        }
    }
}
