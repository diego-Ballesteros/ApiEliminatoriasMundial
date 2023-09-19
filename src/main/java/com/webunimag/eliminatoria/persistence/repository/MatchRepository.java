package com.webunimag.eliminatoria.persistence.repository;

import com.webunimag.eliminatoria.persistence.entity.MatchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface MatchRepository extends ListCrudRepository<MatchEntity, Integer> {

   /* @Query(value = "SELECT " +
            "te.name AS nameTeam, " +
            "GROUP_CONCAT(ma.date) AS dateMatches" +
            "   FROM teams te " +
            "       INNER JOIN matches ma ON te.id_team = ma.id_local" +
            //"       INNER JOIN results  ON ma.id_result = rl.id_resul" +
            "   WHERE te.name = :nameTeam" +
            "   ORDER BY ma.date", nativeQuery = true)
   MatchEntity findAllMatchByTeamName(@Param("nameTeam") String nameTeam);*/

    Optional<MatchEntity> findAllByDate(LocalDateTime date);



}
