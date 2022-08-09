package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class СвЮЛ {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("СвНаимЮЛ")
    public СвНаимЮЛ свНаимЮЛ;
    @JsonProperty("СвАдресЮЛ")
    public СвАдресЮЛ свАдресЮЛ;
    @JsonProperty("СвОбрЮЛ")
    public СвОбрЮЛ свОбрЮЛ;
    @JsonProperty("СвРегОрг")
    public СвРегОрг свРегОрг;
    @JsonProperty("СвУчетНО")
    public СвУчетНО свУчетНО;
    @JsonProperty("СвРегПФ")
    public СвРегПФ свРегПФ;
    @JsonProperty("СвРегФСС")
    public СвРегФСС свРегФСС;
    @JsonProperty("СвУстКап")
    public СвУстКап свУстКап;
    @JsonProperty("СведДолжнФЛ")
    public ArrayList<СведДолжнФЛ> сведДолжнФЛ;
    @JsonProperty("СвУчредит")
    public СвУчредит свУчредит;
    @JsonProperty("СвОКВЭД")
    public СвОКВЭД свОКВЭД;
    @JsonProperty("СвЛицензия")
    public ArrayList<СвЛицензия> свЛицензия;
    @JsonProperty("СвЗапЕГРЮЛ")
    public ArrayList<СвЗапЕГРЮЛ> свЗапЕГРЮЛ;
}
