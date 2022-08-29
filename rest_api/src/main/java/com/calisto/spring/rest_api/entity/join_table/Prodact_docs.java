package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prodact_docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int prodact_id;
    private int docs_id;

    public Prodact_docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdact_id() {
        return prodact_id;
    }

    public void setProdact_id(int prodact_id) {
        this.prodact_id = prodact_id;
    }

    public int getDocs_id() {
        return docs_id;
    }

    public void setDocs_id(int docs_id) {
        this.docs_id = docs_id;
    }
}
