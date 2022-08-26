package com.calisto.spring.rest_api.entity.people;

import com.calisto.spring.rest_api.entity.company.Department;
import com.calisto.spring.rest_api.entity.company.EmployeesCompany;
import com.calisto.spring.rest_api.entity.document.DocumentPdf;
import com.calisto.spring.rest_api.entity.document.DocumentPdfContract;
import com.calisto.spring.rest_api.entity.document.DocumentPdfDateInfo;

import javax.persistence.*;
import java.util.List;

// расширяем класс человек до сотрудника
@Entity
@Table(name = "employee_table")
public class Employee {

    // ид человека
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idhuman;

    // фамилия
    @Column(name = "surname")
    private String surname;

    // имя
    @Column(name = "name")
    private String name;

    // отчество
    @Column(name = "patronymic")
    private String patronymic;

    // серийный номер паспорта
    @Column(name = "passport_serial")
    private String passportSerial;

    // номер паспорта
    @Column(name = "passport_number")
    private String passportNumber;

    // кем выдан
    @Column(name = "passport_gov_name")
    private String passportGovName;

    // дата выдачи
    // необходимо реализовать работу с календарём
    @Column(name = "date_gov")
    private String passportGovDate;

    // день рождения
    // необходимо реализовать работу с календарём
    @Column(name = "date_happy")
    private String heppyDate;

    // адрес регистрации
    @Column(name = "address_reg")
    private String addressReg;

    // телефонный номер
    @Column(name = "telephone_number")
    private String telephoneNumber;

    // Образование (не знаю что сюда лучше зайдёт. Может класс документ)
    @Column(name = "education_doc")
    private String educationDoc;

    // инн физ лица
    @Column(name = "inn")
    private String inn;

    // снилс очень важный всем нужный номер и документ
    @Column(name = "snils")
    private String snils;

    // сканы документов
    // создать отдельно класс прочие документы, где храняться документы в списке. хз что ещё надо
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_alldoc",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_alldoc_id"))
    private List<DocumentPdfDateInfo> documentPdfDateInfoListAll;

    // гражданство
    @Column(name = "goverment_status")
    private String govermentStatus;

    // должность
    @Column(name = "position_com")
    private String positionCom;

