package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.persistence.entity.MatchEntity;
import com.webunimag.eliminatoria.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class MatchController {

    private final MatchService matchService;
    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    @GetMapping
    public ResponseEntity<List<MatchEntity>> getAll(){
        return ResponseEntity.ok(this.matchService.getAll());
    }
    /*@GetMapping("/nombre/{name}")
    public ResponseEntity<MatchEntity> getById(@PathVariable String name){
        return ResponseEntity.ok(this.matchService.getAllMatchByTeamName(name));
    }*/
    @PostMapping
    public ResponseEntity<MatchEntity> addMatch( @RequestBody MatchEntity match){
        if(match.getIdMatch() == null || !this.matchService.existByIdMatch(match.getIdMatch())){
            return ResponseEntity.ok(this.matchService.saveMatch(match));
        }
        return ResponseEntity.badRequest().build();
    }
    @PatchMapping
    public ResponseEntity<MatchEntity> updateMatch( @RequestBody MatchEntity match){
        if(match.getIdMatch() != null && this.matchService.existByIdMatch(match.getIdMatch())){
            return ResponseEntity.ok(this.matchService.saveMatch(match));
        }
        return ResponseEntity.badRequest().build();
    }
}
