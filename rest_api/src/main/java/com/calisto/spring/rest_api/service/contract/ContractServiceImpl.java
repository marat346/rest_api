package com.calisto.spring.rest_api.service.contract;

import com.calisto.spring.rest_api.DaO.contract.ContractDaO;
import com.calisto.spring.rest_api.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    ContractDaO contractDaO;

    @Override
    @Transactional
    public List<Contract> getAll() {
        return contractDaO.getAll();
    }

    @Override
    @Transactional
    public Contract add(Contract contract) {
        contractDaO.add(contract);
        return contract;
    }

    @Override
    @Transactional
    public Contract getContract(int id) {
        return contractDaO.getContract(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        contractDaO.delete(id);
    }
}
