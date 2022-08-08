package com.calisto.spring.rest_api.DaO.employee;

import com.calisto.spring.rest_api.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaOImpl implements EmployeeDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> employeeQuery = session.createQuery("from Employee",
                Employee.class);
        List<Employee> employeeList = employeeQuery.getResultList();
        return employeeList;
    }
}
