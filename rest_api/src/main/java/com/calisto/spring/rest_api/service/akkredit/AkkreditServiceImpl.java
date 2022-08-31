package com.calisto.spring.rest_api.service.akkredit;

import com.calisto.spring.rest_api.DaO.akkredit.AkkreditDaO;
import com.calisto.spring.rest_api.entity.Akkredit;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class AkkreditServiceImpl implements AkkreditService{
    @Autowired
    AkkreditDaO akkreditDaO;

    @Override
    @Transactional
    public List<Akkredit> getAll() {
        return akkreditDaO.getAll();
    }

    @Override
    @Transactional
    public Akkredit add(Akkredit akkredit) {
        akkreditDaO.add(akkredit);
        return akkredit;
    }

    @Override
    @Transactional
    public Akkredit getAkkredit(int id) {
        return akkreditDaO.getAkkredit(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        akkreditDaO.delete(id);
    }

    @Override
    @Transactional
    public Akkredit editAkkredit(Akkredit akkredit) {
        return akkreditDaO.add(akkredit);
    }
}
