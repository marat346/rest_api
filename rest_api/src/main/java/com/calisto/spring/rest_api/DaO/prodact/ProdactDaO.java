package com.calisto.spring.rest_api.DaO.prodact;

import com.calisto.spring.rest_api.entity.Prodact;

import java.util.List;

public interface ProdactDaO {
    public List<Prodact>getAll();
    public Prodact add(Prodact prodact);
    public Prodact getProdact(int id);
    public void delete(int id);
}
