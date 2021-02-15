package com.dl.tacoloco.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.entity.TacoOrder;
import com.dl.tacoloco.repo.TacoOrderRepository;
import com.dl.tacoloco.util.OrderCalculator;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocoServiceTest {

    @InjectMocks
    private LocoService locoService;

    @Mock
    private TacoOrderRepository mockTacoOrderRepo;

    @Mock
    private OrderCalculator mockOrderCalculator;
    
    private static final String MOCK_CUSTOMER_ID = "El Rey de los Tacos";

    @Test
	public void serviceLoads() {
        System.out.println("loco service test ran");
		assertEquals("Taco service is loco.", locoService.serviceCheck());
	}

    @Test
    public void savesOrderToTacoRepoWithCorrectIds(){
        ArgumentCaptor<TacoOrder> tacoOrderCaptor = ArgumentCaptor.forClass(TacoOrder.class);
        TacoOrderRequest mockTacoOrderRequest = createRequest();
        TacoOrder savedTacoOrder = createSavedTacoOrder();

        when(mockTacoOrderRepo.save(any(TacoOrder.class))).thenReturn(savedTacoOrder);
        when(mockOrderCalculator.calculateTacoOrderTotal(any(TacoOrderRequest.class))).thenReturn(savedTacoOrder);

        TacoOrder actualTacoOrder = locoService.saveOrder(mockTacoOrderRequest);

        verify(mockTacoOrderRepo).save(tacoOrderCaptor.capture());
        assertEquals(tacoOrderCaptor.getValue().getCustomerId(), actualTacoOrder.getCustomerId());
        assertEquals(savedTacoOrder.getOrderId().toString(), actualTacoOrder.getOrderId().toString());
    }

    @Test
    public void passesRequestToCalculator(){
        TacoOrderRequest request = createRequest();    
        TacoOrder savedTacoOrder = createSavedTacoOrder();
        
        when(mockTacoOrderRepo.save(any(TacoOrder.class))).thenReturn(savedTacoOrder);
        when(mockOrderCalculator.calculateTacoOrderTotal(any(TacoOrderRequest.class))).thenReturn(savedTacoOrder);

        locoService.saveOrder(request);

        verify(mockOrderCalculator).calculateTacoOrderTotal(request);
    }

    private TacoOrder createSavedTacoOrder() {
        String mockOrderId = UUID.randomUUID().toString();
        TacoOrder savedTacoOrder = new TacoOrder();
        savedTacoOrder.setCustomerId(MOCK_CUSTOMER_ID);
        savedTacoOrder.setOrderId(UUID.fromString(mockOrderId));
        return savedTacoOrder;
    }

    private TacoOrderRequest createRequest() {
        TacoOrderRequest mockTacoOrderRequest = new TacoOrderRequest();
        mockTacoOrderRequest.setCustomerId(MOCK_CUSTOMER_ID);
        return mockTacoOrderRequest;
    }

}
