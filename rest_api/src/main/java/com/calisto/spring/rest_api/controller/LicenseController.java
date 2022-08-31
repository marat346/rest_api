package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.License;
import com.calisto.spring.rest_api.service.license.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/license")
public class LicenseController {
    @Autowired
    LicenseService licenseService;

    @GetMapping("/all")
    public List<License> getLicense(){
        return licenseService.getAll();
    }

    @PostMapping("/add")
    public License license(@RequestBody License license){
        return licenseService.add(license);
    }

    @GetMapping("/get/{id}")
    public License getLicense(@PathVariable int id){
        return licenseService.getLicense(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        licenseService.delete(id);
        return "Удалено!";
    }
}
