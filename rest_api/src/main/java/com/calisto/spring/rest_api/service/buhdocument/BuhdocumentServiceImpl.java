package com.calisto.spring.rest_api.service.buhdocument;

import com.calisto.spring.rest_api.DaO.buhdocument.BuhdocumentDaO;
import com.calisto.spring.rest_api.entity.Buhdocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BuhdocumentServiceImpl implements BuhdocumentService{
    @Autowired
    BuhdocumentDaO buhdocumentDaO;


    @Override
    @Transactional
    public List<Buhdocument> getAll() {
        return buhdocumentDaO.getAll();
    }

    @Override
    @Transactional
    public Buhdocument add(Buhdocument buhdocument) {
        buhdocumentDaO.add(buhdocument);
        return buhdocument;
    }

    @Override
    @Transactional
    public Buhdocument getBuhdocument(int id) {
        return buhdocumentDaO.getBuhdocument(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        buhdocumentDaO.delete(id);
    }
}
