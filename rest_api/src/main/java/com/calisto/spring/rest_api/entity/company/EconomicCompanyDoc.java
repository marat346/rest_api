package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.document.DocumentPdf;
import com.calisto.spring.rest_api.entity.document.EconomicDocPdf;

import javax.persistence.*;
import java.util.List;

// бухгалтерские документы
@Entity
@Table(name = "economic_doc_table")
public class EconomicCompanyDoc {
    // ИД бухгалтерских документов
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id_EconomicDocCompany;

    // список бухгалтерских данных по годам
    // надо как то реализовать взаимодействие с бд
    // реализуем через лист
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_economics_doc",
            joinColumns = @JoinColumn(name = "economic_id"),
            inverseJoinColumns = @JoinColumn(name = "economic_doc_id"))
    List<EconomicDocPdf> economicDocPdfListBuh;

    // документы из реестра СМСП
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_doc_smsp",
            joinColumns = @JoinColumn(name = "economic_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_smsp_id"))
    private List<DocumentPdf> documentPdfListSmsp;

    // справка об исполнении налогоплательщиком обязанности по уплате налогов
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_spravka_nalog",
            joinColumns = @JoinColumn(name = "economic_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_spravka_id"))
    private List<DocumentPdf> documentPdfSpravkaInNalog;

    // справка о состоянии расчётов по налогам
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_doc_status_nalog",
            joinColumns = @JoinColumn(name = "economic_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_status_nalog"))
    private List<DocumentPdf> documentPdfSpravkaStatusNalog;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_economic_doc",
            joinColumns = @JoinColumn(name = "economic_doc_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    List<Company> companyList;

    // стоимость активов
    @Column(name = "summ_activ_com")
    double summActivCom;

    public EconomicCompanyDoc() {
    }

    public List<DocumentPdf> getDocumentPdfListSmsp() {
        return documentPdfListSmsp;
    }

    public void setDocumentPdfListSmsp(List<DocumentPdf> documentPdfListSmsp) {
        this.documentPdfListSmsp = documentPdfListSmsp;
    }

    public List<DocumentPdf> getDocumentPdfSpravkaInNalog() {
        return documentPdfSpravkaInNalog;
    }

    public void setDocumentPdfSpravkaInNalog(List<DocumentPdf> documentPdfSpravkaInNalog) {
        this.documentPdfSpravkaInNalog = documentPdfSpravkaInNalog;
    }

    public List<DocumentPdf> getDocumentPdfSpravkaStatusNalog() {
        return documentPdfSpravkaStatusNalog;
    }

    public void setDocumentPdfSpravkaStatusNalog(List<DocumentPdf> documentPdfSpravkaStatusNalog) {
        this.documentPdfSpravkaStatusNalog = documentPdfSpravkaStatusNalog;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getId_EconomicDocCompany() {
        return id_EconomicDocCompany;
    }

    public void setId_EconomicDocCompany(int id_EconomicDocCompany) {
        this.id_EconomicDocCompany = id_EconomicDocCompany;
    }

    public List<EconomicDocPdf> getEconomicDocPdfListBuh() {
        return economicDocPdfListBuh;
    }

    public void setEconomicDocPdfListBuh(List<EconomicDocPdf> economicDocPdfListBuh) {
        this.economicDocPdfListBuh = economicDocPdfListBuh;
    }

    public double getSummActivCom() {
        return summActivCom;
    }

    public void setSummActivCom(double summActivCom) {
        this.summActivCom = summActivCom;
    }

    @Override
    public String toString() {
        return "EconomicCompanyDoc{" +
                "id_EconomicDocCompany=" + id_EconomicDocCompany +
                ", summActivCom=" + summActivCom +
                '}' + "\n";
    }
}
