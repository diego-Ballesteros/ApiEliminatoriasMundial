package com.webunimag.eliminatoria.dto.mapper;

import com.webunimag.eliminatoria.dto.dto.TeamDto;
import com.webunimag.eliminatoria.persistence.entity.TeamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDto teamEntityToTeamDto(TeamEntity team);
    TeamEntity teamDtoToTeamEntity(TeamDto teamDto);

}
