package com.example.upseh2.entities;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "balances")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "balance", nullable = false)
    private long balance;


}
