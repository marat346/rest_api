package com.calisto.spring.rest_api.service.employee;

import com.calisto.spring.rest_api.entity.people.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();

    public Employee addEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void delete(int id);

    public Employee editEmployee(Employee employee);
}
