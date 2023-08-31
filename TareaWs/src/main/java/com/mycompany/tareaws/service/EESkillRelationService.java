/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.EESkillRelation;
import com.mycompany.tareaws.model.EESkillRelationDto;
import com.mycompany.tareaws.model.EmployeeEvaluatorRelationDto;
import com.mycompany.tareaws.model.SkillDto;
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
public class EESkillRelationService {

    private static final Logger LOG = Logger.getLogger(EESkillRelationService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getEESkillRelation(Long id) {
        try {
            Query qryEESkillRelation = em.createNamedQuery("EESkillRelation.findById", EESkillRelation.class);
            qryEESkillRelation.setParameter("id", id);
            EESkillRelation eESkillRelation = (EESkillRelation) qryEESkillRelation.getSingleResult();
            EESkillRelationDto eESkillRelationDto = new EESkillRelationDto(eESkillRelation);
            eESkillRelationDto.setEmployeeEvaluatorRelation(new EmployeeEvaluatorRelationDto(eESkillRelation.getEmployeeEvaluatorRelation()));
            eESkillRelationDto.setEvaluatedSkill(new SkillDto(eESkillRelation.getEvaluatedSkill()));
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EESkillRelation", eESkillRelationDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una EESkillRelation con el código ingresado.", "getEESkillRelation NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EESkillRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EESkillRelation.", "getEESkillRelation NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EESkillRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EESkillRelation.", "getEESkillRelation " + ex.getMessage());
        }
    }

    public Respuesta saveEESkillRelation(EESkillRelationDto eESkillRelationDto) {
        try {
            EESkillRelation eESkillRelation;
            if (eESkillRelationDto.getId() != null && eESkillRelationDto.getId() > 0) {
                eESkillRelation = em.find(EESkillRelation.class, eESkillRelationDto.getId());
                if (eESkillRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EESkillRelation a modificar.", "saveEESkillRelation NoResultException");
                }
                eESkillRelation.updateEESkillRelation(eESkillRelationDto);
                eESkillRelation = em.merge(eESkillRelation);
            } else {
                eESkillRelation = new EESkillRelation(eESkillRelationDto);
                em.persist(eESkillRelation);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EESkillRelation", new EESkillRelationDto(eESkillRelation));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EESkillRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la EESkillRelation.", "saveEESkillRelation " + ex.getMessage());
        }
    }

    public Respuesta deleteEESkillRelation(Long id) {
        try {
            EESkillRelation eESkillRelation;
            if (id != null && id > 0) {
                eESkillRelation = em.find(EESkillRelation.class, id);
                if (eESkillRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EESkillRelation a eliminar.", "deleteEESkillRelation NoResultException");
                }
                em.remove(eESkillRelation);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la EESkillRelation a eliminar.", "deleteEESkillRelation NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la EESkillRelation porque tiene relaciones con otros registros.", "deleteEESkillRelation " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EESkillRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la EESkillRelation.", "deleteEESkillRelation " + ex.getMessage());
        }
    }
}
