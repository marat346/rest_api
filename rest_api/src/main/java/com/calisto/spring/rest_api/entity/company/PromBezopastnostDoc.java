package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.document.DocumentPdf;
import com.calisto.spring.rest_api.entity.document.DocumentPdfContract;

import javax.persistence.*;
import java.util.List;

// пакет документов по промышленной безопасности
// тут разные документы, всего по разному и много
// ПБОТОС
@Entity
@Table(name = "prom_bezopastnost_doc_table")
public class PromBezopastnostDoc {
    // ид пакета документов по пром безопастности
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_PromBez;

    // ************************
    // Наличие утверждённой Системы управления охраной труда и промышленной безопасностью
    // СУОТиПБ*

    // Копия документа об утверждения и внедрении СУОТиПБ,
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_doc_suotipb",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_suotipb_id"))
    private List<DocumentPdf> documentPdfSUOTiPB;

    // Копия положения по СУОТиПБ
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_polojenie_sout",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_polojenie_id"))
    private List<DocumentPdf> documentPdfPolojenieSOUTiPB;

    // ************************
    // наличие обученного и аттестованного персонала

    // Список обученного персонала
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_spis_obuch_pers",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_spisok_obuch_pers_id"))
    private List<DocumentPdf> documentPdfSpisokObuchenogoPersonala;

    // Копия действующего договора с аккредитованным учебным центром
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_akkreds",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_akkred_id"))
    private List<DocumentPdf> documentPdfAkrDoc;

    // ***********************
    // Добавляем информацию о отделе по охране труда
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_ot",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_ot_id"))
    private List<DocumentPdf> documentPdfOt;

    // ***********************
    // Обеспечение работников, требуемых к привлечению для оказания услуг СИЗ

    // Подтверждение организации по учёту и наличию СИЗ
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_siz",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_siz_id"))
    private List<DocumentPdf> documentPdfSiz;

    // Действующий итоговый прокол по результатам СОУТ
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_sout",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_sout_id"))
    private List<DocumentPdf> documentPdfSOUT;

    // ***********************
    // Прохождение мед комиссий

    // Копия последнего заключительного акта прохождения медосмотра
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_med_osmotr",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_med_osmotr_id"))
    private List<DocumentPdf> documentPdfMedOsmotr;

    // Справка участника закупки (список сотрудников прошедших мед комиссию)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_med_kom",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_med_kom_id"))
    private List<DocumentPdf> documentPdfSpisokMedKomissii;


    // Наличие инструкций по профессиям и видам работ
    // Перечень имеющихся инструкций и программ инструктажей
    // пишем отдельно класс где указываем список нужных нам документов!!!
    // реализуем в листе (имя документа носит информацию по профессии)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_instruktaj",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_instruktaj_id"))
    private List<DocumentPdf> arrayListInstruktaj;

    // ***********************
    // Организация проведения предрейсового и послерейсового медицинского осмотра водителей

    // Копия договора с медицинской организацией на проведение предрейсовых/послерейсовых медосмотров
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_contract_med",
            joinColumns = @JoinColumn(name = "prombez_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_contract_med_id"))
    private List<DocumentPdfContract> documentPdfContractMedosmotrVoditelei;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_prombez",
            joinColumns = @JoinColumn(name = "prombez_id_doc"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companyList;

    public PromBezopastnostDoc() {
    }

    public List<DocumentPdf> getDocumentPdfSUOTiPB() {
        return documentPdfSUOTiPB;
    }

    public void setDocumentPdfSUOTiPB(List<DocumentPdf> documentPdfSUOTiPB) {
        this.documentPdfSUOTiPB = documentPdfSUOTiPB;
    }

    public List<DocumentPdf> getDocumentPdfPolojenieSOUTiPB() {
        return documentPdfPolojenieSOUTiPB;
    }

    public void setDocumentPdfPolojenieSOUTiPB(List<DocumentPdf> documentPdfPolojenieSOUTiPB) {
        this.documentPdfPolojenieSOUTiPB = documentPdfPolojenieSOUTiPB;
    }

    public List<DocumentPdf> getDocumentPdfSpisokObuchenogoPersonala() {
        return documentPdfSpisokObuchenogoPersonala;
    }

    public void setDocumentPdfSpisokObuchenogoPersonala(List<DocumentPdf> documentPdfSpisokObuchenogoPersonala) {
        this.documentPdfSpisokObuchenogoPersonala = documentPdfSpisokObuchenogoPersonala;
    }

    public List<DocumentPdf> getDocumentPdfAkrDoc() {
        return documentPdfAkrDoc;
    }

    public void setDocumentPdfAkrDoc(List<DocumentPdf> documentPdfAkrDoc) {
        this.documentPdfAkrDoc = documentPdfAkrDoc;
    }

    public List<DocumentPdf> getDocumentPdfOt() {
        return documentPdfOt;
    }

    public void setDocumentPdfOt(List<DocumentPdf> documentPdfOt) {
        this.documentPdfOt = documentPdfOt;
    }

    public List<DocumentPdf> getDocumentPdfSiz() {
        return documentPdfSiz;
    }

    public void setDocumentPdfSiz(List<DocumentPdf> documentPdfSiz) {
        this.documentPdfSiz = documentPdfSiz;
    }

    public List<DocumentPdf> getDocumentPdfSOUT() {
        return documentPdfSOUT;
    }

    public void setDocumentPdfSOUT(List<DocumentPdf> documentPdfSOUT) {
        this.documentPdfSOUT = documentPdfSOUT;
    }

    public List<DocumentPdf> getDocumentPdfMedOsmotr() {
        return documentPdfMedOsmotr;
    }

    public void setDocumentPdfMedOsmotr(List<DocumentPdf> documentPdfMedOsmotr) {
        this.documentPdfMedOsmotr = documentPdfMedOsmotr;
    }

    public List<DocumentPdf> getDocumentPdfSpisokMedKomissii() {
        return documentPdfSpisokMedKomissii;
    }

    public void setDocumentPdfSpisokMedKomissii(List<DocumentPdf> documentPdfSpisokMedKomissii) {
        this.documentPdfSpisokMedKomissii = documentPdfSpisokMedKomissii;
    }

    public List<DocumentPdfContract> getDocumentPdfContractMedosmotrVoditelei() {
        return documentPdfContractMedosmotrVoditelei;
    }

    public void setDocumentPdfContractMedosmotrVoditelei(List<DocumentPdfContract> documentPdfContractMedosmotrVoditelei) {
        this.documentPdfContractMedosmotrVoditelei = documentPdfContractMedosmotrVoditelei;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getId_PromBez() {
        return id_PromBez;
    }

    public void setId_PromBez(int id_PromBez) {
        this.id_PromBez = id_PromBez;
    }

    public List<DocumentPdf> getArrayListInstruktaj() {
        return arrayListInstruktaj;
    }

    public void setArrayListInstruktaj(List<DocumentPdf> arrayListInstruktaj) {
        this.arrayListInstruktaj = arrayListInstruktaj;
    }

    @Override
    public String toString() {
        return "PromBezopastnostDoc{" +
                "id_PromBez=" + id_PromBez +
                '}' + "\n";
    }
}
