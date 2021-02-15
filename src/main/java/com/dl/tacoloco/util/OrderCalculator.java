package com.dl.tacoloco.util;

import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.entity.TacoOrder;

import org.springframework.stereotype.Component;

@Component
public class OrderCalculator {
    
    public TacoOrder calculateTacoOrderTotal(TacoOrderRequest tacoOrderRequest){
        return new TacoOrder();
    }

}
