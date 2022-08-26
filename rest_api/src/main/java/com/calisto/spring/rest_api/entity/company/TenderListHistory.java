package com.calisto.spring.rest_api.entity.company;

import javax.persistence.*;
import java.util.List;

// содержит информацию по ранее сформированным документам для тендеров
@Entity
@Table(name = "tender_history_table")
public class TenderListHistory {
    // ид истории тендеров
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_Tender_History;

    // добавляем лист тендеров
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tender_history_tenders",
            joinColumns = @JoinColumn(name = "tender_history_id"),
            inverseJoinColumns = @JoinColumn(name = "tender_id"))
    private List<Tender> arrayListTenders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_tender_history",
            joinColumns = @JoinColumn(name = "tender_history_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companyList;

    public TenderListHistory() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getId_Tender_History() {
        return id_Tender_History;
    }

    public void setId_Tender_History(int id_Tender_History) {
        this.id_Tender_History = id_Tender_History;
    }

    public List<Tender> getArrayListTenders() {
        return arrayListTenders;
    }

    public void setArrayListTenders(List<Tender> arrayListTenders) {
        this.arrayListTenders = arrayListTenders;
    }

    @Override
    public String toString() {
        return "TenderListHistory{" +
                "id_Tender_History=" + id_Tender_History +
                '}' + "\n";
    }
}
