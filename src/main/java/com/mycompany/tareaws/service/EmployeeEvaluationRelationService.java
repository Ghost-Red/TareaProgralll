/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.EmployeeDto;
import com.mycompany.tareaws.model.EmployeeEvaluationRelation;
import com.mycompany.tareaws.model.EmployeeEvaluationRelationDto;
import com.mycompany.tareaws.model.EvaluationJobRelationDto;
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
public class EmployeeEvaluationRelationService {

    private static final Logger LOG = Logger.getLogger(EmployeeEvaluationRelationService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getEmployeeEvaluationRelation(Long id) {
        try {
            Query qryEmployeeEvaluationRelation = em.createNamedQuery("EmployeeEvaluationRelation.findById", EmployeeEvaluationRelation.class);
            qryEmployeeEvaluationRelation.setParameter("id", id);
            EmployeeEvaluationRelation employeeEvaluationRelation = (EmployeeEvaluationRelation) qryEmployeeEvaluationRelation.getSingleResult();
            EmployeeEvaluationRelationDto employeeEvaluationRelationDto = new EmployeeEvaluationRelationDto(employeeEvaluationRelation);
            employeeEvaluationRelationDto.setForeignAtributes(employeeEvaluationRelation);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EmployeeEvaluationRelation", employeeEvaluationRelationDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una EmployeeEvaluationRelation con el código ingresado.", "getEmployeeEvaluationRelation NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EmployeeEvaluationRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EmployeeEvaluationRelation.", "getEmployeeEvaluationRelation NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EmployeeEvaluationRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EmployeeEvaluationRelation.", "getEmployeeEvaluationRelation " + ex.getMessage());
        }
    }

    public Respuesta saveEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelationDto) {
        try {
            EmployeeEvaluationRelation employeeEvaluationRelation;
            if (employeeEvaluationRelationDto.getId() != null && employeeEvaluationRelationDto.getId() > 0) {
                employeeEvaluationRelation = em.find(EmployeeEvaluationRelation.class, employeeEvaluationRelationDto.getId());
                if (employeeEvaluationRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EmployeeEvaluationRelation a modificar.", "saveEmployeeEvaluationRelation NoResultException");
                }
                employeeEvaluationRelation.updateEmployeeEvaluationRelation(employeeEvaluationRelationDto);
                employeeEvaluationRelation = em.merge(employeeEvaluationRelation);
            } else {
                employeeEvaluationRelation = new EmployeeEvaluationRelation(employeeEvaluationRelationDto);
                em.persist(employeeEvaluationRelation);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EmployeeEvaluationRelation", new EmployeeEvaluationRelationDto(employeeEvaluationRelation));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EmployeeEvaluationRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la EmployeeEvaluationRelation.", "saveEmployeeEvaluationRelation " + ex.getMessage());
        }
    }

    public Respuesta deleteEmployeeEvaluationRelation(Long id) {
        try {
            EmployeeEvaluationRelation employeeEvaluationRelation;
            if (id != null && id > 0) {
                employeeEvaluationRelation = em.find(EmployeeEvaluationRelation.class, id);
                if (employeeEvaluationRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EmployeeEvaluationRelation a eliminar.", "deleteEmployeeEvaluationRelation NoResultException");
                }
                em.remove(employeeEvaluationRelation);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la EmployeeEvaluationRelation a eliminar.", "deleteEmployeeEvaluationRelation NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la EmployeeEvaluationRelation porque tiene relaciones con otros registros.", "deleteEmployeeEvaluationRelation " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EmployeeEvaluationRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la EmployeeEvaluationRelation.", "deleteEmployeeEvaluationRelation " + ex.getMessage());
        }
    }
}
