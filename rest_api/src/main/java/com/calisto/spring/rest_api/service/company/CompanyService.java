package com.calisto.spring.rest_api.service.company;

import com.calisto.spring.rest_api.entity.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> getAll();

    public Company add(Company company);
}
