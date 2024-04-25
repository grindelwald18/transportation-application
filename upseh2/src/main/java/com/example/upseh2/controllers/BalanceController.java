package com.example.upseh2.controllers;

import com.example.upseh2.dtos.BalanceDTO;
import com.example.upseh2.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<BalanceDTO> getBalances(Pageable pageable) {
        return balanceService.getBalances(pageable);
    }

//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public BalanceDTO getBalanceById(@PathVariable long id){
//        return balanceService.findById(id);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public BalanceDTO addBalance(@RequestBody BalanceDTO balanceDTO) {
//        return balanceService.addBalance(balanceDTO);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delBalance(@PathVariable long id) {
       balanceService.deleteBalance(id);
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public BalanceDTO updateBalance(@PathVariable long id, @RequestBody BalanceDTO balanceDTO) {
//        return balanceService.updateBalance(id, balanceDTO);
//    }
}