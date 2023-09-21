package com.webunimag.eliminatoria.dto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webunimag.eliminatoria.dto.dto.MatchDto;
import lombok.Data;

import java.util.List;

@Data
public class TeamDto {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Nombre")
    private String name;
    @JsonProperty("DirectorTecnico")
    private String dt;
    @JsonProperty("PartidosJugados")
    private List<MatchDto> matches;
}
