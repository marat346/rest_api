package com.calisto.spring.rest_api.DaO.documentpdf;

import com.calisto.spring.rest_api.entity.DocumentPdf;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DocumentPdfDaOImpl implements DocumentPdfDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DocumentPdf> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<DocumentPdf> documentPdfQuery = session.createQuery("from DocumentPdf",
                DocumentPdf.class);
        return documentPdfQuery.getResultList();
    }

    @Override
    public DocumentPdf add(DocumentPdf documentPdf) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(documentPdf);
        return documentPdf;
    }

    @Override
    public DocumentPdf getDocumentPdf(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(DocumentPdf.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        DocumentPdf documentPdf = session.get(DocumentPdf.class,id);
        session.delete(documentPdf);
    }
}
