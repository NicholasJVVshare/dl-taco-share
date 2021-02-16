package com.dl.tacoloco.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

import com.dl.tacoloco.dto.Taco;
import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.entity.TacoOrder;

import org.springframework.stereotype.Component;

@Component
public class OrderCalculator {

    private final BigDecimal DISCOUNT_RATIO = new BigDecimal("0.80");
    private final int DISCOUNT_ITEM_COUNT = 4;

    public TacoOrder calculateTacoOrderTotal(TacoOrderRequest tacoOrderRequest) {
        TacoOrder newTacoOrder = new TacoOrder();
        List<Taco> tacos = tacoOrderRequest.getTacos();

        BigDecimal runningTotal = new BigDecimal(BigInteger.ZERO, 2);
        int totalTacoCount = 0;
        
        for (Taco taco: tacos) {
            BigDecimal countOfCurrentTacoType = new BigDecimal(taco.getCount());
            BigDecimal currentTypeTotal = new BigDecimal(BigInteger.ZERO, 2);
            totalTacoCount = totalTacoCount + taco.getCount();
            currentTypeTotal = currentTypeTotal.add(countOfCurrentTacoType.multiply(taco.getPrice()));
            runningTotal = runningTotal.add(currentTypeTotal);
        }

        if(totalTacoCount >= DISCOUNT_ITEM_COUNT){
            runningTotal = applyStandardDiscount(runningTotal);
        }
        
        newTacoOrder.setOrderTotal(runningTotal);
        newTacoOrder.setCustomerId(tacoOrderRequest.getCustomerId());
        
        return newTacoOrder;
    }

    private BigDecimal applyStandardDiscount(BigDecimal subtotal){
        BigDecimal total = subtotal.multiply(DISCOUNT_RATIO);
        return total.setScale(2, RoundingMode.HALF_UP);
    }

}
