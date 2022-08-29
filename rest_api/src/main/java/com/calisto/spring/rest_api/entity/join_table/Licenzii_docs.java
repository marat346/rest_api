package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Licenzii_docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int licenzii_id;

    private int docs_id;

    public Licenzii_docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLicenzii_id() {
        return licenzii_id;
    }

    public void setLicenzii_id(int licenzii_id) {
        this.licenzii_id = licenzii_id;
    }

    public int getDocs_id() {
        return docs_id;
    }

    public void setDocs_id(int docs_id) {
        this.docs_id = docs_id;
    }
}
