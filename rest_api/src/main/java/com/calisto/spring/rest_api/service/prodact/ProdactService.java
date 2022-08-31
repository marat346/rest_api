package com.calisto.spring.rest_api.service.prodact;

import com.calisto.spring.rest_api.entity.Prodact;

import java.util.List;

public interface ProdactService {
    public List<Prodact> getAll();
    public Prodact add(Prodact prodact);
    public Prodact getProdact(int id);
    public void delete(int id);
}
