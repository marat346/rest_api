package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.people.Employee;

import javax.persistence.*;
import java.util.List;

// компания
// в данном классе содержится вся необходимая информация о компании
@Entity
@Table(name = "company_table")
public class Company {
    // ид компании
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idcompany;

    // полное название формы организации
    @Column(name = "full_name_form_com")
    private String fullNameFormCompany;

    // сокращённое название формы организации
    @Column(name = "small_name_form_com")
    private String smallNameFormCompany;

    // полное название организации
    @Column(name = "full_name_com")
    private String fullNameCompany;

    // сокращённое название организации
    @Column(name = "small_name_com")
    private String smallNameCompany;

    // юридический адрес организации
    @Column(name = "address_com")
    private String addressCompany;

    // почтовый адрес организации
    @Column(name = "mail_address_com")
    private String mailAddressCompany;

    // инн
    @Column(name = "inn_com")
    private String innCompany;

    // кпп
    @Column(name = "kpp_com")
    private String kppCompany;

    // огрн
    @Column(name = "registration_number_com")
    private String registrationNumberCompany;

    // орган выдавший свидетельство о регистрации
    @Column(name = "registration_number_gov_com")
    private String registrationNumberGovCompany;

    // дата выдачи регистрации
    @Column(name = "date_registration_number_gov_doc")
    private String dateRegistrationNumberGovDoc;

    // дата регистрации организации
    @Column(name = "date_registration_com")
    private String dateRegistrationCompany;

    // бик банка
    @Column(name = "bank_number")
    private String bankNumber;

    // название формы банка
    @Column(name = "name_form_bank")
    private String nameFormBank;

    // название банка
    @Column(name = "name_bank")
    private String nameBank;

    // адрес банка
    @Column(name = "address_bank")
    private String addressBank;

    // расчётный счёт в банке
    @Column(name = "checking_account_bank")
    private String checkingAccountBank;

    // корреспонденский счёт в банке
    @Column(name = "correspondent_account_bank")
    private String correspondentAccountBank;

    // ОКПО
    @Column(name = "okpo_com")
    private String okpoCompany;

    // ОКАТО
    @Column(name = "okato_com")
    private String okatoCompany;

    // ОКВЭД (основной)
    @Column(name = "okved_com")
    private String okvedCompany;

    // руководитель организации
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_supervisor_empl",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "supervisor_id"))
    private List<Employee> supervisorCompany;

    // главный бухгалтер
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_chief_accountant",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "chief_accountant_id"))
    private List<Employee> chiefAccountantCompany;

    // электронная почта
    @Column(name = "email_com")
    private String emailCompany;

    // телефон
    @Column(name = "telephone_com")
    private String telephoneCompany;

    // сайт
    @Column(name = "web_site_com")
    private String webSiteCompany;

    // добавляем информацию по сотрудникам
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_employees",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<EmployeesCompany> employeesCompany;

    // добавляем информацию по департаментам
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_department",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<DepartmentsCompany> departmentsCompany;

        // учредительные документы
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_basic_doc",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "basic_doc_id"))
        private List<BasicDocCompany> basicDocCompany;

        // добавляем пакет бухгалтерских документов
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_economic_doc",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "economic_doc_id"))
        private List<EconomicCompanyDoc> economicCompanyDoc;

        // добавляем пакет документов по договорам
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_dogovora",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "dogovora_id"))
        private List<DogovoraCompanyPdf> dogovoraCompanyPdf;

        // пакет документов по аккредитации
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_akkredit",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "akkred_doc_id"))
        private List<AkkredDocsCompany> akkredDocsCompany;

        // список печатей
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_stamp_signature",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "stamp_signature_id"))
        private List<StampsEndSignatures> stampsEndSignatures;

        // добавляем пакет документов по транспорту
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_transport",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "transport_doc_id"))
        private List<TransportInfoDoc> transportInfoDoc;

        // добавляем пакет документов по оборудованию
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_oborudovanie",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "oborudovanie_id_doc"))
        private List<OborudovanieInfoDoc> oborudovanieInfoDoc;

        // добавляем пакет документов по промышленной безопасности
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_prombez",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "prombez_id_doc"))
        private List<PromBezopastnostDoc> promBezopastnostDoc;

