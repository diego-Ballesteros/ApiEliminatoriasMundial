package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.persistence.entity.TeamEntity;
import com.webunimag.eliminatoria.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping()
    public ResponseEntity<List<TeamEntity>> getAll(){
        /*List<TeamEntity> teamsList = this.teamService.getAll();
        return ResponseEntity.ok().body(teamsList);*/

        return ResponseEntity.ok(this.teamService.getAll());


    }
    @GetMapping("/nombre")
    public ResponseEntity<TeamEntity> getByName(@RequestParam String name){
        return ResponseEntity.ok(this.teamService.getByName(name));
    }
    @PostMapping()
    public ResponseEntity<TeamEntity> addTeam(@RequestBody TeamEntity team){
       if(team.getIdTeam() == null || !this.teamService.existTeamById(team.getIdTeam())){
           return ResponseEntity.ok(this.teamService.saveTeam(team));
        }
       return ResponseEntity.badRequest().build();

//        TeamEntity teamCreated = this.teamService.saveTeam(team);
//        URI location = ServletUriComponentsBuilder.
//                fromCurrentRequest().
//                buildAndExpand().
//                toUri();
//        return  ResponseEntity.created(location).body(teamCreated);
    }
    @PutMapping("/{idTeam}")
    public ResponseEntity<TeamEntity> updateTeam(@PathVariable int idTeam ,@RequestBody TeamEntity team){
        if(this.teamService.existTeamById(idTeam)){
            return ResponseEntity.ok(this.teamService.saveTeam(team));
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{idTeam}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int idTeam){
        if(this.teamService.existTeamById(idTeam)){
            this.teamService.deleteTeam(idTeam);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/contarlocal")
    public ResponseEntity<Integer> countIsLocal (@RequestParam String name){
        return ResponseEntity.ok(this.teamService.countIsLocal(name));
    }
}
