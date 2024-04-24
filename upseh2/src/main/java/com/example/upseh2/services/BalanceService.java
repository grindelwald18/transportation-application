package com.example.upseh2.services;

import com.example.upseh2.dtos.BalanceDTO;
import com.example.upseh2.entities.Balance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;


public interface BalanceService {

    Page<BalanceDTO> getBalances(Pageable pageable);

    Balance addBalance(BigDecimal balance);

    void deleteBalance(long id);

    Balance updateBalance(long id, BigDecimal balance);

    Balance findById(Long id);

}