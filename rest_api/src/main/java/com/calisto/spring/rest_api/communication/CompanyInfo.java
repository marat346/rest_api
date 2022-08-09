package com.calisto.spring.rest_api.communication;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.json.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class CompanyInfo {
    @Autowired
    RestTemplate restTemplate;
    public final String url ="https://egrul.itsoft.ru/";

    public Company getCompanyInfo (String inn){
        ResponseEntity<List<Attributes>> responseEntity = restTemplate.exchange((url + "/" + inn + ".json"),
                HttpMethod.GET,null,new ParameterizedTypeReference<List <Attributes>>(){});
        Attributes com = responseEntity.getBody().get(0);
        Company company = new Company();
        company.setInn(com.getиНН());
        company.setForm(com.getНаимЮЛСокр());
        company.setName(com.getИмя());
        company.setKpp(com.getкПП());
        company.setOgrn(com.getоГРН());
        return company;
    }
}
