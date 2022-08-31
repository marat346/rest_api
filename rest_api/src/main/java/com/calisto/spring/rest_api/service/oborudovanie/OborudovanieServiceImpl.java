package com.calisto.spring.rest_api.service.oborudovanie;

import com.calisto.spring.rest_api.DaO.oborudovanie.OborudovanieDaO;
import com.calisto.spring.rest_api.entity.Oborudovanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OborudovanieServiceImpl implements OborudovanieService{
    @Autowired
    OborudovanieDaO oborudovanieDaO;


    @Override
    @Transactional
    public List<Oborudovanie> getAll() {
        return oborudovanieDaO.getAll();
    }

    @Override
    @Transactional
    public Oborudovanie add(Oborudovanie oborudovanie) {
        oborudovanieDaO.add(oborudovanie);
        return oborudovanie;
    }

    @Override
    @Transactional
    public Oborudovanie getOborudovanie(int id) {
        return oborudovanieDaO.getOborudovanie(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        oborudovanieDaO.delete(id);
    }
}
