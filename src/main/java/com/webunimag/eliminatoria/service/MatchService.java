package com.webunimag.eliminatoria.service;

import com.webunimag.eliminatoria.exceptions.TeamNotFoundException;
import com.webunimag.eliminatoria.persistence.entity.MatchEntity;
import com.webunimag.eliminatoria.persistence.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchEntity> getAll(){
        return this.matchRepository.findAll();
    }

    public MatchEntity getByDate(LocalDateTime date){
        return this.matchRepository.findAllByDate(date).
                orElseThrow(()-> new TeamNotFoundException("no se encontro partido con esta fecha"));
    }

   /* public MatchEntity getAllMatchByTeamName(String name){
        return this.matchRepository.findAllMatchByTeamName(name);
                //.orElseThrow(()-> new RuntimeException("no hay partidos de este equipo"));
    }*/

    public boolean existByIdMatch(int idMatch){
        return this.matchRepository.existsById(idMatch);
    }

    public MatchEntity saveMatch (MatchEntity match){

        return this.matchRepository.save(match);
    }
}
