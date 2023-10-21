package com.webunimag.eliminatoria.persistence.entity.AutenticationEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter

public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Enumerated -> especifica que es un Enum
    // (EnumType.STRING) -> toma en cuenta no la posicion si no el valor en este caso string
    @Enumerated(EnumType.STRING)
    private ERole name;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

    public Role(ERole name) {
        this.name = name;
    }
}
