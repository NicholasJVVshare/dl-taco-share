package com.dl.tacoloco.controller;

import com.dl.tacoloco.dto.TacoOrderRequest;
import com.dl.tacoloco.dto.TacoOrderResponse;
import com.dl.tacoloco.entity.TacoOrder;
import com.dl.tacoloco.service.LocoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
class TacoController {

    @Autowired
    LocoService locoService;

    @PostMapping(value="/total")
    public ResponseEntity<TacoOrderResponse> calculateOrderTotalPrice(@RequestBody TacoOrderRequest tacoOrderRequest) {
        System.out.println(tacoOrderRequest.getTacos().toString());

        TacoOrder tacoOrder = locoService.saveOrder(tacoOrderRequest);
        TacoOrderResponse orderResponse = createResponseFromOrder(tacoOrder);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @GetMapping(value="/tacos")
    public ResponseEntity<String> getTacos() {
        return new ResponseEntity<String>("TACOS", HttpStatus.OK);
    }
    
    private TacoOrderResponse createResponseFromOrder(TacoOrder order){
        return new TacoOrderResponse(
            order.getOrderId().toString(), 
            order.getCustomerId(), 
            order.getOrderTotal()
        );
    }
    
}