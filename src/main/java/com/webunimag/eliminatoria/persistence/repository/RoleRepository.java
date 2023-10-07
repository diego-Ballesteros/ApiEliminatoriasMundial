package com.webunimag.eliminatoria.persistence.repository;

import com.webunimag.eliminatoria.persistence.entity.AutenticationEntity.ERole;
import com.webunimag.eliminatoria.persistence.entity.AutenticationEntity.Role;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RoleRepository extends ListCrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
