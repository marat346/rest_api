package com.calisto.spring.rest_api.entity.document;

import com.calisto.spring.rest_api.entity.company.OborudovanieInfoDoc;

import javax.persistence.*;
import java.util.List;

// содержит основную информацию по оборудованию
@Entity
@Table(name = "oborudovanie_doc_table")
public class OborudovanieDoc {

    // ид оборудования
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_oborudovanie;

    // вид оборудования
    @Column(name = "name_vid_oborudovania")
    private String nameVidOborudovania;

    // модель оборудования
    @Column(name = "name_model")
    private String nameModel;

    // название оборудования
    @Column(name = "name_oborudovanie")
    private String nameOborudovanie;

    // статус в аренде или нет оборудование
    @Column(name = "status_arenda")
    private boolean statusArenda;

    // скан паспорта на оборудование
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie_doc_doc",
            joinColumns = @JoinColumn(name = "doc_oborud_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_id"))
    private List<DocumentPdf> documentPdfOborudovanie;

    // скан договора аренды
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie_doc_oborudovanie",
            joinColumns = @JoinColumn(name = "oborudovanie_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_oborudovanie_id_contr"))
    private List<DocumentPdfContract> documentPdfContractOborudovanie;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie_doc_oborudovanie_list",
            joinColumns = @JoinColumn(name = "oborudovanie_doc_list_id"),
            inverseJoinColumns = @JoinColumn(name = "oborudovanie_id"))
    private List<OborudovanieInfoDoc> oborudovanieInfoDocList;

    // дата производста
    // надо реализовать работу дат с бд
    @Column(name = "date")
    private String data;

    // % аммортизации
    @Column(name = "procent_ammortizacii")
    private String procentAmmortizacii;

    // примечание (взрывозащищённый или нет) или что то другое
    @Column(name = "ps")
    private String ps;

    // страна производства
    @Column(name = "made_in_contry")
    private String madeInContry;

    public OborudovanieDoc() {
    }

    public List<DocumentPdfContract> getDocumentPdfContractOborudovanie() {
        return documentPdfContractOborudovanie;
    }

    public void setDocumentPdfContractOborudovanie(List<DocumentPdfContract> documentPdfContractOborudovanie) {
        this.documentPdfContractOborudovanie = documentPdfContractOborudovanie;
    }

    public List<OborudovanieInfoDoc> getOborudovanieInfoDocList() {
        return oborudovanieInfoDocList;
    }

    public void setOborudovanieInfoDocList(List<OborudovanieInfoDoc> oborudovanieInfoDocList) {
        this.oborudovanieInfoDocList = oborudovanieInfoDocList;
    }

    public OborudovanieDoc(String nameVidOborudovania,
                           String nameModel,
                           String nameOborudovanie,
                           boolean statusArenda,
                           String data,
                           String procentAmmortizacii,
                           String ps) {
        this.nameVidOborudovania = nameVidOborudovania;
        this.nameModel = nameModel;
        this.nameOborudovanie = nameOborudovanie;
        this.statusArenda = statusArenda;
        this.data = data;
        this.procentAmmortizacii = procentAmmortizacii;
        this.ps = ps;
    }

    public int getId_oborudovanie() {
        return id_oborudovanie;
    }

    public void setId_oborudovanie(int id_oborudovanie) {
        this.id_oborudovanie = id_oborudovanie;
    }

    public String getNameVidOborudovania() {
        return nameVidOborudovania;
    }

    public void setNameVidOborudovania(String nameVidOborudovania) {
        this.nameVidOborudovania = nameVidOborudovania;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getNameOborudovanie() {
        return nameOborudovanie;
    }

    public void setNameOborudovanie(String nameOborudovanie) {
        this.nameOborudovanie = nameOborudovanie;
    }

    public boolean isStatusArenda() {
        return statusArenda;
    }

    public void setStatusArenda(boolean statusArenda) {
        this.statusArenda = statusArenda;
    }

    public List<DocumentPdf> getDocumentPdfOborudovanie() {
        return documentPdfOborudovanie;
    }

    public void setDocumentPdfOborudovanie(List<DocumentPdf> documentPdfOborudovanie) {
        this.documentPdfOborudovanie = documentPdfOborudovanie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProcentAmmortizacii() {
        return procentAmmortizacii;
    }

    public void setProcentAmmortizacii(String procentAmmortizacii) {
        this.procentAmmortizacii = procentAmmortizacii;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getMadeInContry() {
        return madeInContry;
    }

    public void setMadeInContry(String madeInContry) {
        this.madeInContry = madeInContry;
    }

    @Override
    public String toString() {
        return "OborudovanieDoc{" +
                "id_oborudovanie=" + id_oborudovanie +
                ", nameVidOborudovania='" + nameVidOborudovania + '\'' +
                ", nameModel='" + nameModel + '\'' +
                ", nameOborudovanie='" + nameOborudovanie + '\'' +
                ", statusArenda=" + statusArenda +
                ", data='" + data + '\'' +
                ", procentAmmortizacii='" + procentAmmortizacii + '\'' +
                ", ps='" + ps + '\'' +
                ", madeInContry='" + madeInContry + '\'' +
                '}' + "\n";
    }
}
