package com.calisto.spring.rest_api.DaO.tender;

import com.calisto.spring.rest_api.entity.Tender;

import java.util.List;

public interface TenderDaO {
    public List<Tender> getAll();
    public Tender add(Tender tender);
    public Tender getTender(int id);
    public void delete(int id);
}
