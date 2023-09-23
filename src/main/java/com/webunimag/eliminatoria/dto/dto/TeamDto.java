package com.webunimag.eliminatoria.dto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TeamDto {

    @JsonProperty("Id")
    private Integer idTeam;
    @JsonProperty("Nombre")
    @NotBlank
    private String name;
    @JsonProperty("DirectorTecnico")
    @NotBlank
    private String dt;
    @JsonProperty("PartidosDeLocal")
    private Set<MatchDto> localMatches;
    @JsonProperty("PartidosDeVisitante")
    private Set<MatchDto> visitingMatches;

}