//     дата трудоустройства
//     надо реализовать работу с датами
    @Column(name = "date_trud")
    private String dateTrud;

    // трудовой договор (по сути дела это контракт)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_contract",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_contract_id"))
    private List<DocumentPdfContract> documentPdfContract;

    // список допусков
    // надо реализовать отдельно класс со списком допусков
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_dopusk",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_dopusk_id"))
    private List<DocumentPdf> documentPdfArrayList;

    // Водительское удостоверение (если есть)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_doc_car",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_car_id"))
    private List<DocumentPdf> documentCarDocPdf;

    // медкомиссия (если она есть то автоматически сотрудник допущен к работе! если нет то нет)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_doc_med",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_med_id"))
    private List<DocumentPdf> documentPdfMed;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employees_employee_list",
            joinColumns = @JoinColumn(name = "employees_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<EmployeesCompany> employeesCompanyList;

    // отдел
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> departmentList;

    public Employee() {
    }

    public Employee(String surname,
                    String name,
                    String patronymic,
                    String passportSerial,
                    String passportNumber,
                    String passportGovName,
                    String passportGovDate,
                    String heppyDate,
                    String addressReg,
                    String telephoneNumber,
                    String educationDoc,
                    String inn,
                    String snils,
                    String govermentStatus,
                    String positionCom,
                    String dateTrud,
                    List<DocumentPdfContract> documentPdfContract,
                    List<DocumentPdf> documentPdfArrayList,
                    List<DocumentPdf> documentCarDocPdf,
                    List<DocumentPdf> documentPdfMed) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passportSerial = passportSerial;
        this.passportNumber = passportNumber;
        this.passportGovName = passportGovName;
        this.passportGovDate = passportGovDate;
        this.heppyDate = heppyDate;
        this.addressReg = addressReg;
        this.telephoneNumber = telephoneNumber;
        this.educationDoc = educationDoc;
        this.inn = inn;
        this.snils = snils;
        this.govermentStatus = govermentStatus;
        this.positionCom = positionCom;
        this.dateTrud = dateTrud;
        this.documentPdfContract = documentPdfContract;
        this.documentPdfArrayList = documentPdfArrayList;
        this.documentCarDocPdf = documentCarDocPdf;
        this.documentPdfMed = documentPdfMed;
    }

    public List<DocumentPdfDateInfo> getDocumentPdfDateInfoListAll() {
        return documentPdfDateInfoListAll;
    }

    public void setDocumentPdfDateInfoListAll(List<DocumentPdfDateInfo> documentPdfDateInfoListAll) {
        this.documentPdfDateInfoListAll = documentPdfDateInfoListAll;
    }

    public List<EmployeesCompany> getEmployeesCompanyList() {
        return employeesCompanyList;
    }

    public void setEmployeesCompanyList(List<EmployeesCompany> employeesCompanyList) {
        this.employeesCompanyList = employeesCompanyList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String giveFullName(){
        String res = surname + " " + name + " " + patronymic;
        return res;
    }

    public String givePositionEndFullName(){
        return positionCom + " " + surname + " " + name + " " + patronymic;
    }

    public int getIdhuman() {
        return idhuman;
    }

    public void setIdhuman(int idhuman) {
        this.idhuman = idhuman;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportGovName() {
        return passportGovName;
    }

    public void setPassportGovName(String passportGovName) {
        this.passportGovName = passportGovName;
    }

    public String getPassportGovDate() {
        return passportGovDate;
    }

    public void setPassportGovDate(String passportGovDate) {
        this.passportGovDate = passportGovDate;
    }

    public String getHeppyDate() {
        return heppyDate;
    }

    public void setHeppyDate(String heppyDate) {
        this.heppyDate = heppyDate;
    }

    public String getAddressReg() {
        return addressReg;
    }

    public void setAddressReg(String addressReg) {
        this.addressReg = addressReg;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEducationDoc() {
        return educationDoc;
    }

    public void setEducationDoc(String educationDoc) {
        this.educationDoc = educationDoc;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getGovermentStatus() {
        return govermentStatus;
    }

    public void setGovermentStatus(String govermentStatus) {
        this.govermentStatus = govermentStatus;
    }

    public String getPositionCom() {
        return positionCom;
    }

    public void setPositionCom(String positionCom) {
        this.positionCom = positionCom;
    }

    public String getDateTrud() {
        return dateTrud;
    }

    public void setDateTrud(String dateTrud) {
        this.dateTrud = dateTrud;
    }

    public List<DocumentPdf> getDocumentPdfArrayList() {
        return documentPdfArrayList;
    }

    public void setDocumentPdfArrayList(List<DocumentPdf> documentPdfArrayList) {
        this.documentPdfArrayList = documentPdfArrayList;
    }

    public List<DocumentPdfContract> getDocumentPdfContract() {
        return documentPdfContract;
    }

    public void setDocumentPdfContract(List<DocumentPdfContract> documentPdfContract) {
        this.documentPdfContract = documentPdfContract;
    }

    public List<DocumentPdf> getDocumentCarDocPdf() {
        return documentCarDocPdf;
    }

    public void setDocumentCarDocPdf(List<DocumentPdf> documentCarDocPdf) {
        this.documentCarDocPdf = documentCarDocPdf;
    }

    public List<DocumentPdf> getDocumentPdfMed() {
        return documentPdfMed;
    }

    public void setDocumentPdfMed(List<DocumentPdf> documentPdfMed) {
        this.documentPdfMed = documentPdfMed;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idhuman=" + idhuman +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passportSerial='" + passportSerial + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportGovName='" + passportGovName + '\'' +
                ", passportGovDate='" + passportGovDate + '\'' +
                ", heppyDate='" + heppyDate + '\'' +
                ", addressReg='" + addressReg + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", educationDoc='" + educationDoc + '\'' +
                ", inn='" + inn + '\'' +
                ", snils='" + snils + '\'' +
                ", govermentStatus='" + govermentStatus + '\'' +
                ", positionCom='" + positionCom + '\'' +
                ", dateTrud='" + dateTrud + '\'' +
                '}' + "\n";
    }

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
}
