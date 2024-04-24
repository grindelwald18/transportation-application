package com.example.upseh2.mappers;

import com.example.upseh2.dtos.BalanceDTO;
import com.example.upseh2.entities.Balance;
import org.mapstruct.Mapper;

@Mapper
public interface BalanceMapper {
    Balance toBalance(BalanceDTO balanceDTO);

    BalanceDTO toBalanceDTO(Balance balance);
}
