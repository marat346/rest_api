package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ДоляУстКап {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("РазмерДоли")
    public РазмерДоли размерДоли;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
}
