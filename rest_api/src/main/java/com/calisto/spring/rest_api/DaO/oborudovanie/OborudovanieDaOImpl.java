package com.calisto.spring.rest_api.DaO.oborudovanie;

import com.calisto.spring.rest_api.entity.Oborudovanie;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OborudovanieDaOImpl implements OborudovanieDaO{
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Oborudovanie> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Oborudovanie>oborudovanieQuery = session.createQuery("from Oborudovanie",
                Oborudovanie.class);
        return oborudovanieQuery.getResultList();
    }

    @Override
    public Oborudovanie add(Oborudovanie oborudovanie) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(oborudovanie);
        return oborudovanie;
    }

    @Override
    public Oborudovanie getOborudovanie(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Oborudovanie.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Oborudovanie oborudovanie = session.get(Oborudovanie.class,id);
        session.delete(oborudovanie);

    }
}
