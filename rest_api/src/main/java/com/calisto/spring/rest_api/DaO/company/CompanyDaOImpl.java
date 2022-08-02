package com.calisto.spring.rest_api.DaO.company;

import com.calisto.spring.rest_api.entity.Company;
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
        session.save(company);
        return null;
    }


}
