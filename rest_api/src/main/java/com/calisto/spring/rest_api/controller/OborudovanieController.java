package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Oborudovanie;
import com.calisto.spring.rest_api.service.oborudovanie.OborudovanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/oborudovanie")
public class OborudovanieController {
    @Autowired
    OborudovanieService oborudovanieService;

    @GetMapping("/all")
    public List<Oborudovanie> getAllOborudovanie(){
        return oborudovanieService.getAll();
    }

    @PostMapping("/add")
    public Oborudovanie addOborudovanie(@RequestBody Oborudovanie oborudovanie){
        return oborudovanieService.add(oborudovanie);
    }

    @GetMapping("/get/{id}")
    public Oborudovanie oborudovanie(@PathVariable int id){
        return oborudovanieService.getOborudovanie(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        oborudovanieService.delete(id);
        return "Удалено!";
    }
}
