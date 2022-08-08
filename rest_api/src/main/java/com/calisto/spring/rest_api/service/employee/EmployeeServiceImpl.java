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
}
