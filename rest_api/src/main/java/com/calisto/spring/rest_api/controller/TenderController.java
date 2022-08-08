package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.service.tender.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public Tender addTeder(@RequestBody Tender tender) {
        Tender ten = tenderService.addTender(tender);
        return ten;
    }

    @GetMapping("/get/{id}")
    public Tender gettender(@PathVariable int id){
        Tender tender = tenderService.getTender(id);
        return tender;
    }

    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable int id){
        tenderService.delete(id);
        return "Удалено!";
    }

    @PostMapping("/edit")
    public Tender editTender(@RequestBody Tender tender){
        Tender ten = tenderService.editTender(tender);
        return ten;
    }
}
