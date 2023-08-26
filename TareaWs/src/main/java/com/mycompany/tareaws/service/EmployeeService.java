/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.service;

import com.mycompany.tareaws.model.Employee;
import com.mycompany.tareaws.model.EmployeeDto;
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

    public Respuesta validateUser(String email, String password) {
        try {
            Query qryActivity = em.createNamedQuery("Employee.findByEmpEmailPassword", Employee.class);
            qryActivity.setParameter("empEmail", email);
            qryActivity.setParameter("empPassword", password);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Empleado", new EmployeeDto((Employee) qryActivity.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "validarUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario " + ex.getMessage());
        }
    }

    public Respuesta getEmployee(Long empId) {
        try {
            Query qryEmployee = em.createNamedQuery("Employee.findByEmpId", Employee.class);
            qryEmployee.setParameter("empId", empId);
            EmployeeDto abc = new EmployeeDto((Employee) qryEmployee.getSingleResult());
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Empleado", new EmployeeDto((Employee) qryEmployee.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un empleado con el código ingresado.", "getEmpleado NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmpleado NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta getEmployees(String cedula, String name, String firstLastName) {
        try {
            Query qryEmployee = em.createNamedQuery("Employee.findByCedulaNameFirstLastName", Employee.class);
            qryEmployee.setParameter("empCedula", cedula);
            qryEmployee.setParameter("empName", name);
            qryEmployee.setParameter("empFirstLastName", firstLastName);

            List<Employee> employees = qryEmployee.getResultList();
            List<EmployeeDto> employeesDto = new ArrayList<>();
            for (Employee empleado : employees) {
                employeesDto.add(new EmployeeDto(empleado));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Empleados", employeesDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen empleados con los criterios ingresados.", "getEmpleados NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta saveEmployee(EmployeeDto employeeDto) {
        try {
            Employee empleado;
            if (employeeDto.getEmpId() != null && employeeDto.getEmpId() > 0) {
                empleado = em.find(Employee.class, employeeDto.getEmpId());
                if (empleado == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el empleado a modificar.", "guardarEmpleado NoResultException");
                }
                empleado.updateEmployee(employeeDto);
                empleado = em.merge(empleado);
            } else {
                empleado = new Employee(employeeDto);
                em.persist(empleado);
            }
            em.flush();//si hay error lo marca aqui dentro
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Empleado", new EmployeeDto(empleado));
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

}
