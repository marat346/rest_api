package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.document.Document;
import com.calisto.spring.rest_api.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public Document addDocument(@RequestBody Document document){
        Document doc = documentService.addDocument(document);
        return doc;
    }

    @GetMapping("/get/{id}")
    public Document getDocument(@PathVariable int id){
        Document document = documentService.getDocument(id);
        return document;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        documentService.delete(id);
        return "Удалено";
    }

    @PostMapping("/edit")
    public Document edit(@RequestBody Document document){
        Document doc = documentService.editDocument(document);
        return doc;
    }
}
