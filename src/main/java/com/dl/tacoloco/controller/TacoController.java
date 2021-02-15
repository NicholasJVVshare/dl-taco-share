package com.dl.tacoloco.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

import com.dl.tacoloco.dto.*;
import com.dl.tacoloco.entity.TacoOrder;
import com.dl.tacoloco.service.LocoService;

@Component
@RestController
class TacoController {

    @Autowired
    LocoService locoService;

    @PostMapping(value="/total")
    public ResponseEntity<TacoOrderResponse> calculateOrderTotalPrice(@RequestBody TacoOrderRequest tacoOrderRequest) {
        System.out.println(tacoOrderRequest.getTacos().toString());
        BigDecimal total = new BigDecimal("20.50");

        TacoOrder tacoOrder = locoService.saveOrder(tacoOrderRequest);

        TacoOrderResponse orderTotalResponse = new TacoOrderResponse();
        orderTotalResponse.setTotal(total);
        orderTotalResponse.setCustomerId(tacoOrderRequest.getCustomerId());
        orderTotalResponse.setOrderId(tacoOrder.getOrderId().toString());

        return new ResponseEntity<>(orderTotalResponse, HttpStatus.OK);
    }

    @GetMapping(value="/tacos")
    public ResponseEntity<String> getTacos() {

        return new ResponseEntity<String>("TACOS", HttpStatus.OK);
    }
    
}