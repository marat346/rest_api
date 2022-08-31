package com.calisto.spring.rest_api.DaO.buhdocument;

import com.calisto.spring.rest_api.entity.Buhdocument;

import java.util.List;

public interface BuhdocumentDaO {
    public List<Buhdocument> getAll();
    public Buhdocument add(Buhdocument buhdocument);
    public Buhdocument getBuhdocument(int id);
    public void delete(int id);
}
