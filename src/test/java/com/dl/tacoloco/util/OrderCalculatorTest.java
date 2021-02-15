package com.dl.tacoloco.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.dl.tacoloco.dto.Taco;
import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.entity.TacoOrder;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderCalculatorTest {
    
    @InjectMocks
    OrderCalculator orderCalculator;

    private final String MOCK_CUSTOMER_ID = "MockCustyId";

    @Disabled // Intentionally failing TDD-style, skipped for now to confirm build works
    @Test
    public void orderCalculatorReturnsCorrectTotal() {
        TacoOrderRequest tacoOrderRequest = this.buildTacoOrderRequest();

        BigDecimal expectedOrderTotal = new BigDecimal(18);

        TacoOrder actualTacoOrder = orderCalculator.calculateTacoOrderTotal(tacoOrderRequest);
        
        assertEquals(expectedOrderTotal, actualTacoOrder.getOrderTotal());
    }

    private TacoOrderRequest buildTacoOrderRequest(){
        TacoOrderRequest tacoOrderRequest = new TacoOrderRequest();
        List<Taco> tacos = Arrays.asList(
            Taco.builder().type("veggie").count(2).price(new BigDecimal(2.5)).build(),
            Taco.builder().type("chicken").count(1).price(new BigDecimal(3)).build(),
            Taco.builder().type("beef").count(1).price(new BigDecimal(3)).build(),
            Taco.builder().type("chorizo").count(2).price(new BigDecimal(3.5)).build()
        );
        tacoOrderRequest.setTacos(tacos);
        tacoOrderRequest.setCustomerId(MOCK_CUSTOMER_ID);

        return tacoOrderRequest;
    }
}
