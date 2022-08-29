package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee_docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int employee_id;

    private int docs_id;

    public Employee_docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getDocs_id() {
        return docs_id;
    }

    public void setDocs_id(int docs_id) {
        this.docs_id = docs_id;
    }
}
