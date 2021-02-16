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
    private OrderCalculator orderCalculator;

    private final String MOCK_CUSTOMER_ID = "MockCustyId";

    @Test
    public void orderCalculatorReturnsCorrectTotal() {
        TacoOrderRequest tacoOrderRequest = this.buildTacoOrderRequest(threeTacoOrder());
        BigDecimal expectedOrderTotal = new BigDecimal("8.00");

        TacoOrder actualTacoOrder = orderCalculator.calculateTacoOrderTotal(tacoOrderRequest);
        
        assertEquals(expectedOrderTotal, actualTacoOrder.getOrderTotal());
    }

    @Test
    public void orderCalculatorReturnsCorrectDiscountedTotal() {
        TacoOrderRequest tacoOrderRequest = this.buildTacoOrderRequest(sixTacoOrder());
        BigDecimal expectedOrderTotal = new BigDecimal("14.40");

        TacoOrder actualTacoOrder = orderCalculator.calculateTacoOrderTotal(tacoOrderRequest);
        
        assertEquals(expectedOrderTotal, actualTacoOrder.getOrderTotal());
    }

    private TacoOrderRequest buildTacoOrderRequest(List<Taco> tacos){
        TacoOrderRequest tacoOrderRequest = new TacoOrderRequest();
        tacoOrderRequest.setTacos(tacos);
        tacoOrderRequest.setCustomerId(MOCK_CUSTOMER_ID);

        return tacoOrderRequest;
    }
    
    private List<Taco> threeTacoOrder() {
        return Arrays.asList(
            new Taco("veggie", 2, new BigDecimal(2.5)),
            new Taco("chicken", 1, new BigDecimal(3))
        );
    }

    private List<Taco> sixTacoOrder() {
        return Arrays.asList(
            new Taco("veggie", 2, new BigDecimal(2.5)),
            new Taco("chicken", 1, new BigDecimal(3)),
            new Taco("beef", 1, new BigDecimal(3)),
            new Taco("chorizo", 2, new BigDecimal(3.5))
        );
    }
}
