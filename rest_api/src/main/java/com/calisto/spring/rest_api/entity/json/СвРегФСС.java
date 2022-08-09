package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СвРегФСС {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("СвОргФСС")
    public СвОргФСС свОргФСС;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
}
