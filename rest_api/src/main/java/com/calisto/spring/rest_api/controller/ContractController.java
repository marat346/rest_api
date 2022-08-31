package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Contract;
import com.calisto.spring.rest_api.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @GetMapping("/all")
    public List<Contract> getAllContract(){
        return contractService.getAll();
    }

    @PostMapping("/add")
    public Contract addContract(@RequestBody Contract contract){
        return contractService.add(contract);
    }

    @GetMapping("/get/{id}")
    public Contract getContract(@PathVariable int id){
        return contractService.getContract(id);
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        contractService.delete(id);
        return "Удалено!";
    }
}
