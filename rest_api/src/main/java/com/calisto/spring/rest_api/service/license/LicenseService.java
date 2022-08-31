package com.calisto.spring.rest_api.service.license;

import com.calisto.spring.rest_api.entity.License;

import java.util.List;

public interface LicenseService {
    public List<License> getAll();
    public License add(License license);
    public License getLicense(int id);
    public void delete(int id);
}
