package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Akkredit_docs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int akkredit_id;

    private int docs_id;

    public Akkredit_docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAkkredit_id() {
        return akkredit_id;
    }

    public void setAkkredit_id(int akkredit_id) {
        this.akkredit_id = akkredit_id;
    }

    public int getDocs_id() {
        return docs_id;
    }

    public void setDocs_id(int docs_id) {
        this.docs_id = docs_id;
    }
}
