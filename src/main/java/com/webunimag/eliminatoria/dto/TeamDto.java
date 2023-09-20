package com.webunimag.eliminatoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class TeamDto {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("Nombre")
    private String name;
    @JsonProperty("DirectorTecnico")
    private String dt;
    @JsonProperty("PartidosJugados")
    private Set<MatchDto> matches;
}
