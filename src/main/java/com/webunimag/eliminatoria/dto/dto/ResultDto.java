package com.webunimag.eliminatoria.dto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ResultDto {
    @JsonProperty("Id")
    private Integer idResult;
    @JsonProperty("Goles local")
    @PositiveOrZero
    private Integer goalLocal;
    @JsonProperty("Goles visitante")
    private Integer goalVisiting;
    @PositiveOrZero
    @JsonProperty("Tarjetas amarillas")
    @PositiveOrZero
    private Integer nRedFlag;
    @JsonProperty("Tarjetas Rojas")
    @PositiveOrZero
    private Integer nYellowFlag;

}
