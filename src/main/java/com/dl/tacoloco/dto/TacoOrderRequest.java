package com.dl.tacoloco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacoOrderRequest {
    
    String customerId;
    Taco[] tacos;
    
}