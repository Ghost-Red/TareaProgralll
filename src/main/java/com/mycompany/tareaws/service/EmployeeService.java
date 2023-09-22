/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.Company;
import com.mycompany.tareaws.model.Employee;
import com.mycompany.tareaws.model.EmployeeDto;
import com.mycompany.tareaws.model.Job;
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
public class EmployeeService {

    private static final Logger LOG = Logger.getLogger(EmployeeService.class.getName());

    @PersistenceContext(unitName = "TareaWsPU")
    private EntityManager em;

    private void setForeignsAtributes(Employee employee, EmployeeDto employeeDto) {
        if (employeeDto.getJob().getId() != null) {
            employee.setJob(em.find(Job.class, employeeDto.getJob().getId()));
        }
        if (employeeDto.getCompany().getId() != null) {
            employee.setCompany(em.find(Company.class, employeeDto.getCompany().getId()));
        }
    }

    public Respuesta getEmployee(Long id) {
        try {
            Query qryEmployee = em.createNamedQuery("Employee.findById", Employee.class);
            qryEmployee.setParameter("id", id);
            Employee employee = (Employee) qryEmployee.getSingleResult();
            EmployeeDto employeeDto = new EmployeeDto(employee);
            employeeDto.setForeignAtributes(employee);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Employee", employeeDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un empleado con el código ingresado.", "getEmployee NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmployee NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmployee " + ex.getMessage());
        }
    }

    public Respuesta saveEmployee(EmployeeDto employeeDto) {
        try {
            Employee employee;
            if (employeeDto.getId() != null && employeeDto.getId() > 0) {
                employee = em.find(Employee.class, employeeDto.getId());
                if (employee == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el empleado a modificar.", "guardarEmpleado NoResultException");
                }
                employee.updateEmployee(employeeDto);
                employee = em.merge(employee);
            } else {
                employee = new Employee(employeeDto);
                setForeignsAtributes(employee, employeeDto);
                em.persist(employee);
            }
            em.flush();//si hay error lo marca aqui dentro
            employeeDto.setId(employee.getId());
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Employee", employeeDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta deleteEmployee(Long id) {
        try {
            Employee employee;
            if (id != null && id > 0) {
                employee = em.find(Employee.class, id);
                if (employee == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el empleado a eliminar.", "eliminarEmpleado NoResultException");
                }
                em.remove(employee);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar el empleado a eliminar.", "eliminarEmpleado NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar el empleado porque tiene relaciones con otros registros.", "eliminarEmpleado " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el empleado.", "eliminarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta activateEmployee(Long id) {
        try {
            Employee employee;
            if (id != null && id > 0) {
                employee = em.find(Employee.class, id);
                if (employee == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el empleado a activar.", "activarEmpleado NoResultException");
                }
                employee.setActivatedState("A");
                em.merge(employee);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "no se encontro el empleado", "activarEmpleado NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se activar el empleado.", "activarEmpleado " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al activar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al activar el empleado.", "activarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta validateUser(String email, String password) {
        try {
            Query qryActividad = em.createNamedQuery("Employee.findByEmailPassword", Employee.class);
            qryActividad.setParameter("email", email);
            qryActividad.setParameter("password", password);
            Employee employee = (Employee) qryActividad.getSingleResult();
            EmployeeDto employeeDto = new EmployeeDto(employee);
            employeeDto.setForeignAtributes(employee);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Employee", employeeDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "validarUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validateUser NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validateUser " + ex.getMessage());
        }
    }

}
