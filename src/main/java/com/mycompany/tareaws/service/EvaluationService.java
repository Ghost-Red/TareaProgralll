/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.CompanyDto;
import com.mycompany.tareaws.model.Evaluation;
import com.mycompany.tareaws.model.EvaluationDto;
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

/**
 *
 * @author grana
 */
@Stateless
@LocalBean
public class EvaluationService {

    private static final Logger LOG = Logger.getLogger(EvaluationService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getEvaluation(Long id) {
        try {
            Query qryEvaluation = em.createNamedQuery("Evaluation.findById", Evaluation.class);
            qryEvaluation.setParameter("id", id);
            Evaluation evaluation = (Evaluation) qryEvaluation.getSingleResult();
            EvaluationDto evaluationDto = new EvaluationDto(evaluation);
            evaluationDto.setForeignAtributes(evaluation);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Evaluation", evaluationDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una evaluacion con el código ingresado.", "getEvaluation NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la evaluacion.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la evaluacion.", "getEvaluation NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la evaluacion.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la evaluacion.", "getEvaluation " + ex.getMessage());
        }
    }

    public Respuesta saveEvaluation(EvaluationDto evaluationDto) {
        try {
            Evaluation evaluation;
            if (evaluationDto.getId() != null && evaluationDto.getId() > 0) {
                evaluation = em.find(Evaluation.class, evaluationDto.getId());
                if (evaluation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la evaluacion a modificar.", "saveEvaluation NoResultException");
                }
                evaluation.updateEvaluation(evaluationDto);
                evaluation = em.merge(evaluation);
            } else {
                evaluation = new Evaluation(evaluationDto);
                em.persist(evaluation);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Evaluation", new EvaluationDto(evaluation));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la evaluacion.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la evaluacion.", "saveEvaluation " + ex.getMessage());
        }
    }

    public Respuesta deleteEvaluation(Long id) {
        try {
            Evaluation evaluation;
            if (id != null && id > 0) {
                evaluation = em.find(Evaluation.class, id);
                if (evaluation == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la evaluacion a eliminar.", "deleteEvaluation NoResultException");
                }
                em.remove(evaluation);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la evaluacion a eliminar.", "deleteEvaluation NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la evaluacion porque tiene relaciones con otros registros.", "deleteEvaluation " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la evaluacion.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la evaluacion.", "deleteEvaluation " + ex.getMessage());
        }
    }

}
