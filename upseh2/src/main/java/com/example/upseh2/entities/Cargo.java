package com.example.upseh2.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cargos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "length")
    private int length;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private long weight;

    @Column(name = "name")
    private String name;

    @Column(name = "nature")
    private boolean nature;

}
