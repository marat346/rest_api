package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.people.Employee;

import javax.persistence.*;
import java.util.List;

// отделы
@Entity
@Table(name = "department_table")
public class Department {
    // ид депортамента/отдела
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idDepartment;

    // навание отдела
    @Column(name = "name")
    private String name;

    // адрес нахождения депортамента
    @Column(name = "address_department")
    private String addressDepartment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "department_com_departments",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "department_com_id"))
    List<DepartmentsCompany> departmentsCompanyList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeeList;

    public Department() {
    }

    public List<DepartmentsCompany> getDepartmentsCompanyList() {
        return departmentsCompanyList;
    }

    public void setDepartmentsCompanyList(List<DepartmentsCompany> departmentsCompanyList) {
        this.departmentsCompanyList = departmentsCompanyList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressDepartment() {
        return addressDepartment;
    }

    public void setAddressDepartment(String addressDepartment) {
        this.addressDepartment = addressDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", name='" + name + '\'' +
                ", addressDepartment='" + addressDepartment + '\'' +
                '}' + "\n";
    }
}
