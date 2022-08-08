package com.calisto.spring.rest_api.DaO.document;

import com.calisto.spring.rest_api.entity.Document;

import java.util.List;

public interface DocumentDaO {
    public List<Document> getAll();

    public Document addDocument(Document document);

    public Document getDocument(int id);

    public void delete(int id);
}
