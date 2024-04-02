package com.example.upseh2.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "containers")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "container_length")
    private int containerLength;

    @Column(name = "container_width")
    private int containerWidth;

    @Column(name = "container_height")
    private int containerHeight;

    @OneToOne
    @PrimaryKeyJoinColumn
    private DeliveryMethod deliveryMethod;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Column(name = "cargo_amount")
    private int cargoAmount;

}