package com.webunimag.eliminatoria.persistence.repository;

import com.webunimag.eliminatoria.persistence.entity.AutenticationEntity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


public interface UserRepository extends ListCrudRepository<UserEntity,Long> {

    Optional<UserEntity> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}
