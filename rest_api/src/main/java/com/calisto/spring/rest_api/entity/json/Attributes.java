package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {
    @JsonProperty("ДатаВыг")
    public String датаВыг;
    public String zip_file;
    public String xml_file;
    @JsonProperty("ОГРН")
    public String оГРН;
    @JsonProperty("ДатаОГРН")
    public String датаОГРН;
    @JsonProperty("КодСпОбрЮЛ")
    public String кодСпОбрЮЛ;
    @JsonProperty("НаимСпОбрЮЛ")
    public String наимСпОбрЮЛ;
    @JsonProperty("ГРН")
    public String гРН;
    @JsonProperty("ДатаЗаписи")
    public String датаЗаписи;
    @JsonProperty("КодНО")
    public String кодНО;
    @JsonProperty("НаимНО")
    public String наимНО;
    @JsonProperty("АдрРО")
    public String адрРО;
    @JsonProperty("ИНН")
    public String иНН;
    @JsonProperty("КПП")
    public String кПП;
    @JsonProperty("ДатаПостУч")
    public String датаПостУч;
    @JsonProperty("РегНомПФ")
    public String регНомПФ;
    @JsonProperty("ДатаРег")
    public String датаРег;
    @JsonProperty("КодПФ")
    public String кодПФ;
    @JsonProperty("НаимПФ")
    public String наимПФ;
    @JsonProperty("ДатаВып")
    public String датаВып;
    @JsonProperty("СпрОПФ")
    public String спрОПФ;
    @JsonProperty("КодОПФ")
    public String кодОПФ;
    @JsonProperty("ПолнНаимОПФ")
    public String полнНаимОПФ;
    @JsonProperty("РегНомФСС")
    public String регНомФСС;
    @JsonProperty("КодФСС")
    public String кодФСС;
    @JsonProperty("НаимФСС")
    public String наимФСС;
    @JsonProperty("НаимВидКап")
    public String наимВидКап;
    @JsonProperty("СумКап")
    public String сумКап;
    @JsonProperty("Фамилия")
    public String фамилия;
    @JsonProperty("Имя")
    public String имя;
    @JsonProperty("Отчество")
    public String отчество;
    @JsonProperty("ИННФЛ")
    public String иННФЛ;
    @JsonProperty("ВидДолжн")
    public String видДолжн;
    @JsonProperty("НаимВидДолжн")
    public String наимВидДолжн;
    @JsonProperty("НаимДолжн")
    public String наимДолжн;
    @JsonProperty("НаимЮЛПолн")
    public String наимЮЛПолн;
    @JsonProperty("НаимЮЛСокр")
    public String наимЮЛСокр;
    @JsonProperty("НоминСтоим")
    public String номинСтоим;
    @JsonProperty("КодОКВЭД")
    public String кодОКВЭД;
    @JsonProperty("НаимОКВЭД")
    public String наимОКВЭД;
    @JsonProperty("ПрВерсОКВЭД")
    public String прВерсОКВЭД;
    @JsonProperty("НомЛиц")
    public String номЛиц;
    @JsonProperty("ДатаЛиц")
    public String датаЛиц;
    @JsonProperty("ДатаНачЛиц")
    public String датаНачЛиц;
    @JsonProperty("ДатаОкончЛиц")
    public String датаОкончЛиц;
    @JsonProperty("ИдЗап")
    public String идЗап;
    @JsonProperty("ДатаЗап")
    public String датаЗап;
    @JsonProperty("КодСПВЗ")
    public String кодСПВЗ;
    @JsonProperty("НаимВидЗап")
    public String наимВидЗап;
    @JsonProperty("Серия")
    public String серия;
    @JsonProperty("Номер")
    public String номер;
    @JsonProperty("ДатаВыдСвид")
    public String датаВыдСвид;
    public String income;
    public String outcome;
    @JsonProperty("Индекс")
    public String индекс;
    @JsonProperty("КодРегион")
    public String кодРегион;
    @JsonProperty("КодАдрКладр")
    public String кодАдрКладр;
    @JsonProperty("Дом")
    public String дом;
    @JsonProperty("Корпус")
    public String корпус;
    @JsonProperty("Кварт")
    public String кварт;
    public String tax_id_1;
    public String tax_id_2;
    public String tax_id_3;
    public String tax_id_5;
    public String n;
    public String inc_date;
    public String cat;
    public String from_inn;
    public String term;
    public String accept_date;
    public String end_date;
    public String form_id;
    public String type_id;
    public String s;
    public String s_type;
    public String violation;
    public String misuse;
    public String y;
    public String tax_system;
    @JsonProperty("ТипРегион")
    public String типРегион;
    @JsonProperty("НаимРегион")
    public String наимРегион;
    @JsonProperty("ТипУлица")
    public String типУлица;
    @JsonProperty("НаимУлица")
    public String наимУлица;

    public Attributes() {
    }

    public String getДатаВыг() {
        return датаВыг;
    }

    public void setДатаВыг(String датаВыг) {
        this.датаВыг = датаВыг;
    }

    public String getZip_file() {
        return zip_file;
    }

    public void setZip_file(String zip_file) {
        this.zip_file = zip_file;
    }

    public String getXml_file() {
        return xml_file;
    }

    public void setXml_file(String xml_file) {
        this.xml_file = xml_file;
    }

    public String getоГРН() {
        return оГРН;
    }

    public void setоГРН(String оГРН) {
        this.оГРН = оГРН;
    }

    public String getДатаОГРН() {
        return датаОГРН;
    }

    public void setДатаОГРН(String датаОГРН) {
        this.датаОГРН = датаОГРН;
    }

    public String getКодСпОбрЮЛ() {
        return кодСпОбрЮЛ;
    }

    public void setКодСпОбрЮЛ(String кодСпОбрЮЛ) {
        this.кодСпОбрЮЛ = кодСпОбрЮЛ;
    }

    public String getНаимСпОбрЮЛ() {
        return наимСпОбрЮЛ;
    }

    public void setНаимСпОбрЮЛ(String наимСпОбрЮЛ) {
        this.наимСпОбрЮЛ = наимСпОбрЮЛ;
    }

    public String getгРН() {
        return гРН;
    }

    public void setгРН(String гРН) {
        this.гРН = гРН;
    }

    public String getДатаЗаписи() {
        return датаЗаписи;
    }

    public void setДатаЗаписи(String датаЗаписи) {
        this.датаЗаписи = датаЗаписи;
    }

    public String getКодНО() {
        return кодНО;
    }

    public void setКодНО(String кодНО) {
        this.кодНО = кодНО;
    }

    public String getНаимНО() {
        return наимНО;
    }

    public void setНаимНО(String наимНО) {
        this.наимНО = наимНО;
    }

    public String getАдрРО() {
        return адрРО;
    }

    public void setАдрРО(String адрРО) {
        this.адрРО = адрРО;
    }

    public String getиНН() {
        return иНН;
    }

    public void setиНН(String иНН) {
        this.иНН = иНН;
    }

    public String getкПП() {
        return кПП;
    }

    public void setкПП(String кПП) {
        this.кПП = кПП;
    }

    public String getДатаПостУч() {
        return датаПостУч;
    }

    public void setДатаПостУч(String датаПостУч) {
        this.датаПостУч = датаПостУч;
    }

    public String getРегНомПФ() {
        return регНомПФ;
    }

    public void setРегНомПФ(String регНомПФ) {
        this.регНомПФ = регНомПФ;
    }

    public String getДатаРег() {
        return датаРег;
    }

    public void setДатаРег(String датаРег) {
        this.датаРег = датаРег;
    }

    public String getКодПФ() {
        return кодПФ;
    }

    public void setКодПФ(String кодПФ) {
        this.кодПФ = кодПФ;
    }

    public String getНаимПФ() {
        return наимПФ;
    }

    public void setНаимПФ(String наимПФ) {
        this.наимПФ = наимПФ;
    }

    public String getДатаВып() {
        return датаВып;
    }

    public void setДатаВып(String датаВып) {
        this.датаВып = датаВып;
    }

    public String getСпрОПФ() {
        return спрОПФ;
    }

    public void setСпрОПФ(String спрОПФ) {
        this.спрОПФ = спрОПФ;
    }

    public String getКодОПФ() {
        return кодОПФ;
    }

    public void setКодОПФ(String кодОПФ) {
        this.кодОПФ = кодОПФ;
    }

    public String getПолнНаимОПФ() {
        return полнНаимОПФ;
    }

    public void setПолнНаимОПФ(String полнНаимОПФ) {
        this.полнНаимОПФ = полнНаимОПФ;
    }

    public String getРегНомФСС() {
        return регНомФСС;
    }

    public void setРегНомФСС(String регНомФСС) {
        this.регНомФСС = регНомФСС;
    }

    public String getКодФСС() {
        return кодФСС;
    }

    public void setКодФСС(String кодФСС) {
        this.кодФСС = кодФСС;
    }

    public String getНаимФСС() {
        return наимФСС;
    }

    public void setНаимФСС(String наимФСС) {
        this.наимФСС = наимФСС;
    }

    public String getНаимВидКап() {
        return наимВидКап;
    }

    public void setНаимВидКап(String наимВидКап) {
        this.наимВидКап = наимВидКап;
    }

    public String getСумКап() {
        return сумКап;
    }

    public void setСумКап(String сумКап) {
        this.сумКап = сумКап;
    }

    public String getФамилия() {
        return фамилия;
    }

    public void setФамилия(String фамилия) {
        this.фамилия = фамилия;
    }

    public String getИмя() {
        return имя;
    }

    public void setИмя(String имя) {
        this.имя = имя;
    }

    public String getОтчество() {
        return отчество;
    }

    public void setОтчество(String отчество) {
        this.отчество = отчество;
    }

    public String getиННФЛ() {
        return иННФЛ;
    }

    public void setиННФЛ(String иННФЛ) {
        this.иННФЛ = иННФЛ;
    }

    public String getВидДолжн() {
        return видДолжн;
    }

    public void setВидДолжн(String видДолжн) {
        this.видДолжн = видДолжн;
    }

    public String getНаимВидДолжн() {
        return наимВидДолжн;
    }

    public void setНаимВидДолжн(String наимВидДолжн) {
        this.наимВидДолжн = наимВидДолжн;
    }

    public String getНаимДолжн() {
        return наимДолжн;
    }

    public void setНаимДолжн(String наимДолжн) {
        this.наимДолжн = наимДолжн;
    }

    public String getНаимЮЛПолн() {
        return наимЮЛПолн;
    }

    public void setНаимЮЛПолн(String наимЮЛПолн) {
        this.наимЮЛПолн = наимЮЛПолн;
    }

    public String getНаимЮЛСокр() {
        return наимЮЛСокр;
    }

    public void setНаимЮЛСокр(String наимЮЛСокр) {
        this.наимЮЛСокр = наимЮЛСокр;
    }

    public String getНоминСтоим() {
        return номинСтоим;
    }

    public void setНоминСтоим(String номинСтоим) {
        this.номинСтоим = номинСтоим;
    }

    public String getКодОКВЭД() {
        return кодОКВЭД;
    }

    public void setКодОКВЭД(String кодОКВЭД) {
        this.кодОКВЭД = кодОКВЭД;
    }

    public String getНаимОКВЭД() {
        return наимОКВЭД;
    }

    public void setНаимОКВЭД(String наимОКВЭД) {
        this.наимОКВЭД = наимОКВЭД;
    }

    public String getПрВерсОКВЭД() {
        return прВерсОКВЭД;
    }

    public void setПрВерсОКВЭД(String прВерсОКВЭД) {
        this.прВерсОКВЭД = прВерсОКВЭД;
    }

    public String getНомЛиц() {
        return номЛиц;
    }

    public void setНомЛиц(String номЛиц) {
        this.номЛиц = номЛиц;
    }

    public String getДатаЛиц() {
        return датаЛиц;
    }

    public void setДатаЛиц(String датаЛиц) {
        this.датаЛиц = датаЛиц;
    }

    public String getДатаНачЛиц() {
        return датаНачЛиц;
    }

    public void setДатаНачЛиц(String датаНачЛиц) {
        this.датаНачЛиц = датаНачЛиц;
    }

    public String getДатаОкончЛиц() {
        return датаОкончЛиц;
    }

    public void setДатаОкончЛиц(String датаОкончЛиц) {
        this.датаОкончЛиц = датаОкончЛиц;
    }

    public String getИдЗап() {
        return идЗап;
    }

    public void setИдЗап(String идЗап) {
        this.идЗап = идЗап;
    }

    public String getДатаЗап() {
        return датаЗап;
    }

    public void setДатаЗап(String датаЗап) {
        this.датаЗап = датаЗап;
    }

    public String getКодСПВЗ() {
        return кодСПВЗ;
    }

    public void setКодСПВЗ(String кодСПВЗ) {
        this.кодСПВЗ = кодСПВЗ;
    }

    public String getНаимВидЗап() {
        return наимВидЗап;
    }

    public void setНаимВидЗап(String наимВидЗап) {
        this.наимВидЗап = наимВидЗап;
    }

    public String getСерия() {
        return серия;
    }

    public void setСерия(String серия) {
        this.серия = серия;
    }

    public String getНомер() {
        return номер;
    }

    public void setНомер(String номер) {
        this.номер = номер;
    }

    public String getДатаВыдСвид() {
        return датаВыдСвид;
    }

    public void setДатаВыдСвид(String датаВыдСвид) {
        this.датаВыдСвид = датаВыдСвид;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getИндекс() {
        return индекс;
    }

    public void setИндекс(String индекс) {
        this.индекс = индекс;
    }

    public String getКодРегион() {
        return кодРегион;
    }

    public void setКодРегион(String кодРегион) {
        this.кодРегион = кодРегион;
    }

    public String getКодАдрКладр() {
        return кодАдрКладр;
    }

    public void setКодАдрКладр(String кодАдрКладр) {
        this.кодАдрКладр = кодАдрКладр;
    }

    public String getДом() {
        return дом;
    }

    public void setДом(String дом) {
        this.дом = дом;
    }

    public String getКорпус() {
        return корпус;
    }

    public void setКорпус(String корпус) {
        this.корпус = корпус;
    }

    public String getКварт() {
        return кварт;
    }

    public void setКварт(String кварт) {
        this.кварт = кварт;
    }

    public String getTax_id_1() {
        return tax_id_1;
    }

    public void setTax_id_1(String tax_id_1) {
        this.tax_id_1 = tax_id_1;
    }

    public String getTax_id_2() {
        return tax_id_2;
    }

    public void setTax_id_2(String tax_id_2) {
        this.tax_id_2 = tax_id_2;
    }

    public String getTax_id_3() {
        return tax_id_3;
    }

    public void setTax_id_3(String tax_id_3) {
        this.tax_id_3 = tax_id_3;
    }

    public String getTax_id_5() {
        return tax_id_5;
    }

    public void setTax_id_5(String tax_id_5) {
        this.tax_id_5 = tax_id_5;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getInc_date() {
        return inc_date;
    }

    public void setInc_date(String inc_date) {
        this.inc_date = inc_date;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getFrom_inn() {
        return from_inn;
    }

    public void setFrom_inn(String from_inn) {
        this.from_inn = from_inn;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAccept_date() {
        return accept_date;
    }

    public void setAccept_date(String accept_date) {
        this.accept_date = accept_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }

    public String getMisuse() {
        return misuse;
    }

    public void setMisuse(String misuse) {
        this.misuse = misuse;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getTax_system() {
        return tax_system;
    }

    public void setTax_system(String tax_system) {
        this.tax_system = tax_system;
    }

    public String getТипРегион() {
        return типРегион;
    }

    public void setТипРегион(String типРегион) {
        this.типРегион = типРегион;
    }

    public String getНаимРегион() {
        return наимРегион;
    }

    public void setНаимРегион(String наимРегион) {
        this.наимРегион = наимРегион;
    }

    public String getТипУлица() {
        return типУлица;
    }

    public void setТипУлица(String типУлица) {
        this.типУлица = типУлица;
    }

    public String getНаимУлица() {
        return наимУлица;
    }

    public void setНаимУлица(String наимУлица) {
        this.наимУлица = наимУлица;
    }
}
