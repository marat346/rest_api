package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.logic.SpisokSpravok;

// класс собирает всю информацию и запускает процесс создания файлов
public class BuilderDocs {
    public void startBuild(Company company,
                           Tender tender,
                           SpisokSpravok spisokSpravok,
                           SpisokForm spisokForm,
                           String address){
        if (spisokForm.form1a==true){
            GeneratorDocForm1a generatorDocForm1a = new GeneratorDocForm1a();
//            generatorDocForm1a.launch(company, address + "\\Квалификационная часть", tender);
        }
    }
}
