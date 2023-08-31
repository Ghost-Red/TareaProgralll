/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.EvaluationDto;
import com.mycompany.tareaws.model.EvaluationJobRelation;
import com.mycompany.tareaws.model.EvaluationJobRelationDto;
import com.mycompany.tareaws.model.JobDto;
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
public class EvaluationJobRelationService {

    private static final Logger LOG = Logger.getLogger(EvaluationJobRelationService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getEvaluationJobRelation(Long id) {
        try {
            Query qryEvaluationJobRelation = em.createNamedQuery("EvaluationJobRelation.findByid", EvaluationJobRelation.class);
            qryEvaluationJobRelation.setParameter("id", id);

            EvaluationJobRelation evaluationJobRelation = (EvaluationJobRelation) qryEvaluationJobRelation.getSingleResult();
            EvaluationJobRelationDto evaluationJobRelationDto = new EvaluationJobRelationDto(evaluationJobRelation);
            evaluationJobRelationDto.setEvaluation(new EvaluationDto(evaluationJobRelation.getEvaluation()));
            evaluationJobRelationDto.setJob(new JobDto(evaluationJobRelation.getJob()));

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EvaluationJobRelation", evaluationJobRelationDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una EvaluationJobRelation con el código ingresado.", "getEvaluationJobRelation NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EvaluationJobRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EvaluationJobRelation.", "getEvaluationJobRelation NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EvaluationJobRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EvaluationJobRelation.", "getEvaluationJobRelation " + ex.getMessage());
        }
    }

    public Respuesta saveEvaluationJobRelation(EvaluationJobRelationDto evaluationJobRelationDto) {
        try {
            EvaluationJobRelation evaluationJobRelation;
            if (evaluationJobRelationDto.getId() != null && evaluationJobRelationDto.getId() > 0) {
                evaluationJobRelation = em.find(EvaluationJobRelation.class, evaluationJobRelationDto.getId());
                if (evaluationJobRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EvaluationJobRelation a modificar.", "saveEvaluationJobRelation NoResultException");
                }
                evaluationJobRelation.updateEvaluationJobRelation(evaluationJobRelationDto);
                evaluationJobRelation = em.merge(evaluationJobRelation);
            } else {
                evaluationJobRelation = new EvaluationJobRelation(evaluationJobRelationDto);
                em.persist(evaluationJobRelation);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EvaluationJobRelation", new EvaluationJobRelationDto(evaluationJobRelation));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EvaluationJobRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la EvaluationJobRelation.", "saveEvaluationJobRelation " + ex.getMessage());
        }
    }

    public Respuesta deleteEvaluationJobRelation(Long id) {
        try {
            EvaluationJobRelation evaluationJobRelation;
            if (id != null && id > 0) {
                evaluationJobRelation = em.find(EvaluationJobRelation.class, id);
                if (evaluationJobRelation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EvaluationJobRelation a eliminar.", "deleteEvaluationJobRelation NoResultException");
                }
                em.remove(evaluationJobRelation);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la EvaluationJobRelation a eliminar.", "deleteEvaluationJobRelation NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la EvaluationJobRelation porque tiene relaciones con otros registros.", "deleteEvaluationJobRelation " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EvaluationJobRelation.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la EvaluationJobRelation.", "deleteEvaluationJobRelation " + ex.getMessage());
        }
    }
}
