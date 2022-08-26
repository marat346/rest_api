package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.document.OborudovanieDoc;

import javax.persistence.*;
import java.util.List;

// документы на оборудование
@Entity
@Table(name = "oborudovanie_info_doc_table")
public class OborudovanieInfoDoc {
    // ид документов на оборудование
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_OborudovanieInfoDoc;

    // список оборудования
    // надо посмотреть магическую реализацию списков в бд
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie_doc_oborudovanie_list",
            joinColumns = @JoinColumn(name = "oborudovanie_id"),
            inverseJoinColumns = @JoinColumn(name = "oborudovanie_doc_list_id"))
    private List<OborudovanieDoc> arrayListOborudovatieDoc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_oborudovanie",
            joinColumns = @JoinColumn(name = "oborudovanie_id_doc"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    List<Company> companyList;

    public OborudovanieInfoDoc() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getId_OborudovanieInfoDoc() {
        return id_OborudovanieInfoDoc;
    }

    public void setId_OborudovanieInfoDoc(int id_OborudovanieInfoDoc) {
        this.id_OborudovanieInfoDoc = id_OborudovanieInfoDoc;
    }

    public List<OborudovanieDoc> getArrayListOborudovatieDoc() {
        return arrayListOborudovatieDoc;
    }

    public void setArrayListOborudovatieDoc(List<OborudovanieDoc> arrayListOborudovatieDoc) {
        this.arrayListOborudovatieDoc = arrayListOborudovatieDoc;
    }

    @Override
    public String toString() {
        return "OborudovanieInfoDoc{" +
                "id_OborudovanieInfoDoc=" + id_OborudovanieInfoDoc +
                '}' + "\n";
    }
}
