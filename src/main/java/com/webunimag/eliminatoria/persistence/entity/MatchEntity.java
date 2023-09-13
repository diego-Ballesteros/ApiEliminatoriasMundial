package com.webunimag.eliminatoria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@Getter
@Setter
@NoArgsConstructor
public class MatchEntity {
    @Id
    @Column(name = "id_match", nullable = false, length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatch;

    @Column(nullable = false, length = 50)
    private String stadium;
    @Column(length = 50)
    private String referee;
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;
    //    ---- llaves foraneas
    @Column(name = "id_local", nullable = false)
    private Integer idLocal;
    @Column(name = "id_visiting", nullable = false)
    private Integer idVisiting;
    @Column(name = "id_result", nullable = false)
    private Integer idResult;

    //    ----- Relaciones
    @OneToOne
    @JoinColumn(name = "id_result", referencedColumnName = "id_result",
            insertable = false,
            updatable = false )
    private ResultEntity result;

    @ManyToOne
    @JoinColumn(name = "id_local", referencedColumnName = "id_team",
            insertable = false,
            updatable = false)
    @JsonIgnore
    private TeamEntity localTeam;

   @ManyToOne
    @JoinColumn(name = "id_visiting", referencedColumnName = "id_team",
            insertable = false,
            updatable = false)
   @JsonIgnore
    private TeamEntity visitingTeam;


}
