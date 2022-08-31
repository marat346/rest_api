package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Buhdocument;
import com.calisto.spring.rest_api.service.buhdocument.BuhdocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/buhdocument")
public class BuhdocumentController {
    @Autowired
    BuhdocumentService buhdocumentService;

    @GetMapping("/all")
    public List<Buhdocument> getBuhdocument(){
        return buhdocumentService.getAll();
    }

    @PostMapping("/add")
    public Buhdocument addBuhdocument(@RequestBody Buhdocument buhdocument){
        return buhdocumentService.add(buhdocument);
    }

    @GetMapping("/get/{id}")
    public Buhdocument getBuhdocument(@PathVariable int id){
        return buhdocumentService.getBuhdocument(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        buhdocumentService.delete(id);
        return "Удалено!";
    }

    @PostMapping("/edit")
    public Buhdocument editBuhdocument(@RequestBody Buhdocument buhdocument){
        return buhdocumentService.add(buhdocument);
    }
}
