package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("СвЮЛ")
    public СвЮЛ свЮЛ;
    public Fin fin;
}
