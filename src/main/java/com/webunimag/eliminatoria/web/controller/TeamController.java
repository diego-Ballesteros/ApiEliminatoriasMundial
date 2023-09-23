package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.dto.dto.TeamDto;
import com.webunimag.eliminatoria.dto.mapper.TeamMapper;
import com.webunimag.eliminatoria.exceptions.TeamNotFoundException;
import com.webunimag.eliminatoria.persistence.entity.TeamEntity;
import com.webunimag.eliminatoria.service.TeamService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipos")
@Validated
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }
    @GetMapping()
    public ResponseEntity<List<TeamDto>> getAll(){
       // List<TeamEntity> teamsList = this.teamService.getAll();
        List<TeamDto> teamsListDto = null;

        teamsListDto = this.teamService.getAll().stream()
                .map(team -> this.teamMapper.teamEntityToTeamDto(team))
                .collect(Collectors.toList());
        return ResponseEntity.ok(teamsListDto);
    }
    @GetMapping("/nombre")
    public ResponseEntity<TeamDto> getByName(@RequestParam @NotBlank String name){
        TeamDto teamDto = null;
        teamDto = this.teamMapper.teamEntityToTeamDto(this.teamService.getByName(name));
        return ResponseEntity.ok(teamDto);
    }
    @PostMapping()
    public ResponseEntity<TeamDto> addTeam(@RequestBody @Valid TeamEntity team){
       if(team.getIdTeam() == null || !this.teamService.existTeamById(team.getIdTeam())){
           TeamEntity teamCreated = this.teamService.saveTeam(team);
           URI location = ServletUriComponentsBuilder
                   .fromCurrentRequest()
                   .path("/{idTeam}")
                   .buildAndExpand(teamCreated.getIdTeam())
                   .toUri();
           TeamDto teamDto = this.teamMapper.teamEntityToTeamDto(teamCreated);
           return  ResponseEntity.created(location).body(teamDto);
        }
       return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{idTeam}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable @Min(1) int idTeam ,@RequestBody @Valid TeamEntity team){
        if(this.teamService.existTeamById(idTeam)){
            TeamEntity teamCreated = this.teamService.saveTeam(team);
            TeamDto teamDto = this.teamMapper.teamEntityToTeamDto(teamCreated);
            return ResponseEntity.ok(teamDto);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{idTeam}")
    public ResponseEntity<Void> deleteTeam(@PathVariable @Min(1) int idTeam){
        if(this.teamService.existTeamById(idTeam)){
            this.teamService.deleteTeam(idTeam);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/contarlocal")
    public ResponseEntity<Integer> countIsLocal (@RequestParam @NotBlank String name){
        return ResponseEntity.ok(this.teamService.countIsLocal(name));
    }
}
