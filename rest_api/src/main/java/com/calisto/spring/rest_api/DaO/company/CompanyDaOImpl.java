package com.calisto.spring.rest_api.DaO.company;

import com.calisto.spring.rest_api.entity.company.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CompanyDaOImpl implements CompanyDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Company> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Company> companyQuery = session.createQuery("from Company",
                Company.class);
        List<Company> companyList = companyQuery.getResultList();
        return companyList;
    }

    @Override
    public Company add(Company company) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(company);
        return company;
    }

    @Override
    public Company getCompany(int id) {
        Session session = entityManager.unwrap(Session.class);
        Company company = session.get(Company.class,id);
        return company;
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Company company = session.get(Company.class,id);
        session.delete(company);
    }

}
