package com.calisto.spring.rest_api.entity.company;

import javax.persistence.*;
import java.util.List;

// данный класс содержит все департаменты, отделы
@Entity
@Table(name = "departments_list_table")
public class DepartmentsCompany {

    //ид таблицы
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int iddeportmentscompany;

    // список всех депортаменов (незнай как это чудо реализовать)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "department_com_departments",
            joinColumns = @JoinColumn(name = "department_com_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    List<Department> arrayListDepartments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    List<Company> companyList;

    public DepartmentsCompany() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public void addNewDepartment(Department department){
        this.arrayListDepartments.add(department);
    }

    public int getIddeportmentscompany() {
        return iddeportmentscompany;
    }

    public void setIddeportmentscompany(int iddeportmentscompany) {
        this.iddeportmentscompany = iddeportmentscompany;
    }

    public List<Department> getArrayListDepartments() {
        return arrayListDepartments;
    }

    public void setArrayListDepartments(List<Department> arrayListDepartments) {
        this.arrayListDepartments = arrayListDepartments;
    }

    @Override
    public String toString() {
        return "DepartmentsCompany{" +
                "iddeportmentscompany=" + iddeportmentscompany +
                '}' + "\n";
    }
}
