package com.dl.tacoloco.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TacoOrderResponse {

    String orderId;
    String customerId;
    BigDecimal total;

}
