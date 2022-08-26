package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.people.Employee;

import javax.persistence.*;
import java.util.List;

//содержит информацию по всем сотрудникам компании
@Entity
@Table(name = "employees_list_table")
public class EmployeesCompany {
    
    // ид базы сотрудников
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idemployeescompany;

    // Список сотрудников
    // как добавить в бд
    // надо сделать отдельно класс сотрудники и заменить этот лист
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employees_employee_list",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "employees_id"))
    private List<Employee> arrayListEmployee;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_employees",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companyList;

    public EmployeesCompany() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getIdemployeescompany() {
        return idemployeescompany;
    }

    public void setIdemployeescompany(int idemployeescompany) {
        this.idemployeescompany = idemployeescompany;
    }

    public List<Employee> getArrayListEmployee() {
        return arrayListEmployee;
    }

    public void setArrayListEmployee(List<Employee> arrayListEmployee) {
        this.arrayListEmployee = arrayListEmployee;
    }

    @Override
    public String toString() {
        return "EmployeesCompany{" +
                "idemployeescompany=" + idemployeescompany +
                '}' + "\n";
    }
}
