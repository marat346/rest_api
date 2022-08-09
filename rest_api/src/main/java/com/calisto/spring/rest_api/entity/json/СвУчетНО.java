package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СвУчетНО {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("СвНО")
    public СвНО свНО;
    @JsonProperty("ГРНДата")
    public ГРНДата гРНДата;
}
