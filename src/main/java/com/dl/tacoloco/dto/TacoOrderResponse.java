package com.dl.tacoloco.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacoOrderResponse {

    String orderId;
    String customerId;
    BigDecimal total;

}
