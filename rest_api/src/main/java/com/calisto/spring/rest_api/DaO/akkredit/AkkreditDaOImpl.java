package com.calisto.spring.rest_api.DaO.akkredit;

import com.calisto.spring.rest_api.entity.Akkredit;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class AkkreditDaOImpl implements AkkreditDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Akkredit> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Akkredit> akkreditQuery = session.createQuery("from Akkredit",
                Akkredit.class);
        return akkreditQuery.getResultList();
    }

    @Override
    public Akkredit add(Akkredit akkredit) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(akkredit);
        return akkredit;
    }

    @Override
    public Akkredit getAkkredit(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Akkredit.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Akkredit akkredit = session.get(Akkredit.class, id);
        session.delete(akkredit);
    }
}
