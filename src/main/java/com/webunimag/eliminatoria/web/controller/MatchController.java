package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.dto.dto.MatchDto;
import com.webunimag.eliminatoria.dto.mapper.MatchMapper;
import com.webunimag.eliminatoria.persistence.entity.MatchEntity;
import com.webunimag.eliminatoria.service.MatchService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Validated
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
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<MatchDto>> getAll(){
        List<MatchDto> matchesDto = null;

        matchesDto = this.matchService.getAll().stream()
                .map(match -> this.matchMapper.matchEntityToMatchDto(match))
                .collect(Collectors.toList());

        return ResponseEntity.ok(matchesDto);
    }
    @GetMapping("/fecha")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MatchDto> getByDate(@RequestParam LocalDateTime date){
        MatchDto matchDto = null;
        matchDto = this.matchMapper.matchEntityToMatchDto(
                this.matchService.getByDate(date)
        );
        return ResponseEntity.ok(matchDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MatchDto> addMatch( @RequestBody @Valid MatchEntity match){
        if(match.getIdMatch() == null || !this.matchService.existByIdMatch(match.getIdMatch())){
            MatchEntity matchCreated = this.matchService.saveMatch(match);
            MatchDto matchDto = this.matchMapper.matchEntityToMatchDto(matchCreated);
            return ResponseEntity.ok(matchDto);
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MatchDto> updateMatch( @RequestBody @Valid MatchEntity match){
        if(match.getIdMatch() != null && this.matchService.existByIdMatch(match.getIdMatch())){
            MatchEntity matchCreated = this.matchService.saveMatch(match);
            MatchDto matchDto = this.matchMapper.matchEntityToMatchDto(matchCreated);
            return ResponseEntity.ok(matchDto);
        }
        return ResponseEntity.badRequest().build();
    }

}
