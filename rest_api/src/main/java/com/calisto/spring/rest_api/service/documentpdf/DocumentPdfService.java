package com.calisto.spring.rest_api.service.documentpdf;

import com.calisto.spring.rest_api.entity.DocumentPdf;

import java.util.List;

public interface DocumentPdfService {
    public List<DocumentPdf> getAll();
    public DocumentPdf add(DocumentPdf documentPdf);
    public DocumentPdf getDocumentPdf(int id);
    public void delete(int id);
}
