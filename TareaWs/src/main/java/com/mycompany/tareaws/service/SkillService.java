/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.Employee;
import com.mycompany.tareaws.model.EmployeeDto;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Respuesta getSkill(Long skillId) {
        try {
            Query qrySkill = em.createNamedQuery("Skill.findBySkillId", Skill.class);
            qrySkill.setParameter("skillId", skillId);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Skill", new SkillDto((Skill) qrySkill.getSingleResult()));

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
    public Respuesta saveSkill(SkillDto skillDto) {
        try {
            Skill skill;
            if (skillDto.getSkillId() != null && skillDto.getSkillId() > 0) {
                skill = em.find(Skill.class, skillDto.getSkillId());
                if (skill == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la skill a modificar.", "saveSkill NoResultException");
                }
                skill.updateSkill(skillDto);
                skill=em.merge(skill);
            } else {
                skill = new Skill(skillDto);
                em.persist(skill);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Skill", new SkillDto(skill));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la skill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la skill.", "saveSkill " + ex.getMessage());
        }
    }
    
    
}
