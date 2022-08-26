package com.calisto.spring.rest_api.service.tender;

import com.calisto.spring.rest_api.DaO.tender.TenderDaO;
import com.calisto.spring.rest_api.entity.company.Tender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TenderServiceImpl implements TenderService{
    @Autowired
    TenderDaO tenderDaO;

    @Override
    @Transactional
    public List<Tender> getAll() {
        return tenderDaO.getAll();
    }

    @Override
    @Transactional
    public Tender addTender(Tender tender) {
        return tenderDaO.addTender(tender);
    }

    @Override
    @Transactional
    public Tender getTender(int id) {
        return tenderDaO.getTender(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        tenderDaO.delete(id);
    }

    @Override
    @Transactional
    public Tender editTender(Tender tender) {
        return tenderDaO.addTender(tender);
    }
}
