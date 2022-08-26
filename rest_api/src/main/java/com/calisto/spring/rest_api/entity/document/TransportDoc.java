package com.calisto.spring.rest_api.entity.document;

import javax.persistence.*;
import java.util.List;

// документ содержит в себе информацию о технике
@Entity
@Table(name = "transport_doc_table")
public class TransportDoc {
    // ид документа о технике
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id_TransportDoc;

    // вид автотранспорт (легковой, грузовой транспорт)
    @Column(name = "vid_transporta")
    private String vidTransporta;

    // название марки
    @Column(name = "name_mark")
    private String nameMark;

    // название модели
    @Column(name = "name_model")
    private String nameModel;

    // статус аренды или нет
    @Column(name = "status_arendi")
    private boolean statusArendi;

    // гос номер
    @Column(name = "gov_number")
    private String govNumber;

    // скан ПТС
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_pts",
            joinColumns = @JoinColumn(name = "transport_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_pts_id"))
    private List<DocumentPdf> documentPdfPts;

    // скан свидетельства о регистрации
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_reg",
            joinColumns = @JoinColumn(name = "transport_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_reg_id"))
    private List<DocumentPdf> documentPdfRegDoc;

    // договор аренды (если техника находится в аренде)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_contract_transport",
            joinColumns = @JoinColumn(name = "transport_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_contract_transport"))
    private List<DocumentPdfContract> documentPdfContractTransport;

    // год выпуска
    @Column(name = "date")
    private String date;

    // % амортизации
    @Column(name = "procent_transport")
    private String procentTransport;

    // примечание (взрывозащищённый или нет) или что то другое
    @Column(name = "ps")
    private String ps;

    // страна производства
    @Column(name = "made_in_contry")
    private String madeInContry;

    public TransportDoc() {
    }

    public List<DocumentPdfContract> getDocumentPdfContractTransport() {
        return documentPdfContractTransport;
    }

    public void setDocumentPdfContractTransport(List<DocumentPdfContract> documentPdfContractTransport) {
        this.documentPdfContractTransport = documentPdfContractTransport;
    }

    public TransportDoc(String vidTransporta,
                        String nameMark,
                        String nameModel,
                        boolean statusArendi,
                        String govNumber,
                        String date,
                        String procentTransport,
                        String ps) {
        this.vidTransporta = vidTransporta;
        this.nameMark = nameMark;
        this.nameModel = nameModel;
        this.statusArendi = statusArendi;
        this.govNumber = govNumber;
        this.date = date;
        this.procentTransport = procentTransport;
        this.ps = ps;
    }

    public int getId_TransportDoc() {
        return id_TransportDoc;
    }

    public void setId_TransportDoc(int id_TransportDoc) {
        this.id_TransportDoc = id_TransportDoc;
    }

    public String getVidTransporta() {
        return vidTransporta;
    }

    public void setVidTransporta(String vidTransporta) {
        this.vidTransporta = vidTransporta;
    }

    public String getNameMark() {
        return nameMark;
    }

    public void setNameMark(String nameMark) {
        this.nameMark = nameMark;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public boolean isStatusArendi() {
        return statusArendi;
    }

    public void setStatusArendi(boolean statusArendi) {
        this.statusArendi = statusArendi;
    }

    public String getGovNumber() {
        return govNumber;
    }

    public void setGovNumber(String govNumber) {
        this.govNumber = govNumber;
    }

    public List<DocumentPdf> getDocumentPdfPts() {
        return documentPdfPts;
    }

    public void setDocumentPdfPts(List<DocumentPdf> documentPdfPts) {
        this.documentPdfPts = documentPdfPts;
    }

    public List<DocumentPdf> getDocumentPdfRegDoc() {
        return documentPdfRegDoc;
    }

    public void setDocumentPdfRegDoc(List<DocumentPdf> documentPdfRegDoc) {
        this.documentPdfRegDoc = documentPdfRegDoc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProcentTransport() {
        return procentTransport;
    }

    public void setProcentTransport(String procentTransport) {
        this.procentTransport = procentTransport;
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
        return "TransportDoc{" +
                "id_TransportDoc=" + id_TransportDoc +
                ", vidTransporta='" + vidTransporta + '\'' +
                ", nameMark='" + nameMark + '\'' +
                ", nameModel='" + nameModel + '\'' +
                ", statusArendi=" + statusArendi +
                ", govNumber='" + govNumber + '\'' +
                ", date='" + date + '\'' +
                ", procentTransport='" + procentTransport + '\'' +
                ", ps='" + ps + '\'' +
                ", madeInContry='" + madeInContry + '\'' +
                '}' + "\n";
    }
}
