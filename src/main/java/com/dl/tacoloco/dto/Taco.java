package com.dl.tacoloco.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Taco {
    
    String type;
    Integer count;
    BigDecimal price;

}