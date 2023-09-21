package com.webunimag.eliminatoria.dto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.time.LocalDateTime;
@Data
public class MatchDto {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Estadio")
    private String stadium;
    @JsonProperty("Arbitro")
    private String referee;
    @JsonProperty("Fecha")
    private LocalDateTime date;

}
