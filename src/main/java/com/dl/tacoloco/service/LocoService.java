package com.dl.tacoloco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dl.tacoloco.dto.*;
import com.dl.tacoloco.entity.TacoOrder;
import com.dl.tacoloco.repo.TacoOrderRepository;
import com.dl.tacoloco.util.OrderCalculator;

@Service
@Component
public class LocoService {

    @Autowired
    TacoOrderRepository tacoOrderRepository;

    @Autowired
    OrderCalculator orderCalculator;
    
    public TacoOrder saveOrder(TacoOrderRequest tacoOrderRequest) {
        TacoOrder tacoOrderToSave = new TacoOrder();
        tacoOrderToSave.setCustomerId(tacoOrderRequest.getCustomerId());

        // TODO: make calculator to calculate order total 

        TacoOrder savedOrder = this.tacoOrderRepository.save(tacoOrderToSave);

        return savedOrder;
    }

    public String serviceCheck() {
        return "Taco service is loco.";
    }
}