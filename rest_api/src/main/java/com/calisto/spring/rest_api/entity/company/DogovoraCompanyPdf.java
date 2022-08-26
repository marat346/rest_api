package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.document.DocumentPdfContract;

import javax.persistence.*;
import java.util.List;

// класс содержит список договоров
@Entity
@Table (name = "dogovora_table")
public class DogovoraCompanyPdf {

    // ид договора компании
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int idDogovoraCompany;

    // список договоров по выполнению работ (номер договора, сам доровор)
    // как то надо реализовать работу с бд
    // реализуем через список
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dogovora_genpodradchik",
            joinColumns = @JoinColumn(name = "dogovora_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_genpodradchik"))
    List<DocumentPdfContract> dogovorasgenpodradchikami;

    // список договоров кто нам оказывает услуги (номер договора, сам договор)
    // как то надо эту шляпу реализовать
    // реализуем через список
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dogovora_ispolnitel",
            joinColumns = @JoinColumn(name = "dogovora_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_ispolnitel_id"))
    private List<DocumentPdfContract> dogovorasispolnitelami;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_dogovora",
            joinColumns = @JoinColumn(name = "dogovora_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companyList;

    public DogovoraCompanyPdf() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getIdDogovoraCompany() {
        return idDogovoraCompany;
    }

    public void setIdDogovoraCompany(int idDogovoraCompany) {
        this.idDogovoraCompany = idDogovoraCompany;
    }

    public List<DocumentPdfContract> getDogovorasgenpodradchikami() {
        return dogovorasgenpodradchikami;
    }

    public void setDogovorasgenpodradchikami(List<DocumentPdfContract> dogovorasgenpodradchikami) {
        this.dogovorasgenpodradchikami = dogovorasgenpodradchikami;
    }

    public List<DocumentPdfContract> getDogovorasispolnitelami() {
        return dogovorasispolnitelami;
    }

    public void setDogovorasispolnitelami(List<DocumentPdfContract> dogovorasispolnitelami) {
        this.dogovorasispolnitelami = dogovorasispolnitelami;
    }

    @Override
    public String toString() {
        return "DogovoraCompanyPdf{" +
                "idDogovoraCompany=" + idDogovoraCompany +
                '}' + "\n";
    }
}
