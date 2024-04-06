package com.example.upseh2.services;

import com.example.upseh2.dtos.BalanceDTO;
import com.example.upseh2.entities.Balance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BalanceService {

    Page<BalanceDTO> getBalances(Pageable pageable);

    BalanceDTO addBalance(BalanceDTO balanceDTO);

    void deleteBalance(long id);

    BalanceDTO updateBalance(long id, BalanceDTO updateBalanceDTO);

    BalanceDTO findById(Long id);

}