package com.calisto.spring.rest_api.entity.join_table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oborudovanie_docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int oborudovanie_id;

    private int docs_id;

    public Oborudovanie_docs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOborudovanie_id() {
        return oborudovanie_id;
    }

    public void setOborudovanie_id(int oborudovanie_id) {
        this.oborudovanie_id = oborudovanie_id;
    }

    public int getDocs_id() {
        return docs_id;
    }

    public void setDocs_id(int docs_id) {
        this.docs_id = docs_id;
    }
}
