package com.webunimag.eliminatoria.persistence.repository;

import com.webunimag.eliminatoria.persistence.entity.TeamEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface TeamRepository extends ListCrudRepository<TeamEntity, Integer> {

    Optional<TeamEntity> getByNameIgnoreCase(String name);


}
