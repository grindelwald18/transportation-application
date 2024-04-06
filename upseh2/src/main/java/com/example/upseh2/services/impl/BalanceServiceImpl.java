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


@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;


    public Page<BalanceDTO> getBalances(Pageable pageable) {
        return balanceRepository.findAll(pageable)
                .map(balanceMapper::toBalanceDTO);
    }

    public BalanceDTO addBalance(BalanceDTO balanceDTO) {
        Balance balance = balanceMapper.toBalance(balanceDTO);
        balanceRepository.save(balance);
        return balanceMapper.toBalanceDTO(balance);
    }

    public void deleteBalance(long id) {
        balanceRepository.deleteById(id);
    }

    public BalanceDTO updateBalance(long id, BalanceDTO updateBalanceDTO) {
        Balance updateBalance = balanceMapper.toBalance(updateBalanceDTO);
        updateBalance.setId(id);
        return balanceMapper.toBalanceDTO(balanceRepository.save(updateBalance));
    }

    public BalanceDTO findById(Long id) {
        return balanceRepository.findById(id)
                .map(balanceMapper::toBalanceDTO)
                .orElseThrow();
    }
}