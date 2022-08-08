package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Employee;
import com.calisto.spring.rest_api.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAll();
        return employeeList;
    }
}
