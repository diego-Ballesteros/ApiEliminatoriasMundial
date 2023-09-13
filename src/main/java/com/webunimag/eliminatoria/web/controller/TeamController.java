package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.persistence.entity.TeamEntity;
import com.webunimag.eliminatoria.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eliminatorias")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping("/equipos")
    public ResponseEntity<List<TeamEntity>> getAll(){
        return ResponseEntity.ok(this.teamService.getAll());
    }
    @GetMapping("/equipos/nombre")
    public ResponseEntity<TeamEntity> getByName(@RequestParam String name){
        return ResponseEntity.ok(this.teamService.getByName(name));
    }
}
