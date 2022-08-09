package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СвНаимЮЛ {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
}
