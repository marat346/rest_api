package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company_oborydovaanie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int company_id;

    private int oborudovanie_id;

    public Company_oborydovaanie() {
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

    public int getOborudovanie_id() {
        return oborudovanie_id;
    }

    public void setOborudovanie_id(int oborudovanie_id) {
        this.oborudovanie_id = oborudovanie_id;
    }
}
