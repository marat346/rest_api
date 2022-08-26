package com.calisto.spring.rest_api.entity.document;

import com.calisto.spring.rest_api.entity.company.BasicDocCompany;
import com.calisto.spring.rest_api.entity.company.EconomicCompanyDoc;
import com.calisto.spring.rest_api.entity.company.PromBezopastnostDoc;
import com.calisto.spring.rest_api.entity.people.Employee;

import javax.persistence.*;
import java.util.List;

// родительский класс для всех документов
@Entity
@Table(name = "document_table")
public class DocumentPdf {

    // ид документа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int iddoc;

    // имя документа
    @Column(name = "name")
    private String name;

    // адрес документа (пока непонятно где и как хранить)
    @Column(name = "address")
    private String address;

    // в статусе отмечается, был ли документ заверен печатью и подписью
    @Column(name = "status")
    private boolean status;

    // необходимо разобраться в классе дата, календарь
    // хз как реализуем класс календарь в БД
    @Column(name = "date")
    private String data;

    // номер документа (может и не быть)
    @Column(name = "number_doc")
    private String numberDoc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basic_doc",
            joinColumns = @JoinColumn(name = "doc_id"),
            inverseJoinColumns = @JoinColumn(name = "basic_id"))
    private List<BasicDocCompany> basicDocCompanyList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_doc_smsp",
            joinColumns = @JoinColumn(name = "doc_smsp_id"),
            inverseJoinColumns = @JoinColumn(name = "economic_id"))
    private List<EconomicCompanyDoc> economicCompanyDocListSmsp;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_spravka_nalog",
            joinColumns = @JoinColumn(name = "doc_spravka_id"),
            inverseJoinColumns = @JoinColumn(name = "economic_id"))
    private List<EconomicCompanyDoc> economicCompanyDocListSpravka;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "economic_doc_status_nalog",
            joinColumns = @JoinColumn(name = "doc_status_nalog"),
            inverseJoinColumns = @JoinColumn(name = "economic_id"))
    private List<EconomicCompanyDoc> economicCompanyDocListStatusN;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_doc_suotipb",
            joinColumns = @JoinColumn(name = "doc_suotipb_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListsuotipb;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_polojenie_sout",
            joinColumns = @JoinColumn(name = "doc_polojenie_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListsPolojenieSoutIpb;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_spis_obuch_pers",
            joinColumns = @JoinColumn(name = "doc_spisos_obuch_pers_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListObuchPers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_akkreds",
            joinColumns = @JoinColumn(name = "doc_akkred_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListAkkred;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_ot",
            joinColumns = @JoinColumn(name = "doc_ot_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListOt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_siz",
            joinColumns = @JoinColumn(name = "doc_siz_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListSiz;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_sout",
            joinColumns = @JoinColumn(name = "doc_sout_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListSout;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_med_osmontr",
            joinColumns = @JoinColumn(name = "doc_med_osmotr_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListMedOsmotr;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_med_kom",
            joinColumns = @JoinColumn(name = "doc_med_kom_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListMedKom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_instruktaj",
            joinColumns = @JoinColumn(name = "doc_instruktaj_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListInstruktaj;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie_doc_doc",
            joinColumns = @JoinColumn(name = "doc_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_oborud_id"))
    private List<OborudovanieDoc> oborudovanieDocList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_pts",
            joinColumns = @JoinColumn(name = "doc_pts_id"),
            inverseJoinColumns = @JoinColumn(name = "transport_id"))
    private List<TransportDoc> transportDocListPts;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_reg",
            joinColumns = @JoinColumn(name = "doc_reg_id"),
            inverseJoinColumns = @JoinColumn(name = "transport_id"))
    private List<TransportDoc> transportDocListReg;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_dopusk",
            joinColumns = @JoinColumn(name = "doc_dopusk_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeeListDopusk;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_doc_car",
            joinColumns = @JoinColumn(name = "doc_car_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeeListDocCar;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_doc_med",
            joinColumns = @JoinColumn(name = "doc_med_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeeListMed;

    public DocumentPdf() {
    }

    public List<BasicDocCompany> getBasicDocCompanyList() {
        return basicDocCompanyList;
    }

    public void setBasicDocCompanyList(List<BasicDocCompany> basicDocCompanyList) {
        this.basicDocCompanyList = basicDocCompanyList;
    }

    public List<EconomicCompanyDoc> getEconomicCompanyDocListSmsp() {
        return economicCompanyDocListSmsp;
    }

    public void setEconomicCompanyDocListSmsp(List<EconomicCompanyDoc> economicCompanyDocListSmsp) {
        this.economicCompanyDocListSmsp = economicCompanyDocListSmsp;
    }

    public List<EconomicCompanyDoc> getEconomicCompanyDocListSpravka() {
        return economicCompanyDocListSpravka;
    }

    public void setEconomicCompanyDocListSpravka(List<EconomicCompanyDoc> economicCompanyDocListSpravka) {
        this.economicCompanyDocListSpravka = economicCompanyDocListSpravka;
    }

    public List<EconomicCompanyDoc> getEconomicCompanyDocListStatusN() {
        return economicCompanyDocListStatusN;
    }

    public void setEconomicCompanyDocListStatusN(List<EconomicCompanyDoc> economicCompanyDocListStatusN) {
        this.economicCompanyDocListStatusN = economicCompanyDocListStatusN;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListsuotipb() {
        return promBezopastnostDocListsuotipb;
    }

    public void setPromBezopastnostDocListsuotipb(List<PromBezopastnostDoc> promBezopastnostDocListsuotipb) {
        this.promBezopastnostDocListsuotipb = promBezopastnostDocListsuotipb;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListsPolojenieSoutIpb() {
        return promBezopastnostDocListsPolojenieSoutIpb;
    }

    public void setPromBezopastnostDocListsPolojenieSoutIpb(List<PromBezopastnostDoc> promBezopastnostDocListsPolojenieSoutIpb) {
        this.promBezopastnostDocListsPolojenieSoutIpb = promBezopastnostDocListsPolojenieSoutIpb;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListObuchPers() {
        return promBezopastnostDocListObuchPers;
    }

    public void setPromBezopastnostDocListObuchPers(List<PromBezopastnostDoc> promBezopastnostDocListObuchPers) {
        this.promBezopastnostDocListObuchPers = promBezopastnostDocListObuchPers;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListAkkred() {
        return promBezopastnostDocListAkkred;
    }

    public void setPromBezopastnostDocListAkkred(List<PromBezopastnostDoc> promBezopastnostDocListAkkred) {
        this.promBezopastnostDocListAkkred = promBezopastnostDocListAkkred;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListOt() {
        return promBezopastnostDocListOt;
    }

    public void setPromBezopastnostDocListOt(List<PromBezopastnostDoc> promBezopastnostDocListOt) {
        this.promBezopastnostDocListOt = promBezopastnostDocListOt;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListSiz() {
        return promBezopastnostDocListSiz;
    }

    public void setPromBezopastnostDocListSiz(List<PromBezopastnostDoc> promBezopastnostDocListSiz) {
        this.promBezopastnostDocListSiz = promBezopastnostDocListSiz;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListSout() {
        return promBezopastnostDocListSout;
    }

    public void setPromBezopastnostDocListSout(List<PromBezopastnostDoc> promBezopastnostDocListSout) {
        this.promBezopastnostDocListSout = promBezopastnostDocListSout;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListMedOsmotr() {
        return promBezopastnostDocListMedOsmotr;
    }

    public void setPromBezopastnostDocListMedOsmotr(List<PromBezopastnostDoc> promBezopastnostDocListMedOsmotr) {
        this.promBezopastnostDocListMedOsmotr = promBezopastnostDocListMedOsmotr;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListMedKom() {
        return promBezopastnostDocListMedKom;
    }

    public void setPromBezopastnostDocListMedKom(List<PromBezopastnostDoc> promBezopastnostDocListMedKom) {
        this.promBezopastnostDocListMedKom = promBezopastnostDocListMedKom;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListInstruktaj() {
        return promBezopastnostDocListInstruktaj;
    }

    public void setPromBezopastnostDocListInstruktaj(List<PromBezopastnostDoc> promBezopastnostDocListInstruktaj) {
        this.promBezopastnostDocListInstruktaj = promBezopastnostDocListInstruktaj;
    }

    public List<OborudovanieDoc> getOborudovanieDocList() {
        return oborudovanieDocList;
    }

    public void setOborudovanieDocList(List<OborudovanieDoc> oborudovanieDocList) {
        this.oborudovanieDocList = oborudovanieDocList;
    }

    public List<TransportDoc> getTransportDocListPts() {
        return transportDocListPts;
    }

    public void setTransportDocListPts(List<TransportDoc> transportDocListPts) {
        this.transportDocListPts = transportDocListPts;
    }

    public List<TransportDoc> getTransportDocListReg() {
        return transportDocListReg;
    }

    public void setTransportDocListReg(List<TransportDoc> transportDocListReg) {
        this.transportDocListReg = transportDocListReg;
    }

    public List<Employee> getEmployeeListDopusk() {
        return employeeListDopusk;
    }

    public void setEmployeeListDopusk(List<Employee> employeeListDopusk) {
        this.employeeListDopusk = employeeListDopusk;
    }

    public List<Employee> getEmployeeListDocCar() {
        return employeeListDocCar;
    }

    public void setEmployeeListDocCar(List<Employee> employeeListDocCar) {
        this.employeeListDocCar = employeeListDocCar;
    }

    public List<Employee> getEmployeeListMed() {
        return employeeListMed;
    }

    public void setEmployeeListMed(List<Employee> employeeListMed) {
        this.employeeListMed = employeeListMed;
    }

    public DocumentPdf(String name, String address, boolean status, String data) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.data = data;
    }

    public DocumentPdf(String name, String address, boolean status, String data, String numberDoc) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.data = data;
        this.numberDoc = numberDoc;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(String numberDoc) {
        this.numberDoc = numberDoc;
    }

    public DocumentPdf(String name, boolean status, String data, String numberDoc) {
        this.name = name;
        this.status = status;
        this.data = data;
        this.numberDoc = numberDoc;
    }

    @Override
    public String toString() {
        return "DocumentPdf{" +
                "iddoc=" + iddoc +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", data='" + data + '\'' +
                ", numberDoc='" + numberDoc + '\'' +
                '}' + "\n";
    }
}
