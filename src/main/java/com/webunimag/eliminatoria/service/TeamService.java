package com.webunimag.eliminatoria.service;

import com.webunimag.eliminatoria.persistence.entity.TeamEntity;
import com.webunimag.eliminatoria.persistence.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamEntity> getAll(){

        return this.teamRepository.findAll();
    }

    public TeamEntity getByName(String name){
        return this.teamRepository.getByNameIgnoreCase(name)
                .orElseThrow(()-> new RuntimeException("el equipo no existe"));
    }

    public TeamEntity saveTeam(TeamEntity team){
        return this.teamRepository.save(team);
    }

    public Boolean existTeamById(int idTeam){
        return this.teamRepository.existsById(idTeam);
    }

    public void deleteTeam(int idTeam){
        this.teamRepository.deleteById(idTeam);
    }

}
