package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СвОбрЮЛ {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("СпОбрЮЛ")
    public СпОбрЮЛ спОбрЮЛ;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
}
