package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class СведДолжнФЛ {
    @JsonProperty("ГРНДатаПерв")
    public ГРНДатаПерв гРНДатаПерв;
    @JsonProperty("СвФЛ")
    public СвФЛ свФЛ;
    @JsonProperty("СвДолжн")
    public СвДолжн свДолжн;
}
