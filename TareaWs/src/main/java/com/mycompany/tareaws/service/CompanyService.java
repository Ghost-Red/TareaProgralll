/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.Company;
import com.mycompany.tareaws.model.CompanyDto;
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
public class CompanyService {

    private static final Logger LOG = Logger.getLogger(CompanyService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    public Respuesta getCompany(Long id) {
        try {
            Query qryCompany = em.createNamedQuery("Company.findById", Company.class);
            qryCompany.setParameter("id", id);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Company", new CompanyDto((Company) qryCompany.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe una compañia con el código ingresado.", "getCompany NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la compañia.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la compañia.", "getCompany NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la compañia.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la compañia.", "getCompany " + ex.getMessage());
        }
    }

    public Respuesta saveCompany(CompanyDto companyDto) {
        try {
            Company company;
            if (companyDto.getId() != null && companyDto.getId() > 0) {
                company = em.find(Company.class, companyDto.getId());
                if (company == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la compañia a modificar.", "saveCompany NoResultException");
                }
                company.updateCompany(companyDto);
                company = em.merge(company);
            } else {
                company = new Company(companyDto);
                em.persist(company);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Company", new CompanyDto(company));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la compañia.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la compañia.", "saveCompany " + ex.getMessage());
        }
    }

    public Respuesta deleteCompany(Long id) {
        try {
            Company company;
            if (id != null && id > 0) {
                company = em.find(Company.class, id);
                if (company == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la compañia a eliminar.", "deleteCompany NoResultException");
                }
                em.remove(company);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la compañia a eliminar.", "deleteCompany NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la compañia porque tiene relaciones con otros registros.", "deleteCompany " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la compañia.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar la compañia.", "deleteCompany " + ex.getMessage());
        }
    }
}
