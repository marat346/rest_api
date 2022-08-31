package com.calisto.spring.rest_api.service.prodact;

import com.calisto.spring.rest_api.DaO.prodact.ProdactDaO;
import com.calisto.spring.rest_api.entity.Prodact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdactServiceImpl implements ProdactService{
    @Autowired
    ProdactDaO prodactDaO;

    @Override
    @Transactional
    public List<Prodact> getAll() {
        return prodactDaO.getAll();
    }

    @Override
    @Transactional
    public Prodact add(Prodact prodact) {
        prodactDaO.add(prodact);
        return prodact;
    }

    @Override
    @Transactional
    public Prodact getProdact(int id) {
        return prodactDaO.getProdact(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        prodactDaO.delete(id);
    }
}
