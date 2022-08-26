package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.document.DocumentPdf;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// учредительные документы
@Entity
@Table(name = "basic_doc_table")
public class BasicDocCompany {

    // ид пакета документов
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id_BasicDocCompany;

    // Список учредителей
    // Указываем информацию (физ лицо или компания)
    // пока не реализуем!надо продумать логику реализиции
    // и какой долей владеет

    // список основных учредительных документов
    // сделать отдельно класс с пакетом документов
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basic_doc",
            joinColumns = @JoinColumn(name = "basic_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_id"))
    List<DocumentPdf> documentPdfList;


    // сумма уставного капитала
    @Column(name = "summ_com")
    double summCompany;

    public BasicDocCompany() {
    }



    public void addNewDoc(DocumentPdf documentPdf){
        if (documentPdfList==null){
            documentPdfList = new ArrayList<>();
        }
        documentPdfList.add(documentPdf);
    }

    public int getId_BasicDocCompany() {
        return id_BasicDocCompany;
    }

    public void setId_BasicDocCompany(int id_BasicDocCompany) {
        this.id_BasicDocCompany = id_BasicDocCompany;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }

    public double getSummCompany() {
        return summCompany;
    }

    public void setSummCompany(double summCompany) {
        this.summCompany = summCompany;
    }

    @Override
    public String toString() {
        return "BasicDocCompany{" +
                "id_BasicDocCompany=" + id_BasicDocCompany +
                ", summCompany=" + summCompany +
                '}' + "\n";
    }
}

