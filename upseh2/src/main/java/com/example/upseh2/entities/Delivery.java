package com.example.upseh2.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;


@Entity
@Table(name = "deliveries")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "final_point")
    private String finalPoint;

    @Column(name = "distance")
    private int distance;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Container> container;

}