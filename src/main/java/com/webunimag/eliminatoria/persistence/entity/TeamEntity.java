package com.webunimag.eliminatoria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "teams")
@Setter
@Getter
@NoArgsConstructor
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team", nullable = false, length = 30)
    private Integer idTeam;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(name = "country_flag",length = 250)
    private String countryFlagUrl;
    @Column(length = 50)
    private String dt;

    //   ---- Relaciones
    @OneToMany(mappedBy = "localTeam")
    private List<MatchEntity> localMatches;

    @OneToMany(mappedBy = "visitingTeam")
    private List<MatchEntity> visitingMatches;


}
