/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.Company;
import com.mycompany.tareaws.model.CompanyDto;
import com.mycompany.tareaws.model.Job;
import com.mycompany.tareaws.model.JobDto;
import com.mycompany.tareaws.model.Skill;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private void setForeignAtributtes(Job job, JobDto jobDto){
        if (jobDto.getCompany().getId() != null){
            job.setCompany(em.find(Company.class, jobDto.getCompany().getId()));
        }
    }
    public Respuesta getJob(Long id) {
        try {
            Query qryJob = em.createNamedQuery("Job.findById", Job.class);
            qryJob.setParameter("id", id);

            Job job = (Job) qryJob.getSingleResult();
            JobDto jobDto = new JobDto(job);
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
    
    public Respuesta getJobByCompany(Long idCompany) {
        try {
            Query qryJob = em.createNamedQuery("Job.findAll", Job.class);

            List<Job> jobList = new ArrayList<>();
            jobList.addAll(qryJob.getResultList());
            List<JobDto> jobDtoList = new ArrayList<>();
            for (Job job : jobList){
                JobDto jobDto = new JobDto(job);
                jobDto.setCompany(new CompanyDto(job.getCompany()));
                jobDto.setSkillList(job.getSkillList());
                jobDtoList.add(jobDto);
            }
            Stream<JobDto> str = jobDtoList.stream();
            jobDtoList = str.filter(x -> x.getCompany().getId() == idCompany).collect(Collectors.toList());
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "JobList", jobDtoList);
        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una lista de puestos con el código ingresado.", "getJobByCompany NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la lista de puestos.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la lista de puestos.", "getJobByCompany NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la lista de puestos.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la lista de puestos.", "getJobByCompany " + ex.getMessage());
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
                job.getSkillList().clear();
                for (SkillDto skillDto : jobDto.getSkillList()){
                    Skill skill = em.find(Skill.class, skillDto.getId());
                    job.getSkillList().add(skill);
                }
                job = em.merge(job);
            } else {
                job = new Job(jobDto);
                setForeignAtributtes(job, jobDto);
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
