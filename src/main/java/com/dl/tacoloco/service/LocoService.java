package com.dl.tacoloco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (tacoOrderRequest.getTacos().isEmpty()){
            throw new RuntimeException("This order does not have any tacos in it.");
        }
        String customerId = tacoOrderRequest.getCustomerId();
        if (customerId.isBlank()) { tacoOrderRequest.setCustomerId("Anonymous");}

        TacoOrder orderWithTotal = orderCalculator.calculateTacoOrderTotal(tacoOrderRequest);
        orderWithTotal.setCustomerId(tacoOrderRequest.getCustomerId());

        TacoOrder savedOrder = this.tacoOrderRepository.save(orderWithTotal);

        return savedOrder;
    }

    public List<TacoOrder> getAllOrders() {
        return tacoOrderRepository.findAll();
    }
}