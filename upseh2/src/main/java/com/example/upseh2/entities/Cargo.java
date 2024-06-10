package com.example.upseh2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cargos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public Cargo(int length, int width, int height, int weight, String name, boolean b) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.nature = b;
    }
}
