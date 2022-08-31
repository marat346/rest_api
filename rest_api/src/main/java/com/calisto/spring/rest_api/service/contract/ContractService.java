package com.calisto.spring.rest_api.service.contract;

import com.calisto.spring.rest_api.entity.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> getAll();
    public Contract add(Contract contract);
    public Contract getContract(int id);
    public void delete(int id);
}
