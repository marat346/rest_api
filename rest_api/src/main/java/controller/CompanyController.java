package controller;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/all")
    public List<Company> company (){
        List<Company> companyList = companyService.getAll();
        return companyList;
    }

}
