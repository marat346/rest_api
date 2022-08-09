package com.calisto.spring.rest_api.entity.json;

import com.calisto.spring.rest_api.entity.json.Attributes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class СвНО {
    @JsonProperty("@attributes")
    public Attributes attributes;
}
