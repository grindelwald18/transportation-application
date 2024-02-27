package com.example.upseh2.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transports")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private DeliveryMethod deliveryMethod;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "speed")
    private int speed;

    @Column(name = "transport_name")
    private String transportName;

    @ManyToOne
    @JoinColumn(name = "transporter_id")
    private Transporter transporter;
}
