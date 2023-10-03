/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.unaplanillaws.controller;

import cr.ac.una.unaplanillaws.model.TipoPlanillaDto;
import cr.ac.una.unaplanillaws.service.TipoPlanillaService;
import cr.ac.una.unaplanillaws.util.CodigoRespuesta;
import cr.ac.una.unaplanillaws.util.Respuesta;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author james
 */
@Path("/TipoPlanillaController")
@Tag(name = "TipoPlanilla", description = "Operaciones sobre tipo de planilla")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoPlanillaController {
    @EJB
    TipoPlanillaService tipoPlanillaService;
    
    
    @GET
    @Path("/TipoPlanilla/{id}")
    public Response getTipoPlanilla(@PathParam("id")Long id){
        try{
        Respuesta res= tipoPlanillaService.getTipoPlanilla(id);
        if(!res.getEstado()){
            return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
        }
        return Response.ok(res.getResultado("Tipo Planilla")).build();
        }catch(Exception ex){
            Logger.getLogger(TipoPlanillaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el Tipo Planilla").build();
        }
    }
    
    @POST
    @Path("/savePlanilla")
    public Response guardarPlanilla(TipoPlanillaDto tipoPlanillaDto) {
        try {
            Respuesta res = tipoPlanillaService.guardarTipoPlanilla(tipoPlanillaDto);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok(res.getResultado("Tipo Planilla")).build();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el tipo de planilla").build();
        }
    }
    
    @GET
    @Path("/eliminarPlanilla/{id}")
    public Response eliminarPlanilla(@PathParam("id") Long id) {
        try {
            Respuesta res = tipoPlanillaService.eliminarTipoPlanilla(id);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok(res.getResultado("TipoPlanilla")).build();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el TipoPlanilla").build();
        }
    }
}
