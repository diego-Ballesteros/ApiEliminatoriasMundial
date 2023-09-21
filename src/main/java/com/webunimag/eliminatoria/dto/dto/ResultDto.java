package com.webunimag.eliminatoria.dto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultDto {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Goles local")
    private Integer goalLocal;
    @JsonProperty("Goles visitante")
    private Integer goalVisiting;
    @JsonProperty("Tarjetas amarillas")
    private Integer nRedFlag;
    @JsonProperty("Tarjetas Rojas")

    private Integer nYellowFlag;

}
