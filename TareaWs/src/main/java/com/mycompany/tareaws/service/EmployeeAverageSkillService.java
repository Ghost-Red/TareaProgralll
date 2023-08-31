/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.EmployeeAverageSkill;
import com.mycompany.tareaws.model.EmployeeAverageSkillDto;
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
public class EmployeeAverageSkillService {

    private static final Logger LOG = Logger.getLogger(EmployeeAverageSkillService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getEmployeeAverageSkill(Long id) {
        try {
            Query qryEmployeeAverageSkill = em.createNamedQuery("EmployeeAverageSkill.findByEasId", EmployeeAverageSkill.class);
            qryEmployeeAverageSkill.setParameter("easId", id);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EmployeeAverageSkill", new EmployeeAverageSkillDto((EmployeeAverageSkill) qryEmployeeAverageSkill.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una EmployeeAverageSkill con el código ingresado.", "getEmployeeAverageSkill NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EmployeeAverageSkill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EmployeeAverageSkill.", "getEmployeeAverageSkill NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la EmployeeAverageSkill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la EmployeeAverageSkill.", "getEmployeeAverageSkill " + ex.getMessage());
        }
    }

    public Respuesta saveEmployeeAverageSkill(EmployeeAverageSkillDto employeeAverageSkillDto) {
        try {
            EmployeeAverageSkill employeeAverageSkill;
            if (employeeAverageSkillDto.getId() != null && employeeAverageSkillDto.getId() > 0) {
                employeeAverageSkill = em.find(EmployeeAverageSkill.class, employeeAverageSkillDto.getId());
                if (employeeAverageSkill == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EmployeeAverageSkill a modificar.", "saveEmployeeAverageSkill NoResultException");
                }
                employeeAverageSkill.updateEmployeeAverageSkill(employeeAverageSkillDto);
                employeeAverageSkill = em.merge(employeeAverageSkill);
            } else {
                employeeAverageSkill = new EmployeeAverageSkill(employeeAverageSkillDto);
                em.persist(employeeAverageSkill);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EmployeeAverageSkill", new EmployeeAverageSkillDto(employeeAverageSkill));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EmployeeAverageSkill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la EmployeeAverageSkill.", "saveEmployeeAverageSkill " + ex.getMessage());
        }
    }

    public Respuesta deleteEmployeeAverageSkill(Long id) {
        try {
            EmployeeAverageSkill employeeAverageSkill;
            if (id != null && id > 0) {
                employeeAverageSkill = em.find(EmployeeAverageSkill.class, id);
                if (employeeAverageSkill == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la EmployeeAverageSkill a eliminar.", "deleteEmployeeAverageSkill NoResultException");
                }
                em.remove(employeeAverageSkill);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la EmployeeAverageSkill a eliminar.", "deleteEmployeeAverageSkill NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la EmployeeAverageSkill porque tiene relaciones con otros registros.", "deleteEmployeeAverageSkill " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la EmployeeAverageSkill.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la EmployeeAverageSkill.", "deleteEmployeeAverageSkill " + ex.getMessage());
        }
    }
}
