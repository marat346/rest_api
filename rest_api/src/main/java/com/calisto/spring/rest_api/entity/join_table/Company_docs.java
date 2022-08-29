package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company_docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_company;

    private int id_docs;

    public Company_docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public int getId_docs() {
        return id_docs;
    }

    public void setId_docs(int id_docs) {
        this.id_docs = id_docs;
    }
}
