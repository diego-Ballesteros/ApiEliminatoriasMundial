package com.webunimag.eliminatoria.persistence.entity.AutenticationEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Este dato es obligatorio")
    @Size(min = 5, message = "Este dato debe terner minimo 5 caracteres")
    private String userName;

    @NotBlank(message = "Este dato es obligatorio")
    @Size(min = 5, message = "Este dato debe terner minimo 5 caracteres")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 5, message = "Este dato debe terner minimo 5 caracteres")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    public UserEntity(String username, String email, String password, Set<Role> roles) {
        this.userName = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserEntity(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.password = password;
    }
}
