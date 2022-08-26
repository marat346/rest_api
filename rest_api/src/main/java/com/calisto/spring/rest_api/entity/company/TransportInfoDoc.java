package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.document.TransportDoc;

import javax.persistence.*;
import java.util.List;

// документы на транспорт
@Entity
@Table(name = "transport_info_doc_table")
public class TransportInfoDoc {
    // ид документов на транспорт
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_TransportInfoDoc;

    // список автотранспорта для перевозки пассажиров и грузов
    // реализуем магию работы списков с бд
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_info_transport",
            joinColumns = @JoinColumn(name = "transport_info_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_transport_id"))
    private List<TransportDoc> arrayListTransportDoc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_transport",
            joinColumns = @JoinColumn(name = "transport_doc_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companyList;

    public TransportInfoDoc() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getId_TransportInfoDoc() {
        return id_TransportInfoDoc;
    }

    public void setId_TransportInfoDoc(int id_TransportInfoDoc) {
        this.id_TransportInfoDoc = id_TransportInfoDoc;
    }

    public List<TransportDoc> getArrayListTransportDoc() {
        return arrayListTransportDoc;
    }

    public void setArrayListTransportDoc(List<TransportDoc> arrayListTransportDoc) {
        this.arrayListTransportDoc = arrayListTransportDoc;
    }

    @Override
    public String toString() {
        return "TransportInfoDoc{" +
                "id_TransportInfoDoc=" + id_TransportInfoDoc +
                '}' + "\n";
    }
}
