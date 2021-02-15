package com.dl.tacoloco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dl.tacoloco.dto.*;
import com.dl.tacoloco.entity.TacoOrder;
import com.dl.tacoloco.repo.TacoOrderRepository;

@Service
@Component
public class LocoService {

    @Autowired
    TacoOrderRepository tacoOrderRepository;
    
    public TacoOrder saveOrder(TacoOrderRequest tacoOrderRequest) {
        TacoOrder tacoOrder2 = new TacoOrder();

        // TODO: complete save logic according to failing test

        return tacoOrder2;
    }

    public String serviceCheck() {
        return "Taco service is loco.";
    }
}