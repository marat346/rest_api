package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class СвОКВЭД {
    @JsonProperty("СвОКВЭДОсн")
    public СвОКВЭДОсн свОКВЭДОсн;
    @JsonProperty("СвОКВЭДДоп")
    public ArrayList<СвОКВЭДДоп> свОКВЭДДоп;
}
