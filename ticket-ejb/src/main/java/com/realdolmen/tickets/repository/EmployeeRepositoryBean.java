package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Employee;
import com.realdolmen.tickets.domain.EmployeeId;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class EmployeeRepositoryBean implements EmployeeRepositoryRemote {

    @PersistenceContext
    protected EntityManager em;
    @Override
    public Employee save(Employee employee) {
        em.persist(employee);
        return employee;
    }

    @Override
    public Employee findById(EmployeeId id) {
        return em.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
