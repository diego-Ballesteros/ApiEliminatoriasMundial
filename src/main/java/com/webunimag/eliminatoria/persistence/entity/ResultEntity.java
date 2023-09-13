package com.webunimag.eliminatoria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "results")
@Getter
@Setter
@NoArgsConstructor
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_result", nullable = false, length = 30)
    private Integer idResult;
    @Column(name = "goal_local")
    private Integer goalLocal;
    @Column(name = "goal_visiting")
    private Integer goalVisiting;
    @Column(name = "n_red_flag", length = 11)
    private Integer nRedFlag;

    @Column(name = "n_yellow_flag", length = 44)
    private Integer nYellowFlag;
}
