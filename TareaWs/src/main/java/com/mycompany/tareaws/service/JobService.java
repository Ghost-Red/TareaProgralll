/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.CompanyDto;
import com.mycompany.tareaws.model.Job;
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
 * @author james
 */
@Stateless
@LocalBean
public class JobService {

    private static final Logger LOG = Logger.getLogger(JobService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getJob(Long id) {
        try {
            Query qryJob = em.createNamedQuery("Job.findByid", Job.class);
            qryJob.setParameter("id", id);
            
            Job job = (Job) qryJob.getSingleResult();
            JobDto jobDto = new JobDto(job);
            jobDto.setCompany( new CompanyDto(job.getcompany()));
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Job", jobDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un puesto con el código ingresado.", "getJob NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el puesto.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el puesto.", "getJob NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el puesto.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el puesto.", "getJob " + ex.getMessage());
        }
    }

    public Respuesta saveJob(JobDto jobDto) {
        try {
            Job job;
            if (jobDto.getId() != null && jobDto.getId() > 0) {
                job = em.find(Job.class, jobDto.getId());
                if (job == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el puesto a modificar.", "saveJob NoResultException");
                }
                job.updateJob(jobDto);
                job = em.merge(job);
            } else {
                job = new Job(jobDto);
                em.persist(job);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Job", new JobDto(job));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el puesto.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el puesto.", "saveJob " + ex.getMessage());
        }
    }

    public Respuesta deleteJob(Long id) {
        try {
            Job job;
            if (id != null && id > 0) {
                job = em.find(Job.class, id);
                if (job == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el puesto a eliminar.", "deleteJob NoResultException");
                }
                em.remove(job);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar el puesto a eliminar.", "deleteJob NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar el puesto porque tiene relaciones con otros registros.", "deleteJob " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el puesto.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el puesto.", "deleteJob " + ex.getMessage());
        }
    }
}
