package com.calisto.spring.rest_api.service.document;

import com.calisto.spring.rest_api.DaO.document.DocumentDaO;
import com.calisto.spring.rest_api.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    DocumentDaO documentDaO;

    @Override
    @Transactional
    public List<Document> getAll() {
        return documentDaO.getAll();
    }

    @Override
    @Transactional
    public Document addDocument(Document document) {
        return documentDaO.addDocument(document);
    }

    @Override
    @Transactional
    public Document getDocument(int id) {
        return documentDaO.getDocument(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        documentDaO.delete(id);
    }

    @Override
    @Transactional
    public Document editDocument(Document document) {
        Document doc = documentDaO.addDocument(document);
        return doc;
    }
}
