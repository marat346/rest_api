package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String endDate;
    private String innZakaz;
    private String innIspolnitel;
    private String summ;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "contract_docs",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> documentPdfList;

    public Contract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInnZakaz() {
        return innZakaz;
    }

    public void setInnZakaz(String innZakaz) {
        this.innZakaz = innZakaz;
    }

    public String getInnIspolnitel() {
        return innIspolnitel;
    }

    public void setInnIspolnitel(String innIspolnitel) {
        this.innIspolnitel = innIspolnitel;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }
}
