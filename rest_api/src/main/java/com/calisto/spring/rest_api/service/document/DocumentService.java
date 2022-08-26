package com.calisto.spring.rest_api.service.document;

import com.calisto.spring.rest_api.entity.document.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> getAll();

    Document addDocument(Document document);

    public Document getDocument(int id);

    public void delete(int id);

    public Document editDocument(Document document);
}
