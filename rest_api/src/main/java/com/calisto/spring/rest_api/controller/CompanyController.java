package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/all")
    public List<Company> getAllCompany (){
        List<Company> companyList = companyService.getAll();
        return companyList;
    }

    @PostMapping("/add")
    public Company addCompany(@RequestBody Company company){
        Company com = companyService.add(company);
        return com;
    }

}
