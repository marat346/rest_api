package com.calisto.spring.rest_api.service.tender;

import com.calisto.spring.rest_api.DaO.tender.TenderDaO;
import com.calisto.spring.rest_api.entity.Tender;
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
}
