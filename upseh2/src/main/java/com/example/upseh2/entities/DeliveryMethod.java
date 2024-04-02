package com.example.upseh2.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "delivery_methods")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class DeliveryMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "method")
    private String method;

    @Column(name = "tariff")
    private int tariff;

}

