package com.example.upseh2.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


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
    private BigDecimal balance;

    public Balance(BigDecimal balance) {
        this.balance = balance;
    }

}
