package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Buh_docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int buh_id;

    private int docs_id;

    public Buh_docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuh_id() {
        return buh_id;
    }

    public void setBuh_id(int buh_id) {
        this.buh_id = buh_id;
    }

    public int getDocs_id() {
        return docs_id;
    }

    public void setDocs_id(int docs_id) {
        this.docs_id = docs_id;
    }
}
