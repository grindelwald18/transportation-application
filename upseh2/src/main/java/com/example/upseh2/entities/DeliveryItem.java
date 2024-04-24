package com.example.upseh2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "delivery_items")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class DeliveryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @JsonIgnore
    @ManyToOne
    private Container container;

    @Column(name = "amount")
    private int amount;
}
