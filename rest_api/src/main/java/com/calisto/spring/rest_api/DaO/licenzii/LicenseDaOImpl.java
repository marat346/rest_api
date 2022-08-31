package com.calisto.spring.rest_api.DaO.licenzii;

import com.calisto.spring.rest_api.entity.License;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LicenseDaOImpl implements LicenseDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<License> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<License>licenseQuery = session.createQuery("from License",
                License.class);
        return licenseQuery.getResultList();
    }

    @Override
    public License add(License license) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(license);
        return license;
    }

    @Override
    public License getLicense(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(License.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        License license = session.get(License.class,id);
        session.delete(license);
    }
}
