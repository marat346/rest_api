package com.calisto.spring.rest_api.DaO.akkredit;

import com.calisto.spring.rest_api.entity.Akkredit;

import java.util.List;

public interface AkkreditDaO {
    public List<Akkredit> getAll();

    public Akkredit add(Akkredit akkredit);

    public Akkredit getAkkredit(int id);

    public void delete(int id);
}
