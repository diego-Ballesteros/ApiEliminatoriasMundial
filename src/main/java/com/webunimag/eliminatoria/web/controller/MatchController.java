package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.dto.dto.MatchDto;
import com.webunimag.eliminatoria.dto.mapper.MatchMapper;
import com.webunimag.eliminatoria.persistence.entity.MatchEntity;
import com.webunimag.eliminatoria.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/partidos")
public class MatchController {

    private final MatchService matchService;
    private final MatchMapper matchMapper;
    @Autowired
    public MatchController(MatchService matchService, MatchMapper matchMapper) {
        this.matchService = matchService;
        this.matchMapper = matchMapper;
    }
    @GetMapping
    public ResponseEntity<List<MatchDto>> getAll(){
        List<MatchDto> matchesDto = null;

        matchesDto = this.matchService.getAll().stream()
                .map(match -> this.matchMapper.matchEntityToMatchDto(match))
                .collect(Collectors.toList());

        return ResponseEntity.ok(matchesDto);
    }
    @GetMapping("/fecha")
    public ResponseEntity<MatchDto> getByDate(@RequestParam LocalDateTime date){
        MatchDto matchDto = null;
        matchDto = this.matchMapper.matchEntityToMatchDto(
                this.matchService.getByDate(date)
        );
        return ResponseEntity.ok(matchDto);
    }

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

    /*@GetMapping("/nombre/{name}")
    public ResponseEntity<MatchEntity> getByNameTeam(@PathVariable String name){
        return ResponseEntity.ok(this.matchService.getAllMatchByTeamName(name));
    }*/
}
