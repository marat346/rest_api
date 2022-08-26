package com.calisto.spring.rest_api.entity.people;

import com.calisto.spring.rest_api.entity.document.DocumentPdfDateInfo;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "humans_table")
// родительский класс человек
public class Human{

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
    @JoinTable(name = "human_doc_date_info",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_date_info_id"))
    private List<DocumentPdfDateInfo> documentPdfDateInfoList;

    // гражданство
    @Column(name = "goverment_status")
    private String govermentStatus;

    public Human() {
    }

    public Human(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Human(String surname,
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
                 String snils) {
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

    public List<DocumentPdfDateInfo> getDocumentPdfDateInfoList() {
        return documentPdfDateInfoList;
    }

    public void setDocumentPdfDateInfoList(List<DocumentPdfDateInfo> documentPdfDateInfoList) {
        this.documentPdfDateInfoList = documentPdfDateInfoList;
    }

    public String getGovermentStatus() {
        return govermentStatus;
    }

    public void setGovermentStatus(String govermentStatus) {
        this.govermentStatus = govermentStatus;
    }

    @Override
    public String toString() {
        return "Human{" +
                "idhuman=" + idhuman +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passportSerial='" + passportSerial + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportGovName='" + passportGovName + '\'' +
                ", passportGovDate=" + passportGovDate +
                ", heppyDate=" + heppyDate +
                ", addressReg='" + addressReg + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", educationDoc='" + educationDoc + '\'' +
                ", inn='" + inn + '\'' +
                ", snils='" + snils + '\'' +
                ", govermentStatus='" + govermentStatus + '\'' +
                '}' + "\n";
    }
}
