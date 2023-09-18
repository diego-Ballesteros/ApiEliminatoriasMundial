package com.webunimag.eliminatoria.persistence.repository;

import com.webunimag.eliminatoria.persistence.entity.TeamEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends ListCrudRepository<TeamEntity, Integer> {

    Optional<TeamEntity> getByNameIgnoreCase(String name);

      /* @Query(value = "SELECT " +
            "te.name AS nameTeam, " +
            "GROUP_CONCAT(ma.date) AS dateMatches" +
            "   FROM teams te " +
            "       INNER JOIN matches ma ON te.id_team = ma.id_local" +
            //"       INNER JOIN results  ON ma.id_result = rl.id_resul" +
            "   WHERE te.name = :nameTeam" +
            "   ORDER BY ma.date", nativeQuery = true)
   MatchEntity findAllMatchByTeamName(@Param("nameTeam") String nameTeam);*/
    @Query(value = "SELECT count(*) as partidosDeLocal " +
            "FROM teams te " +
            "INNER JOIN matches mt ON te.id_team = mt.id_local " +
            "WHERE te.name = :name "
            ,nativeQuery = true)
    int countISLocal(@Param("name") String name);
}
