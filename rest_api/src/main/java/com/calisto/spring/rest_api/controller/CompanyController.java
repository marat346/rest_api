package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.communication.CompanyInfo;
import com.calisto.spring.rest_api.entity.company.Company;
import com.calisto.spring.rest_api.service.company.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/calisto/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyInfo companyInfo;

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

    @GetMapping("/get/{id}")
    public Company getCompany(@PathVariable int id){
    Company company = companyService.getCompany(id);
    return company;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        companyService.delete(id);
        return "Удалено!";
    }

    @PostMapping("/edit")
    public Company editCompany(@RequestBody Company company){
        Company com = companyService.editCompany(company);
        return com;
    }

    @GetMapping("/add/{inn}")
    public Company getCompany(@PathVariable String inn) throws JsonProcessingException, ParseException, UnsupportedEncodingException {
        Company company = companyInfo.getCompanyInfo(inn);
//        return companyService.add(company);
        return null;
    }
}
