package com.calisto.spring.rest_api.DaO.prodact;

import com.calisto.spring.rest_api.entity.Prodact;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProdactDaOImpl implements ProdactDaO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Prodact> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Prodact>prodactQuery = session.createQuery("from Prodact",
                Prodact.class);
        return prodactQuery.getResultList();
    }

    @Override
    public Prodact add(Prodact prodact) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(prodact);
        return prodact;
    }

    @Override
    public Prodact getProdact(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Prodact.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Prodact prodact = session.get(Prodact.class,id);
        session.delete(prodact);

    }
}
