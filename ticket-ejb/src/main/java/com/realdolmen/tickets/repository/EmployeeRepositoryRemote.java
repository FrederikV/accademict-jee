package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Employee;
import com.realdolmen.tickets.domain.EmployeeId;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
@Remote
public interface EmployeeRepositoryRemote {
    Employee save(Employee employee);
    Employee findById(EmployeeId id);
    List<Employee> findAll();
}
