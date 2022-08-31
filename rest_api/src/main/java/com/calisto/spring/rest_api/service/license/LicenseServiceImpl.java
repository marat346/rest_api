package com.calisto.spring.rest_api.service.license;

import com.calisto.spring.rest_api.DaO.licenzii.LicenseDaO;
import com.calisto.spring.rest_api.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService{

    @Autowired
    LicenseDaO licenseDaO;

    @Override
    @Transactional
    public List<License> getAll() {
        return licenseDaO.getAll();
    }

    @Override
    @Transactional
    public License add(License license) {
        licenseDaO.add(license);
        return license;
    }

    @Override
    @Transactional
    public License getLicense(int id) {
        return licenseDaO.getLicense(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        licenseDaO.delete(id);
    }
}
