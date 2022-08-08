package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.service.tender.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/tender")
public class TenderController {
    @Autowired
    TenderService tenderService;

    @GetMapping("/all")
    public List<Tender> getAllTender(){
        List<Tender> tenderList = tenderService.getAll();
        return tenderList;
    }
}
