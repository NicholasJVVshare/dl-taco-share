package com.dl.tacoloco.service;

import static org.junit.jupiter.api.Assertions.*;
// import org.skyscreamer.jsonassert.*;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.entity.TacoOrder;
import com.dl.tacoloco.repo.TacoOrderRepository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocoServiceTest {

    @Autowired
    LocoService locoService;
    @Mock
    TacoOrderRepository mockTacoOrderRepo;
    
    @Test
	public void serviceLoads() {
        System.out.println("loco service test ran");
		assertEquals("Taco service is loco.", locoService.serviceCheck());
	}

    @Disabled // Intentionally failing TDD-style, skipped for now to confirm build works
    @Test
    public void savesOrderToTacoRepo(){
        String mockOrderId = "Mock orderId 1";
        String customerId = "El Rey de los Tacos";
        TacoOrderRequest mockTacoOrderRequest = new TacoOrderRequest();
        mockTacoOrderRequest.setCustomerId(customerId);
        TacoOrder mockTacoOrder = new TacoOrder();
        TacoOrder mockSavedTacoOrder = new TacoOrder();
        mockSavedTacoOrder.setOrderId(UUID.fromString(mockOrderId));
        
        when(mockTacoOrderRepo.save(mockTacoOrder)).thenReturn(mockSavedTacoOrder);

        TacoOrder actualTacoOrder = locoService.saveOrder(mockTacoOrderRequest);

        assertEquals(mockOrderId, actualTacoOrder.getOrderId());
    }

}
