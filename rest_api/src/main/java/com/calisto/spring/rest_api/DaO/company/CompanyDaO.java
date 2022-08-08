package com.calisto.spring.rest_api.DaO.company;

import com.calisto.spring.rest_api.entity.Company;

import java.util.List;

public interface CompanyDaO {
    public List<Company> getAll();

    public Company add(Company company);

    public Company getCompany(int id);

    public void delete(int id);
}
