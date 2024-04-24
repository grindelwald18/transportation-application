package com.example.upseh2.entities;

import com.example.upseh2.dtos.DeliveryItemIdDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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

    private final int containerLength = 500;

    private final int containerWidth = 200;

    private final int containerHeight = 250;

    @JsonIgnore
    @ManyToOne
    private Delivery delivery;

    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    private List<DeliveryItem> deliveryItems;
}