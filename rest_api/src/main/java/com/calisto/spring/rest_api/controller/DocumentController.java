package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Document;
import com.calisto.spring.rest_api.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/all")
    public List<Document> getAllDocument (){
        List<Document> documentList = documentService.getAll();
        return documentList;
    }
}
