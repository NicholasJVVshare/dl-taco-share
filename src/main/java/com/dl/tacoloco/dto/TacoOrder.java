package com.dl.tacoloco.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacoOrder {
    
    private String orderId;
    private BigDecimal orderTotal;
    
}