package com.calisto.spring.rest_api.service.company;

import com.calisto.spring.rest_api.entity.company.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> getAll();

    public Company add(Company company);

    public Company getCompany(int id);

    public void delete(int id);

    public Company editCompany(Company company);
}