        // добавляем историю тендеров
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "company_tender_history",
                joinColumns = @JoinColumn(name = "company_id"),
                inverseJoinColumns = @JoinColumn(name = "tender_history_id"))
        private List<TenderListHistory> tenderListHistory;

    // статус по СМП "Субъект малого предпринимательства (0 - является СМП,
        // 1 - является субъектом среднего предпринимательства
        // 2 - не является субъектом малого или среднего предпринимательства)
    @Column(name = "smp_status")
        private  int smpStatus = 1;

        // статус по аккредитации! временный
        // в будушем надо сделать список отдельно от класса где будет хранится эта инфа
        // имеет 3 значения
        // 0 - не имеется действующей аккредитации
        // 1 - поданы документы для проведения проверки
        // в будушем надо добавить информацию по данным поданой заявки
        // 2 - имеется действующая аккредитация
        // в будушем надо добавить информацию по аккредитации
            @Column(name = "akkred_st")
            private int akkreditStatus = 2;



        public Company() {
        }

        public Company(String innCompany) {
            this.innCompany = innCompany;
        }

        public Company(String fullNameFormCompany,
                       String smallNameFormCompany,
                       String fullNameCompany,
                       String smallNameCompany) {
            this.fullNameFormCompany = fullNameFormCompany;
            this.smallNameFormCompany = smallNameFormCompany;
            this.fullNameCompany = fullNameCompany;
            this.smallNameCompany = smallNameCompany;
        }

    public Company (String fullNameFormCompany,
                   String smallNameFormCompany,
                   String fullNameCompany,
                   String smallNameCompany,
                   String addressCompany,
                   String mailAddressCompany,
                   String innCompany,
                   String kppCompany,
                   String registrationNumberCompany,
                   String registrationNumberGovCompany,
                   String dateRegistrationNumberGocDoc,
                   String dateRegistrationCompany,
                   String bankNumber,
                   String nameFormBank,
                   String nameBank,
                   String adressBank,
                   String checkingAccountBank,
                   String correspondentAccounBank,
                   String okpoCompany,
                   String okatoCompany,
                   String okvedCompany) {
            this.fullNameFormCompany = fullNameFormCompany;
            this.smallNameFormCompany = smallNameFormCompany;
            this.fullNameCompany = fullNameCompany;
            this.smallNameCompany = smallNameCompany;
            this.addressCompany = addressCompany;
            this.mailAddressCompany = mailAddressCompany;
            this.innCompany = innCompany;
            this.kppCompany = kppCompany;
            this.registrationNumberCompany = registrationNumberCompany;
            this.registrationNumberGovCompany = registrationNumberGovCompany;
            this.dateRegistrationNumberGovDoc = dateRegistrationNumberGocDoc;
            this.dateRegistrationCompany = dateRegistrationCompany;
            this.bankNumber = bankNumber;
            this.nameFormBank = nameFormBank;
            this.nameBank = nameBank;
            this.addressBank = adressBank;
            this.checkingAccountBank = checkingAccountBank;
            this.correspondentAccountBank = correspondentAccounBank;
            this.okpoCompany = okpoCompany;
            this.okatoCompany = okatoCompany;
            this.okvedCompany = okvedCompany;
        }



    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    public String getFullNameFormCompany() {
        return fullNameFormCompany;
    }

    public void setFullNameFormCompany(String fullNameFormCompany) {
        this.fullNameFormCompany = fullNameFormCompany;
    }

    public String getSmallNameFormCompany() {
        return smallNameFormCompany;
    }

    public void setSmallNameFormCompany(String smallNameFormCompany) {
        this.smallNameFormCompany = smallNameFormCompany;
    }

    public String getFullNameCompany() {
        return fullNameCompany;
    }

    public void setFullNameCompany(String fullNameCompany) {
        this.fullNameCompany = fullNameCompany;
    }

    public String getSmallNameCompany() {
        return smallNameCompany;
    }

    public void setSmallNameCompany(String smallNameCompany) {
        this.smallNameCompany = smallNameCompany;
    }

    public String getAddressCompany() {
        return addressCompany;
    }

    public void setAddressCompany(String addressCompany) {
        this.addressCompany = addressCompany;
    }

    public String getMailAddressCompany() {
        return mailAddressCompany;
    }

    public void setMailAddressCompany(String mailAddressCompany) {
        this.mailAddressCompany = mailAddressCompany;
    }

    public String getInnCompany() {
        return innCompany;
    }

    public void setInnCompany(String innCompany) {
        this.innCompany = innCompany;
    }

    public String getKppCompany() {
        return kppCompany;
    }

    public void setKppCompany(String kppCompany) {
        this.kppCompany = kppCompany;
    }

    public String getRegistrationNumberCompany() {
        return registrationNumberCompany;
    }

    public void setRegistrationNumberCompany(String registrationNumberCompany) {
        this.registrationNumberCompany = registrationNumberCompany;
    }

    public String getRegistrationNumberGovCompany() {
        return registrationNumberGovCompany;
    }

    public void setRegistrationNumberGovCompany(String registrationNumberGovCompany) {
        this.registrationNumberGovCompany = registrationNumberGovCompany;
    }

    public String getDateRegistrationNumberGovDoc() {
        return dateRegistrationNumberGovDoc;
    }

    public void setDateRegistrationNumberGovDoc(String dateRegistrationNumberGovDoc) {
        this.dateRegistrationNumberGovDoc = dateRegistrationNumberGovDoc;
    }

    public String getDateRegistrationCompany() {
        return dateRegistrationCompany;
    }

    public void setDateRegistrationCompany(String dateRegistrationCompany) {
        this.dateRegistrationCompany = dateRegistrationCompany;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getNameFormBank() {
        return nameFormBank;
    }

    public void setNameFormBank(String nameFormBank) {
        this.nameFormBank = nameFormBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getAddressBank() {
        return addressBank;
    }

    public void setAddressBank(String addressBank) {
        this.addressBank = addressBank;
    }

    public String getCheckingAccountBank() {
        return checkingAccountBank;
    }

    public void setCheckingAccountBank(String checkingAccountBank) {
        this.checkingAccountBank = checkingAccountBank;
    }

    public String getCorrespondentAccountBank() {
        return correspondentAccountBank;
    }

    public void setCorrespondentAccountBank(String correspondentAccountBank) {
        this.correspondentAccountBank = correspondentAccountBank;
    }

    public String getOkpoCompany() {
        return okpoCompany;
    }

    public void setOkpoCompany(String okpoCompany) {
        this.okpoCompany = okpoCompany;
    }

    public String getOkatoCompany() {
        return okatoCompany;
    }

    public void setOkatoCompany(String okatoCompany) {
        this.okatoCompany = okatoCompany;
    }

    public String getOkvedCompany() {
        return okvedCompany;
    }

    public void setOkvedCompany(String okvedCompany) {
        this.okvedCompany = okvedCompany;
    }

    public List<Employee> getSupervisorCompany() {
        return supervisorCompany;
    }

    public void setSupervisorCompany(List<Employee> supervisorCompany) {
        this.supervisorCompany = supervisorCompany;
    }

    public List<Employee> getChiefAccountantCompany() {
        return chiefAccountantCompany;
    }

    public void setChiefAccountantCompany(List<Employee> chiefAccountantCompany) {
        this.chiefAccountantCompany = chiefAccountantCompany;
    }

    public String getEmailCompany() {
        return emailCompany;
    }

    public void setEmailCompany(String emailCompany) {
        this.emailCompany = emailCompany;
    }

    public String getTelephoneCompany() {
        return telephoneCompany;
    }

    public void setTelephoneCompany(String telephoneCompany) {
        this.telephoneCompany = telephoneCompany;
    }

    public String getWebSiteCompany() {
        return webSiteCompany;
    }

    public void setWebSiteCompany(String webSiteCompany) {
        this.webSiteCompany = webSiteCompany;
    }

    public List<EmployeesCompany> getEmployeesCompany() {
        return employeesCompany;
    }

    public void setEmployeesCompany(List<EmployeesCompany> employeesCompany) {
        this.employeesCompany = employeesCompany;
    }

    public List<DepartmentsCompany> getDepartmentsCompany() {
        return departmentsCompany;
    }

    public void setDepartmentsCompany(List<DepartmentsCompany> departmentsCompany) {
        this.departmentsCompany = departmentsCompany;
    }

    public List<BasicDocCompany> getBasicDocCompany() {
        return basicDocCompany;
    }

    public void setBasicDocCompany(List<BasicDocCompany> basicDocCompany) {
        this.basicDocCompany = basicDocCompany;
    }

    public List<EconomicCompanyDoc> getEconomicCompanyDoc() {
        return economicCompanyDoc;
    }

    public void setEconomicCompanyDoc(List<EconomicCompanyDoc> economicCompanyDoc) {
        this.economicCompanyDoc = economicCompanyDoc;
    }

    public List<DogovoraCompanyPdf> getDogovoraCompanyPdf() {
        return dogovoraCompanyPdf;
    }

    public void setDogovoraCompanyPdf(List<DogovoraCompanyPdf> dogovoraCompanyPdf) {
        this.dogovoraCompanyPdf = dogovoraCompanyPdf;
    }

    public List<AkkredDocsCompany> getAkkredDocsCompany() {
        return akkredDocsCompany;
    }

    public void setAkkredDocsCompany(List<AkkredDocsCompany> akkredDocsCompany) {
        this.akkredDocsCompany = akkredDocsCompany;
    }

    public List<StampsEndSignatures> getStampsEndSignatures() {
        return stampsEndSignatures;
    }

    public void setStampsEndSignatures(List<StampsEndSignatures> stampsEndSignatures) {
        this.stampsEndSignatures = stampsEndSignatures;
    }

    public List<TransportInfoDoc> getTransportInfoDoc() {
        return transportInfoDoc;
    }

    public void setTransportInfoDoc(List<TransportInfoDoc> transportInfoDoc) {
        this.transportInfoDoc = transportInfoDoc;
    }

    public List<OborudovanieInfoDoc> getOborudovanieInfoDoc() {
        return oborudovanieInfoDoc;
    }

    public void setOborudovanieInfoDoc(List<OborudovanieInfoDoc> oborudovanieInfoDoc) {
        this.oborudovanieInfoDoc = oborudovanieInfoDoc;
    }

    public List<PromBezopastnostDoc> getPromBezopastnostDoc() {
        return promBezopastnostDoc;
    }

    public void setPromBezopastnostDoc(List<PromBezopastnostDoc> promBezopastnostDoc) {
        this.promBezopastnostDoc = promBezopastnostDoc;
    }

    public List<TenderListHistory> getTenderListHistory() {
        return tenderListHistory;
    }

    public void setTenderListHistory(List<TenderListHistory> tenderListHistory) {
        this.tenderListHistory = tenderListHistory;
    }

    public int getSmpStatus() {
        return smpStatus;
    }

    public void setSmpStatus(int smpStatus) {
        this.smpStatus = smpStatus;
    }

    public int getAkkreditStatus() {
        return akkreditStatus;
    }

    public void setAkkreditStatus(int akkreditStatus) {
        this.akkreditStatus = akkreditStatus;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idcompany=" + idcompany +
                ", fullNameFormCompany='" + fullNameFormCompany + '\'' +
                ", smallNameFormCompany='" + smallNameFormCompany + '\'' +
                ", fullNameCompany='" + fullNameCompany + '\'' +
                ", smallNameCompany='" + smallNameCompany + '\'' +
                ", addressCompany='" + addressCompany + '\'' +
                ", mailAddressCompany='" + mailAddressCompany + '\'' +
                ", innCompany='" + innCompany + '\'' +
                ", kppCompany='" + kppCompany + '\'' +
                ", registrationNumberCompany='" + registrationNumberCompany + '\'' +
                ", registrationNumberGovCompany='" + registrationNumberGovCompany + '\'' +
                ", dateRegistrationNumberGovDoc='" + dateRegistrationNumberGovDoc + '\'' +
                ", dateRegistrationCompany='" + dateRegistrationCompany + '\'' +
                ", bankNumber='" + bankNumber + '\'' +
                ", nameFormBank='" + nameFormBank + '\'' +
                ", nameBank='" + nameBank + '\'' +
                ", addressBank='" + addressBank + '\'' +
                ", checkingAccountBank='" + checkingAccountBank + '\'' +
                ", correspondentAccountBank='" + correspondentAccountBank + '\'' +
                ", okpoCompany='" + okpoCompany + '\'' +
                ", okatoCompany='" + okatoCompany + '\'' +
                ", okvedCompany='" + okvedCompany + '\'' +
                ", emailCompany='" + emailCompany + '\'' +
                ", telephoneCompany='" + telephoneCompany + '\'' +
                ", webSiteCompany='" + webSiteCompany + '\'' +
                '}' +"\n";
    }
}
