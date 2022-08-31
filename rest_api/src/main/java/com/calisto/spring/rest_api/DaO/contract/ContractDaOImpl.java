package com.calisto.spring.rest_api.DaO.contract;

import com.calisto.spring.rest_api.entity.Contract;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ContractDaOImpl implements ContractDaO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Contract> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Contract> contractQuery = session.createQuery("from Contract",
                Contract.class) ;
        return contractQuery.getResultList();
    }

    @Override
    public Contract add(Contract contract) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(contract);
        return contract;
    }

    @Override
    public Contract getContract(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Contract.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Contract contract = session.get(Contract.class,id);
        session.delete(contract);
    }
}
