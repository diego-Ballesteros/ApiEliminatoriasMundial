package com.webunimag.eliminatoria.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_result", nullable = false, length = 30)
    private Integer idResult;
    @Column(name = "goal_local")
    @PositiveOrZero
    private Integer goalLocal;
    @Column(name = "goal_visiting")
    @PositiveOrZero
    private Integer goalVisiting;
    @Column(name = "n_red_flag", length = 11)
    @PositiveOrZero
    private Integer nRedFlag;
    @Column(name = "n_yellow_flag", length = 44)
    @PositiveOrZero
    private Integer nYellowFlag;

}