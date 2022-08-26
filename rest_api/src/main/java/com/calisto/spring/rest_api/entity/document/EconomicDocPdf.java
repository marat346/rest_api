package com.calisto.spring.rest_api.entity.document;

import com.calisto.spring.rest_api.entity.company.EconomicCompanyDoc;

import javax.persistence.*;
import java.util.List;

// пакет финансовых документов
@Entity
@Table (name = "fin_doc_table")
public class EconomicDocPdf {
    // ИД пакета финансовых документов
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_economic_doc_Pdf;

    // за какой год
    @Column(name = "date_eco_doc")
    private String dataEcoDoc;

    // адрес документа баланс
    @Column(name = "address_doc_balans")
    private String addressDocumentPdfBalans;

    // адрес документа отчёт о финансовых результатах
    @Column(name = "address_doc_statistic_finance")
    private String addressDocumentPdfStatisticFinance;

    // адрес извещение и квитанции о приёме налоговой декларации
    @Column(name = "address_doc_info_cvitanc")
    private String addressDocumentPdfInfoCvitanc;

    // адрес документ расчёт по страховым взносам за предшествующий год
    @Column(name = "address_doc_szvm")
    private String addressDocumentPdfSZV_M;

    // цифровое значение выручки с отчёта о финансовых результатах
    @Column(name = "info_summ")
    private double infoSumm;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_economics_doc",
            joinColumns = @JoinColumn(name = "economic_doc_id"),
            inverseJoinColumns = @JoinColumn(name = "economic_id"))
    private List<EconomicCompanyDoc> economicCompanyDocList;

    public EconomicDocPdf() {
    }

    public List<EconomicCompanyDoc> getEconomicCompanyDocList() {
        return economicCompanyDocList;
    }

    public void setEconomicCompanyDocList(List<EconomicCompanyDoc> economicCompanyDocList) {
        this.economicCompanyDocList = economicCompanyDocList;
    }

    public EconomicDocPdf(String dataEcoDoc,
                          String documentPdfBalans,
                          String documentPdfStatisticFinance,
                          String documentPdfInfoCvitanc,
                          String documentPdfSZV_M,
                          double infoSumm) {
        this.dataEcoDoc = dataEcoDoc;
        this.addressDocumentPdfBalans = documentPdfBalans;
        this.addressDocumentPdfStatisticFinance = documentPdfStatisticFinance;
        this.addressDocumentPdfInfoCvitanc = documentPdfInfoCvitanc;
        this.addressDocumentPdfSZV_M = documentPdfSZV_M;
        this.infoSumm = infoSumm;
    }

    public int getId_economic_doc_Pdf() {
        return id_economic_doc_Pdf;
    }

    public void setId_economic_doc_Pdf(int id_economic_doc_Pdf) {
        this.id_economic_doc_Pdf = id_economic_doc_Pdf;
    }

    public String getDataEcoDoc() {
        return dataEcoDoc;
    }

    public void setDataEcoDoc(String dataEcoDoc) {
        this.dataEcoDoc = dataEcoDoc;
    }

    public String getAddressDocumentPdfBalans() {
        return addressDocumentPdfBalans;
    }

    public void setAddressDocumentPdfBalans(String addressDocumentPdfBalans) {
        this.addressDocumentPdfBalans = addressDocumentPdfBalans;
    }

    public String getAddressDocumentPdfStatisticFinance() {
        return addressDocumentPdfStatisticFinance;
    }

    public void setAddressDocumentPdfStatisticFinance(String addressDocumentPdfStatisticFinance) {
        this.addressDocumentPdfStatisticFinance = addressDocumentPdfStatisticFinance;
    }

    public String getAddressDocumentPdfInfoCvitanc() {
        return addressDocumentPdfInfoCvitanc;
    }

    public void setAddressDocumentPdfInfoCvitanc(String addressDocumentPdfInfoCvitanc) {
        this.addressDocumentPdfInfoCvitanc = addressDocumentPdfInfoCvitanc;
    }

    public String getAddressDocumentPdfSZV_M() {
        return addressDocumentPdfSZV_M;
    }

    public void setAddressDocumentPdfSZV_M(String addressDocumentPdfSZV_M) {
        this.addressDocumentPdfSZV_M = addressDocumentPdfSZV_M;
    }

    public double getInfoSumm() {
        return infoSumm;
    }

    public void setInfoSumm(double infoSumm) {
        this.infoSumm = infoSumm;
    }

    @Override
    public String toString() {
        return "EconomicDocPdf{" +
                "id_economic_doc_Pdf=" + id_economic_doc_Pdf +
                ", dataEcoDoc='" + dataEcoDoc + '\'' +
                ", addressDocumentPdfBalans='" + addressDocumentPdfBalans + '\'' +
                ", addressDocumentPdfStatisticFinance='" + addressDocumentPdfStatisticFinance + '\'' +
                ", addressDocumentPdfInfoCvitanc='" + addressDocumentPdfInfoCvitanc + '\'' +
                ", addressDocumentPdfSZV_M='" + addressDocumentPdfSZV_M + '\'' +
                ", infoSumm=" + infoSumm +
                '}' + "\n";
    }
}
