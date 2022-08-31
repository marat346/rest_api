package com.calisto.spring.rest_api.DaO.buhdocument;

import com.calisto.spring.rest_api.entity.Buhdocument;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BuhdocumentDaOImpl implements BuhdocumentDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Buhdocument> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query <Buhdocument> buhdocumentQuery = session.createQuery("from Buhdocument",
                Buhdocument.class);
        return buhdocumentQuery.getResultList();
    }

    @Override
    public Buhdocument add(Buhdocument buhdocument) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(buhdocument);
        return buhdocument;
    }

    @Override
    public Buhdocument getBuhdocument(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Buhdocument.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Buhdocument buhdocument = session.get(Buhdocument.class,id);
        session.delete(buhdocument);
    }
}
