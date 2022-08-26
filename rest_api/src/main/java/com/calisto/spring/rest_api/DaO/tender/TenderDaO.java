package com.calisto.spring.rest_api.DaO.tender;

import com.calisto.spring.rest_api.entity.company.Tender;

import java.util.List;

public interface TenderDaO {
    public List<Tender> getAll();

    public Tender addTender(Tender tender);

    public Tender getTender(int id);

    public void delete(int id);
}
