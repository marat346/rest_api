package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СвЗапЕГРЮЛ {
    @JsonProperty("@attributes")
    public Attributes attributes;
    @JsonProperty("ВидЗап")
    public ВидЗап видЗап;
    @JsonProperty("СвРегОрг")
    public СвРегОрг свРегОрг;
    @JsonProperty("СведПредДок")
    public Object сведПредДок;
    @JsonProperty("СвСвид")
    public СвСвид свСвид;
}
