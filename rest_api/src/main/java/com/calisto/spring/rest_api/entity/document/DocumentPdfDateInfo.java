package com.calisto.spring.rest_api.entity.document;

import com.calisto.spring.rest_api.entity.company.AkkredDocsCompany;
import com.calisto.spring.rest_api.entity.people.Employee;
import com.calisto.spring.rest_api.entity.people.Human;

import javax.persistence.*;
import java.util.List;

// создаём документ со сроком и кем выдан
@Entity
@Table(name = "documents_date_info_table")
public class DocumentPdfDateInfo{

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

    // с какого действует
    @Column(name = "start_date")
    private  String startDate;

    // по какое
    @Column(name = "end_date")
    private String endDate;

    // кем выдан
    @Column (name = "name_info_com")
    private String nameInfoCom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "akkredit_doc_info",
            joinColumns = @JoinColumn(name = "doc_info_id"),
            inverseJoinColumns = @JoinColumn(name = "akkredit_id"))
    private List<AkkredDocsCompany> akkredDocsCompanyListDocInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_alldoc",
            joinColumns = @JoinColumn(name = "doc_all_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeeListAllDoc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "human_doc_date_info",
            joinColumns = @JoinColumn(name = "doc_date_info_id"),
            inverseJoinColumns = @JoinColumn(name = "human_id"))
    private List<Human> humansList;

    public DocumentPdfDateInfo() {
    }

    public List<AkkredDocsCompany> getAkkredDocsCompanyListDocInfo() {
        return akkredDocsCompanyListDocInfo;
    }

    public void setAkkredDocsCompanyListDocInfo(List<AkkredDocsCompany> akkredDocsCompanyListDocInfo) {
        this.akkredDocsCompanyListDocInfo = akkredDocsCompanyListDocInfo;
    }

    public List<Employee> getEmployeeListAllDoc() {
        return employeeListAllDoc;
    }

    public void setEmployeeListAllDoc(List<Employee> employeeListAllDoc) {
        this.employeeListAllDoc = employeeListAllDoc;
    }

    public List<Human> getHumansList() {
        return humansList;
    }

    public void setHumansList(List<Human> humansList) {
        this.humansList = humansList;
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

    public String getNameInfoCom() {
        return nameInfoCom;
    }

    public void setNameInfoCom(String nameInfoCom) {
        this.nameInfoCom = nameInfoCom;
    }

    @Override
    public String toString() {
        return "DocumentPdfDateInfo{" +
                "iddoc=" + iddoc +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", data='" + data + '\'' +
                ", numberDoc='" + numberDoc + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", nameInfoCom='" + nameInfoCom + '\'' +
                '}' + "\n";
    }
}
