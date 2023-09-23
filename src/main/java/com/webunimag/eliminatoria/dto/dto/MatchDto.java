package com.webunimag.eliminatoria.dto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.mapstruct.Mapping;


import java.time.LocalDateTime;
@Data
public class MatchDto {

    @JsonProperty("Id")
    private Integer idMatch;
    @JsonProperty("Estadio")
    @NotBlank
    private String stadium;
    @JsonProperty("Arbitro")
    private String referee;
    @JsonProperty("Fecha")
    private LocalDateTime date;
    @JsonProperty("ResultadoDelPartido")
    private ResultDto result;

}
