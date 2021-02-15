package com.dl.tacoloco.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.dl.tacoloco.dto.Taco;
import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.entity.TacoOrder;

import org.springframework.stereotype.Component;

@Component
public class OrderCalculator {

    private final BigDecimal FOUR_OR_MORE_DISCOUNT = new BigDecimal(0.8);

    public TacoOrder calculateTacoOrderTotal(TacoOrderRequest tacoOrderRequest) {
        TacoOrder newTacoOrder = new TacoOrder();
        List<Taco> tacos = tacoOrderRequest.getTacos();

        BigDecimal runningTotal = new BigDecimal(BigInteger.ZERO, 2);
        BigDecimal totalTacoCount = new BigDecimal(BigInteger.ZERO);
        
        for (Taco taco: tacos) {
            BigDecimal countOfCurrentTacoType = new BigDecimal(taco.getCount());
            BigDecimal subtotal = new BigDecimal(BigInteger.ZERO, 2);
            totalTacoCount = totalTacoCount.add(countOfCurrentTacoType);
            subtotal = subtotal.add(countOfCurrentTacoType.multiply(taco.getPrice()));
            runningTotal = runningTotal.add(subtotal);
        }
        
        newTacoOrder.setOrderTotal(runningTotal);
        System.out.println(newTacoOrder.toString());

        return newTacoOrder;
    }

}
