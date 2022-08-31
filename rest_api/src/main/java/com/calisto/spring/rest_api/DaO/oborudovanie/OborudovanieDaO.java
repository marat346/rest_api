package com.calisto.spring.rest_api.DaO.oborudovanie;

import com.calisto.spring.rest_api.entity.Oborudovanie;

import java.util.List;

public interface OborudovanieDaO {
    public List<Oborudovanie>getAll();
    public Oborudovanie add(Oborudovanie oborudovanie);
    public Oborudovanie getOborudovanie(int id);
    public void delete(int id);
}
