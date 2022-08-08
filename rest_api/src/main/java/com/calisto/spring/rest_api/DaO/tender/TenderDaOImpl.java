package com.calisto.spring.rest_api.DaO.tender;

import com.calisto.spring.rest_api.entity.Tender;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TenderDaOImpl implements TenderDaO{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Tender> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query <Tender> tenderQuery = session.createQuery("from Tender",
                Tender.class);
        List<Tender> tenderList = tenderQuery.getResultList();
        return tenderList;
    }

    @Override
    public Tender addTender(Tender tender) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(tender);
        return tender;
    }

    @Override
    public Tender getTender(int id) {
        Session session = entityManager.unwrap(Session.class);
        Tender tender = session.get(Tender.class,id);
        return tender;
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Tender tender = session.get(Tender.class,id);
        session.delete(tender);
    }
}
