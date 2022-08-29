package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company_licenzii {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int company_id;

    private int licenzii_id;

    public Company_licenzii() {
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

    public int getLicenzii_id() {
        return licenzii_id;
    }

    public void setLicenzii_id(int licenzii_id) {
        this.licenzii_id = licenzii_id;
    }
}
