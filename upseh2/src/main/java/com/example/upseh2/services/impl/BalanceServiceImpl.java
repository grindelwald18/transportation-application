package com.example.upseh2.services.impl;


import com.example.upseh2.dtos.BalanceDTO;
import com.example.upseh2.entities.Balance;
import com.example.upseh2.mappers.BalanceMapper;
import com.example.upseh2.repositories.BalanceRepository;
import com.example.upseh2.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;


    public Page<BalanceDTO> getBalances(Pageable pageable) {
        return balanceRepository.findAll(pageable)
                .map(balanceMapper::toBalanceDTO);
    }

    public Balance addBalance(BigDecimal initialBalance) {
        Balance balance = new Balance(initialBalance);
        return balanceRepository.save(balance);
    }

    public void deleteBalance(long id) {
        balanceRepository.deleteById(id);
    }

    public Balance updateBalance(long id, BigDecimal updateBalance) {
        Balance balance = balanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Balance with id " + id + " not found"));
        balance.setBalance(updateBalance);
        return balanceRepository.save(balance);
    }

    public Balance findById(Long id) {
        return balanceRepository.findById(id)
                .orElseThrow();
    }
}