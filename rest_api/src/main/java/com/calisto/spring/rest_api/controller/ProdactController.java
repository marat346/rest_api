package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Prodact;
import com.calisto.spring.rest_api.service.prodact.ProdactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/prodact")
public class ProdactController {
    @Autowired
    ProdactService prodactService;

    @GetMapping("/all")
    public List<Prodact>getAllProdact(){
        return prodactService.getAll();
    }

    @PostMapping("/add")
    public Prodact addProdact(@RequestBody Prodact prodact){
        return prodactService.add(prodact);
    }

    @GetMapping("/get/{id}")
    public Prodact getProdact(@PathVariable int id){
        return prodactService.getProdact(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        prodactService.delete(id);
        return "Удалено!";
    }
}
