package com.example.upseh2.services;

import com.example.upseh2.entities.Balance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BalanceService {

    Page<Balance> getBalances(Pageable pageable);

    Balance addBalance(Balance balance);

    void deleteBalance(long id);

    void updateBalance(long id, Balance updateBalance);

    Balance findById(Long id);

}