package com.calisto.spring.rest_api.entity.company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tenders_table")
public class Tender {

    // ид тендера
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idtender;

    // номер тендера
    @Column(name = "number_tender")
    private String numberTender;

    // Общее название тендера
    @Column(name = "name_tender")
    private String nameTender;

    // добавляем список лотов
    // пока незнаю как реализовать
    // надо подумать как это удобнее сделать

    // Компания организатор, на кого оформляем документы
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tender_company",
            joinColumns = @JoinColumn(name = "tender_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id_tender"))
    private List<Company> company;

    // адрес пакета документов сформированного для подачи заявки (главная папка)
    @Column(name = "address_generator_doc")
    private String addressGeneratorDoc;

    // обобщённое название видов работ, товаров или услуг
    // к примеру: Чистка оборудования, Доставка офсетной бумаги и прочее.
    @Column(name = "name_vid_rabot")
    private String nameVidRabot;

    // способ закупки
    @Column(name = "name_sposob_zakupki")
    private String nameSposobZakupki;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tender_history_tenders",
            joinColumns = @JoinColumn(name = "tender_id"),
            inverseJoinColumns = @JoinColumn(name = "tender_history_id"))
    private List<TenderListHistory> tenderListHistoryList;

    public Tender() {
    }

    public List<TenderListHistory> getTenderListHistoryList() {
        return tenderListHistoryList;
    }

    public void setTenderListHistoryList(List<TenderListHistory> tenderListHistoryList) {
        this.tenderListHistoryList = tenderListHistoryList;
    }

    public int getIdtender() {
        return idtender;
    }

    public void setIdtender(int idtender) {
        this.idtender = idtender;
    }

    public String getNumberTender() {
        return numberTender;
    }

    public void setNumberTender(String numberTender) {
        this.numberTender = numberTender;
    }

    public String getNameTender() {
        return nameTender;
    }

    public void setNameTender(String nameTender) {
        this.nameTender = nameTender;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }

    public String getAddressGeneratorDoc() {
        return addressGeneratorDoc;
    }

    public void setAddressGeneratorDoc(String addressGeneratorDoc) {
        this.addressGeneratorDoc = addressGeneratorDoc;
    }

    public String getNameVidRabot() {
        return nameVidRabot;
    }

    public void setNameVidRabot(String nameVidRabot) {
        this.nameVidRabot = nameVidRabot;
    }

    public String getNameSposobZakupki() {
        return nameSposobZakupki;
    }

    public void setNameSposobZakupki(String nameSposobZakupki) {
        this.nameSposobZakupki = nameSposobZakupki;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "idtender=" + idtender +
                ", numberTender='" + numberTender + '\'' +
                ", nameTender='" + nameTender + '\'' +
                ", addressGeneratorDoc='" + addressGeneratorDoc + '\'' +
                ", nameVidRabot='" + nameVidRabot + '\'' +
                ", nameSposobZakupki='" + nameSposobZakupki + '\'' +
                '}' + "\n";
    }
}
