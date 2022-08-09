package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class АдресРФ {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("Регион")
    public Регион регион;
    @JsonProperty("Улица")
    public Улица улица;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
    @JsonProperty("ГРНДатаИспр")
    public ГРНДатаИспр гРНДатаИспр;
}
