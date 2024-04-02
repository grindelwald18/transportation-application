package com.example.upseh2.services.impl;


import com.example.upseh2.entities.Balance;
import com.example.upseh2.repositories.BalanceRepository;
import com.example.upseh2.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;


    public Page<Balance> getBalances(Pageable pageable) {
        return balanceRepository.findAll(pageable);
    }

    public Balance addBalance(Balance balance) {
        balanceRepository.save(balance);
        return balance;
    }

    public void deleteBalance(long id) {
        balanceRepository.deleteById(id);
    }

    public void updateBalance(long id, Balance updateBalance) {
        updateBalance.setId(id);
        balanceRepository.save(updateBalance);
    }

    public Balance findById(Long id) {
        return balanceRepository.findById(id).orElseThrow();
    }

}
