package com.calisto.spring.rest_api.DaO.user;

import com.calisto.spring.rest_api.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaOImpl implements UserDaO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<User> userQuery = session.createQuery("from User",
                User.class);
        return userQuery.getResultList();
    }

    @Override
    public User add(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
        return user;
    }

    @Override
    public User getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class,id);
        session.delete(user);
    }
}
