package com.calisto.spring.rest_api.service.akkredit;

import com.calisto.spring.rest_api.entity.Akkredit;

import java.util.List;

public interface AkkreditService {
    public List<Akkredit> getAll();
    public Akkredit add(Akkredit akkredit);
    public Akkredit getAkkredit(int id);
    public void delete(int id);
    public Akkredit editAkkredit(Akkredit akkredit);
}
