package com.dl.tacoloco.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.dl.tacoloco.dto.Taco;
import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.entity.TacoOrder;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderCalculatorTest {
    
    @InjectMocks
    OrderCalculator orderCalculator;

    private final String MOCK_CUSTOMER_ID = "MockCustyId";

    @Test
    public void orderCalculatorReturnsCorrectTotal() {
        TacoOrderRequest tacoOrderRequest = this.buildTacoOrderRequest();
        BigDecimal expectedOrderTotal = new BigDecimal("18.00");

        TacoOrder actualTacoOrder = orderCalculator.calculateTacoOrderTotal(tacoOrderRequest);
        
        assertEquals(expectedOrderTotal, actualTacoOrder.getOrderTotal());
    }

    private TacoOrderRequest buildTacoOrderRequest(){
        TacoOrderRequest tacoOrderRequest = new TacoOrderRequest();
        List<Taco> tacos = Arrays.asList(
            new Taco("veggie", 2, new BigDecimal(2.5)),
            new Taco("chicken", 1, new BigDecimal(3)),
            new Taco("veggie", 1, new BigDecimal(3)),
            new Taco("chorizo", 2, new BigDecimal(3.5))
        );
        tacoOrderRequest.setTacos(tacos);
        tacoOrderRequest.setCustomerId(MOCK_CUSTOMER_ID);

        return tacoOrderRequest;
    }
}
