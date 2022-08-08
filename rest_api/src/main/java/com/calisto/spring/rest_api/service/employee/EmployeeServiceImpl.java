package com.calisto.spring.rest_api.service.employee;

import com.calisto.spring.rest_api.DaO.employee.EmployeeDaO;
import com.calisto.spring.rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDaO employeeDaO;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDaO.getAll();
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeDaO.addEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDaO.getEmployee(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDaO.delete(id);
    }

    @Override
    @Transactional
    public Employee editEmployee(Employee employee) {
        return employeeDaO.addEmployee(employee);
    }
}
