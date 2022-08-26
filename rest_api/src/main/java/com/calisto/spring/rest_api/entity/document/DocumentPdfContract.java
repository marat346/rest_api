package com.calisto.spring.rest_api.entity.document;

import com.calisto.spring.rest_api.entity.company.Company;
import com.calisto.spring.rest_api.entity.company.DogovoraCompanyPdf;
import com.calisto.spring.rest_api.entity.company.OborudovanieInfoDoc;
import com.calisto.spring.rest_api.entity.company.PromBezopastnostDoc;
import com.calisto.spring.rest_api.entity.people.Employee;

import javax.persistence.*;
import java.util.List;

// расширяем класс документ до документ Договор
@Entity
@Table(name = "documents_contract_table")

public class DocumentPdfContract{

    // ид документа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int iddoc;

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

    // первый объект договора (заказчик) пока думаем кого сюда засунуть
    // сюда добавляем реализацию магии стрелок на другие объеты других бд
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_one")
    private Company oneObject;

    // второй объект договора (исполнитель) пока думаем кого сюда засунуть
    // сюда добавляем реализацию магии стрелок на другие объеты других бд
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_two")
    private Company twoObject;

    // дата начала договора

    @Column(name = "start_date")
    private String startDate;

    // дата окончания договра
    @Column(name = "end_date")
    private String endDate;

    // сумма договора
    @Column(name = "money_contract")
    private double moneyContract;

    // надо указать вид работ, товара или услуг
    @Column(name = "work")
    private String work;

    // роль в договоре
    @Column (name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dogovora_genpodradchik",
            joinColumns = @JoinColumn(name = "doc_genpodradchik"),
            inverseJoinColumns = @JoinColumn(name = "dogovora_id"))
    private List<DogovoraCompanyPdf> dogovoraCompanyPdfListGenPodr;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dogovora_ispolnitel",
            joinColumns = @JoinColumn(name = "doc_ispolnitel_id"),
            inverseJoinColumns = @JoinColumn(name = "dogovora_id"))
    private List<DogovoraCompanyPdf> dogovoraCompanyPdfListIspolnitel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prombez_contract_med",
            joinColumns = @JoinColumn(name = "doc_contract_med_id"),
            inverseJoinColumns = @JoinColumn(name = "prombez_id"))
    private List<PromBezopastnostDoc> promBezopastnostDocListContract;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie_doc_oborudovanie",
            joinColumns = @JoinColumn(name = "doc_oborudovanie_id_contr"),
            inverseJoinColumns = @JoinColumn(name = "oborudovanie_id"))
    private List<OborudovanieInfoDoc> oborudovanieInfoDocList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_contract_transport",
            joinColumns = @JoinColumn(name = "doc_contract_transport"),
            inverseJoinColumns = @JoinColumn(name = "transport_id"))
    private List<TransportDoc> transportDocList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_contract",
            joinColumns = @JoinColumn(name = "doc_contract_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeeList;

    public DocumentPdfContract() {
    }

    public List<DogovoraCompanyPdf> getDogovoraCompanyPdfListGenPodr() {
        return dogovoraCompanyPdfListGenPodr;
    }

    public void setDogovoraCompanyPdfListGenPodr(List<DogovoraCompanyPdf> dogovoraCompanyPdfListGenPodr) {
        this.dogovoraCompanyPdfListGenPodr = dogovoraCompanyPdfListGenPodr;
    }

    public List<DogovoraCompanyPdf> getDogovoraCompanyPdfListIspolnitel() {
        return dogovoraCompanyPdfListIspolnitel;
    }

    public void setDogovoraCompanyPdfListIspolnitel(List<DogovoraCompanyPdf> dogovoraCompanyPdfListIspolnitel) {
        this.dogovoraCompanyPdfListIspolnitel = dogovoraCompanyPdfListIspolnitel;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDocListContract() {
        return promBezopastnostDocListContract;
    }

    public void setPromBezopastnostDocListContract(List<PromBezopastnostDoc> promBezopastnostDocListContract) {
        this.promBezopastnostDocListContract = promBezopastnostDocListContract;
    }

    public List<OborudovanieInfoDoc> getOborudovanieInfoDocList() {
        return oborudovanieInfoDocList;
    }

    public void setOborudovanieInfoDocList(List<OborudovanieInfoDoc> oborudovanieInfoDocList) {
        this.oborudovanieInfoDocList = oborudovanieInfoDocList;
    }

    public List<TransportDoc> getTransportDocList() {
        return transportDocList;
    }

    public void setTransportDocList(List<TransportDoc> transportDocList) {
        this.transportDocList = transportDocList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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

    public Company getOneObject() {
        return oneObject;
    }

    public void setOneObject(Company oneObject) {
        this.oneObject = oneObject;
    }

    public Company getTwoObject() {
        return twoObject;
    }

    public void setTwoObject(Company twoObject) {
        this.twoObject = twoObject;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getMoneyContract() {
        return moneyContract;
    }

    public void setMoneyContract(double moneyContract) {
        this.moneyContract = moneyContract;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "DocumentPdfContract{" +
                "iddoc=" + iddoc +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", data='" + data + '\'' +
                ", numberDoc='" + numberDoc + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", moneyContract=" + moneyContract +
                ", work='" + work + '\'' +
                ", role='" + role + '\'' +
                '}' + "\n";
    }
}
