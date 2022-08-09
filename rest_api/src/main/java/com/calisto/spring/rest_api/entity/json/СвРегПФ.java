package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СвРегПФ {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("СвОргПФ")
    public СвОргПФ свОргПФ;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
}
