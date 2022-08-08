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
}
