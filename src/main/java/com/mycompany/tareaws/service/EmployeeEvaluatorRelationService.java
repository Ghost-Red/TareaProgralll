/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.Employee;
import com.mycompany.tareaws.model.EmployeeDto;
import com.mycompany.tareaws.model.EmployeeEvaluationRelation;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private void setForeignAtributtes(EmployeeEvaluatorRelation employeeEvaluatorRelation, EmployeeEvaluatorRelationDto employeeEvaluatorRelationDto){
        if (employeeEvaluatorRelationDto.getEmployeeEvaluator().getId() != null){
            employeeEvaluatorRelation.setEmployeeEvaluator(em.find(Employee.class, employeeEvaluatorRelationDto.getEmployeeEvaluator().getId()));
        }
        if (employeeEvaluatorRelationDto.getEmployeeEvaluated().getId() != null){
            employeeEvaluatorRelation.setEmployeeEvaluated(em.find(EmployeeEvaluationRelation.class, employeeEvaluatorRelationDto.getEmployeeEvaluated().getId()));
        }
    }
    
    public Respuesta getEmployeeEvaluatorRelation(Long id) {
        try {
            Query qryEmployeeEvaluatorRelation = em.createNamedQuery("EmployeeEvaluatorRelation.findById", EmployeeEvaluatorRelation.class);
            qryEmployeeEvaluatorRelation.setParameter("id", id);
            EmployeeEvaluatorRelation employeeEvaluatorRelation = (EmployeeEvaluatorRelation) qryEmployeeEvaluatorRelation.getSingleResult();
            EmployeeEvaluatorRelationDto employeeEvaluatorRelationDto = new EmployeeEvaluatorRelationDto(employeeEvaluatorRelation);
            employeeEvaluatorRelationDto.setForeignAtributes(employeeEvaluatorRelation);
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
    
    public Respuesta getEmployeeEvaluatorRelationByEmployeeEvaluationRelation(Long idEmployeeEvaluationRelation) {
        try {
            Query qryEmployeeEvaluatorRelation = em.createNamedQuery("EmployeeEvaluatorRelation.findAll", EmployeeEvaluatorRelation.class);
            
            List<EmployeeEvaluatorRelation> employeeEvaluatorRelationList = new ArrayList();
            employeeEvaluatorRelationList.addAll(qryEmployeeEvaluatorRelation.getResultList());
            List<EmployeeEvaluatorRelationDto> employeeEvaluatorRelationDtoList = new ArrayList();
            for (EmployeeEvaluatorRelation employeeEvaluatorRelation : employeeEvaluatorRelationList){
                EmployeeEvaluatorRelationDto employeeEvaluatorRelationDto = new EmployeeEvaluatorRelationDto(employeeEvaluatorRelation);
                employeeEvaluatorRelationDto.setEmployeeEvaluated(new EmployeeEvaluationRelationDto(employeeEvaluatorRelation.getEmployeeEvaluated()));
                employeeEvaluatorRelationDto.setEmployeeEvaluator(new EmployeeDto(employeeEvaluatorRelation.getEmployeeEvaluator()));
                employeeEvaluatorRelationDtoList.add(employeeEvaluatorRelationDto);
            }
            
            Stream<EmployeeEvaluatorRelationDto> str = employeeEvaluatorRelationDtoList.stream();
            employeeEvaluatorRelationDtoList = str.filter(x -> x.getEmployeeEvaluated().getId() == idEmployeeEvaluationRelation)
                    .collect(Collectors.toList());
            
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EmployeeEvaluatorRelationList", employeeEvaluatorRelationDtoList);
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
                setForeignAtributtes(employeeEvaluatorRelation, employeeEvaluatorRelationDto);
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
