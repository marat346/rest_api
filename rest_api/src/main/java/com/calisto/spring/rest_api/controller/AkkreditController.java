package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Akkredit;
import com.calisto.spring.rest_api.service.akkredit.AkkreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/akkredit")
public class AkkreditController {

    @Autowired
    AkkreditService akkreditService;

    @GetMapping("/all")
    public List<Akkredit> getAllAkkredit(){
        return akkreditService.getAll();
    }

    @PostMapping("/add")
    public Akkredit addAkkredit(@RequestBody Akkredit akkredit){
        return akkreditService.add(akkredit);
    }

    @GetMapping("/get/{id}")
    public Akkredit getAkkredit(@PathVariable int id){
        return akkreditService.getAkkredit(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        akkreditService.delete(id);
        return "Удалено!";
    }

    @PostMapping("/edit")
    public Akkredit editAkkredit(@RequestBody Akkredit akkredit){
        return akkreditService.editAkkredit(akkredit);
    }
}
