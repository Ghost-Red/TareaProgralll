/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.EmployeeDto;
import com.mycompany.tareaws.model.EmployeeEvaluationRelationDto;
import com.mycompany.tareaws.model.EmployeeEvaluatorRelation;
import com.mycompany.tareaws.model.EmployeeEvaluatorRelationDto;
import com.mycompany.tareaws.util.CodigoRespuesta;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grana
 */
@Stateless
@LocalBean
public class EmployeeEvaluatorRelationService {

    private static final Logger LOG = Logger.getLogger(EmployeeEvaluatorRelationService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getEmployeeEvaluatorRelation(Long id) {
        try {
            Query qryEmployeeEvaluatorRelation = em.createNamedQuery("EmployeeEvaluatorRelation.findByid", EmployeeEvaluatorRelation.class);
            qryEmployeeEvaluatorRelation.setParameter("id", id);
            
            EmployeeEvaluatorRelation employeeEvaluatorRelation = (EmployeeEvaluatorRelation) qryEmployeeEvaluatorRelation.getSingleResult();
            EmployeeEvaluatorRelationDto employeeEvaluatorRelationDto = new EmployeeEvaluatorRelationDto(employeeEvaluatorRelation);
            employeeEvaluatorRelationDto.setEmployee(new EmployeeDto(employeeEvaluatorRelation.getEmployeeEvaluator()));
            employeeEvaluatorRelationDto.setEmployeeEvaluationRelation( new EmployeeEvaluationRelationDto(employeeEvaluatorRelation.getemployeeEvaluated()));
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EmployeeEvaluatorRelation", employeeEvaluatorRelationDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una EmployeeEvaluatorRelation con el código ingresado.", "getEmployeeEvaluatorRelation NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EmployeeEvaluatorRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EmployeeEvaluatorRelation.", "getEmployeeEvaluatorRelation NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EmployeeEvaluatorRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EmployeeEvaluatorRelation.", "getEmployeeEvaluatorRelation " + ex.getMessage());
        }
    }

    public Respuesta saveEmployeeEvaluatorRelation(EmployeeEvaluatorRelationDto employeeEvaluatorRelationDto) {
        try {
            EmployeeEvaluatorRelation employeeEvaluatorRelation;
            if (employeeEvaluatorRelationDto.getId() != null && employeeEvaluatorRelationDto.getId() > 0) {
                employeeEvaluatorRelation = em.find(EmployeeEvaluatorRelation.class, employeeEvaluatorRelationDto.getId());
                if (employeeEvaluatorRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EmployeeEvaluatorRelation a modificar.", "saveEmployeeEvaluatorRelation NoResultException");
                }
                employeeEvaluatorRelation.updateEmployeeEvaluatorRelation(employeeEvaluatorRelationDto);
                employeeEvaluatorRelation = em.merge(employeeEvaluatorRelation);
            } else {
                employeeEvaluatorRelation = new EmployeeEvaluatorRelation(employeeEvaluatorRelationDto);
                em.persist(employeeEvaluatorRelation);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EmployeeEvaluatorRelation", new EmployeeEvaluatorRelationDto(employeeEvaluatorRelation));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EmployeeEvaluatorRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la EmployeeEvaluatorRelation.", "saveEmployeeEvaluatorRelation " + ex.getMessage());
        }
    }

    public Respuesta deleteEmployeeEvaluatorRelation(Long id) {
        try {
            EmployeeEvaluatorRelation employeeEvaluatorRelation;
            if (id != null && id > 0) {
                employeeEvaluatorRelation = em.find(EmployeeEvaluatorRelation.class, id);
                if (employeeEvaluatorRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EmployeeEvaluatorRelation a eliminar.", "deleteEmployeeEvaluatorRelation NoResultException");
                }
                em.remove(employeeEvaluatorRelation);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la EmployeeEvaluatorRelation a eliminar.", "deleteEmployeeEvaluatorRelation NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la EmployeeEvaluatorRelation porque tiene relaciones con otros registros.", "deleteEmployeeEvaluatorRelation " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EmployeeEvaluatorRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la EmployeeEvaluatorRelation.", "deleteEmployeeEvaluatorRelation " + ex.getMessage());
        }
    }
}
