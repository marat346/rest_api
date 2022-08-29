package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company_prodact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int company_id;

    private int prodact_id;

    public Company_prodact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getProdact_id() {
        return prodact_id;
    }

    public void setProdact_id(int prodact_id) {
        this.prodact_id = prodact_id;
    }
}
