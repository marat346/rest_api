package com.calisto.spring.rest_api.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class УчрФЛ {
    @JsonProperty("ГРНДатаПерв")
    public ГРНДатаПерв гРНДатаПерв;
    @JsonProperty("СвФЛ")
    public СвФЛ свФЛ;
    @JsonProperty("ДоляУстКап")
    public ДоляУстКап доляУстКап;
}
