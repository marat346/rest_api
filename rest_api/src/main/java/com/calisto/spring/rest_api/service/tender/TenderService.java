package com.calisto.spring.rest_api.service.tender;

import com.calisto.spring.rest_api.entity.Tender;

import java.util.List;

public interface TenderService {
    public List<Tender> getAll();

    public Tender addTender(Tender tender);

    public Tender getTender(int id);

    public void delete(int id);

    public Tender editTender(Tender tender);
}
