package com.calisto.spring.rest_api.service.buhdocument;

import com.calisto.spring.rest_api.entity.Buhdocument;

import java.util.List;

public interface BuhdocumentService {
    public List<Buhdocument> getAll();
    public Buhdocument add(Buhdocument buhdocument);
    public Buhdocument getBuhdocument(int id);
    public void delete(int id);
}
