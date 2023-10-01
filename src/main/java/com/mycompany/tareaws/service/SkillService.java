/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.Company;
import com.mycompany.tareaws.model.CompanyDto;
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
public class SkillService {

    private static final Logger LOG = Logger.getLogger(SkillService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    private void setForeignAtributtes(Skill skill, SkillDto skillDto){
        if (skillDto.getCompany().getId() != null){
            skill.setCompany(em.find(Company.class, skillDto.getCompany().getId()));
        }
    }
    public Respuesta getSkill(Long id) {
        try {
            Query qrySkill = em.createNamedQuery("Skill.findById", Skill.class);
            qrySkill.setParameter("id", id);
            Skill skill = (Skill) qrySkill.getSingleResult();
            SkillDto skillDto = new SkillDto(skill);
            skillDto.setForeignAtributes(skill);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Skill", skillDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una skill con el código ingresado.", "getSkill NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el skill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la skill.", "getSkill NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el skill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la skill.", "getSkill " + ex.getMessage());
        }
    }
    
    public Respuesta getSkillByCompany(Long idCompany) {
        try {
            Query qrySkill = em.createNamedQuery("Skill.findAll", Skill.class);
            
            List<Skill> skillList = new ArrayList<>();
            skillList.addAll(qrySkill.getResultList());
            List<SkillDto> skillDtoList = new ArrayList<>();
            for (Skill skill : skillList){
                SkillDto skillDto = new SkillDto(skill);
                skillDto.setCompany(new CompanyDto(skill.getCompany()));
                skillDto.setJobList(skill.getJobList());
                skillDtoList.add(skillDto);
            }
            Stream<SkillDto> str = skillDtoList.stream();
            skillDtoList = str.filter(x -> x.getCompany().getId() == idCompany).collect(Collectors.toList());

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "SkillList", skillDtoList);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una list de skills con el código ingresado.", "getSkillByCompany NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la lista de skills.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la list de skills.", "getSkillByCompany NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el skill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la lista de skills.", "getSkillByCompany " + ex.getMessage());
        }
    }
    
    public Respuesta saveSkill(SkillDto skillDto) {
        try {
            Skill skill;
            if (skillDto.getId() != null && skillDto.getId() > 0) {
                skill = em.find(Skill.class, skillDto.getId());
                if (skill == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la skill a modificar.", "saveSkill NoResultException");
                }
                skill.updateSkill(skillDto);
                skill = em.merge(skill);
            } else {
                skill = new Skill(skillDto);
                setForeignAtributtes(skill, skillDto);
                em.persist(skill);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Skill", new SkillDto(skill));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la skill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la skill.", "saveSkill " + ex.getMessage());
        }
    }

    public Respuesta deleteSkill(Long id) {
        try {
            Skill skill;
            if (id != null && id > 0) {
                skill = em.find(Skill.class, id);
                if (skill == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la skill a eliminar.", "eliminarSkill NoResultException");
                }
                em.remove(skill);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la skill a eliminar.", "eliminarSkill NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la skill porque tiene relaciones con otros registros.", "eliminarSkill " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la skill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la skill.", "eliminarSkill " + ex.getMessage());
        }
    }

}
