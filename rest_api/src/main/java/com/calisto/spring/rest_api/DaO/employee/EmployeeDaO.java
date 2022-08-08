package com.calisto.spring.rest_api.DaO.employee;

import com.calisto.spring.rest_api.entity.Employee;

import java.util.List;

public interface EmployeeDaO {
    public List<Employee> getAll();

    public Employee addEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void delete(int id);
}
