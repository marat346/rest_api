package com.calisto.spring.rest_api.DaO.document;

import com.calisto.spring.rest_api.entity.document.Document;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DocumentDaOImpl implements DocumentDaO{
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Document> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query <Document> documentQuery = session.createQuery("from Document",
                Document.class);
        List<Document> documentList = documentQuery.getResultList();
        return documentList;
    }

    @Override
    public Document addDocument(Document document) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(document);
        return document;
    }

    @Override
    public Document getDocument(int id) {
        Session session = entityManager.unwrap(Session.class);
        Document doc = session.get(Document.class,id);
        return doc;
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Document doc = session.get(Document.class,id);
        session.delete(doc);
    }
}
