package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СвЛицензия {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("НаимЛицВидДеят")
    public String наимЛицВидДеят;
    @JsonProperty("ЛицОргВыдЛиц")
    public String лицОргВыдЛиц;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
}
