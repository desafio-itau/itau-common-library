package com.itau.common.library.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleErrorResponse {

    @JsonProperty("erro")
    private String erro;

    @JsonProperty("codigo")
    private String codigo;
}

