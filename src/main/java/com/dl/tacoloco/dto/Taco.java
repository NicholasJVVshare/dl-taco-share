package com.dl.tacoloco.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Taco {
    
    String type;
    Integer count;
    BigDecimal price;

}