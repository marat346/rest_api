package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.document.DocumentPdfDateInfo;

import javax.persistence.*;
import java.util.List;

// список аккредитаций
@Entity
@Table(name = "akkred_table")
public class AkkredDocsCompany {

    //ид таблицы аккредитаций
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idakkreddocscompany;

    // список аккредитаций
    // имя содержит название организации к кому действует данная аккредитация
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "akkredit_doc_info",
    joinColumns = @JoinColumn(name = "akkredit_id"),
    inverseJoinColumns = @JoinColumn(name = "doc_info_id"))
    private List<DocumentPdfDateInfo> documentPdfDateInfoList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_akkredit",
            joinColumns = @JoinColumn(name = "akkred_doc_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companyList;

    public AkkredDocsCompany() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getIdakkreddocscompany() {
        return idakkreddocscompany;
    }

    public void setIdakkreddocscompany(int idakkreddocscompany) {
        this.idakkreddocscompany = idakkreddocscompany;
    }

    public List<DocumentPdfDateInfo> getDocumentPdfDateInfoList() {
        return documentPdfDateInfoList;
    }

    public void setDocumentPdfDateInfoList(List<DocumentPdfDateInfo> documentPdfDateInfoList) {
        this.documentPdfDateInfoList = documentPdfDateInfoList;
    }

    @Override
    public String toString() {
        return "AkkredDocsCompany{" +
                "idakkreddocscompany=" + idakkreddocscompany +
                '}' + "\n";
    }
}
