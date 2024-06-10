package com.example.upseh2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "delivery_method_id")
    private DeliveryMethod deliveryMethod;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "speed")
    private long speed;

    @Column(name = "transport_name")
    private String transportName;

    @JsonIgnore
    @ManyToOne
    private Transporter transporter;

}
