package com.dl.tacoloco.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Taco {
    
    String type;
    Integer count;
    // TODO: move price to constant file - should UI have to know this?
    BigDecimal price;

}